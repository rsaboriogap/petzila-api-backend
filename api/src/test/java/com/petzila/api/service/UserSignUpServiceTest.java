package com.petzila.api.service;

import com.petzila.api.model.XSignUp;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;

@RunWith(Arquillian.class)
public class UserSignUpServiceTest {
    @Inject
    private UserSignUpService userSignUpService;

    @Deployment
    public static WebArchive createDeployment() {
        File[] dependencies = Maven.resolver()
                .resolve("org.slf4j:slf4j-simple:1.7.7")
                .withoutTransitivity()
                .asFile();

        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(UserSignUpService.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        war.addAsLibraries(dependencies);
        return war;
    }

    @Test
    public void testUserSignUpHappyPath() {
        XSignUp xsu = new XSignUp();
        userSignUpService.signUp(xsu);
    }
}
