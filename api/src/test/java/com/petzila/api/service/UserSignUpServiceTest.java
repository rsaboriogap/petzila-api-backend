package com.petzila.api.service;

import com.petzila.api.domain.User;
import com.petzila.api.exception.NotFoundException;
import com.petzila.api.model.XSignUp;
import com.petzila.api.service.impl.IndieUserFinderImpl;
import com.petzila.api.service.impl.UserFinderImpl;
import com.petzila.api.service.impl.UserSignUpServiceImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.transaction.UserTransaction;
import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class UserSignUpServiceTest {
    @Inject
    private UserTransaction utx;
    @Inject
    private UserSignUpService userSignUpService;

    @Deployment
    public static WebArchive createDeployment() {
        File[] dependencies = Maven.resolver()
                .resolve("org.slf4j:slf4j-simple:1.7.7")
                .withoutTransitivity()
                .asFile();

        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(XSignUp.class.getPackage())
                .addPackage(User.class.getPackage())
                .addPackage(NotFoundException.class.getPackage())
                .addPackage(UserFinder.class.getPackage())
                .addPackage(UserFinderImpl.class.getPackage())
                .addPackage(IndieUserFinder.class.getPackage())
                .addPackage(IndieUserFinderImpl.class.getPackage())
                .addPackage(UserSignUpService.class.getPackage())
                .addPackage(UserSignUpServiceImpl.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/queries/indie-user-finder-queries.xml", "META-INF/queries/indie-user-finder-queries.xml")
                .addAsResource("META-INF/queries/user-finder-queries.xml", "META-INF/queries/user-finder-queries.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");

        war.addAsLibraries(dependencies);
        return war;
    }

    @Test
    public void testUserSignUpHappyPath() {
        XSignUp xsu = new XSignUp();
        xsu.setUsername("john.doe");
        xsu.getName().setFirstName("John");
        xsu.getName().setLastName("Doe");
        xsu.setEmail("john.doe@petzila.com");
        User u = userSignUpService.signUp(xsu);

        assertNotNull(u);
        assertNotNull(u.getId());
        assertEquals(xsu.getUsername(), u.getUsername());
        assertEquals(xsu.getName().getFirstName(), u.getFirstName());
        assertEquals(xsu.getName().getLastName(), u.getLastName());
        assertEquals(xsu.getEmail(), u.getEmail());
        //@TODO etc
    }
}
