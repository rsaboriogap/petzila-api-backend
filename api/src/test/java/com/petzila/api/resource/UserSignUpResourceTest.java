package com.petzila.api.resource;

import com.petzila.api.domain.User;
import com.petzila.api.exception.NotFoundException;
import com.petzila.api.mapper.XSignUpMapper;
import com.petzila.api.model.XSignUp;
import com.petzila.api.model.response.XSignUpResponse;
import com.petzila.api.producer.DozerMapperProducer;
import com.petzila.api.resource.impl.UserSignUpResourceImpl;
import com.petzila.api.service.IndieUserFinder;
import com.petzila.api.service.UserFinder;
import com.petzila.api.service.UserSignUpService;
import com.petzila.api.service.impl.IndieUserFinderImpl;
import com.petzila.api.service.impl.UserFinderImpl;
import com.petzila.api.service.impl.UserSignUpServiceImpl;
import org.apache.http.HttpStatus;
import org.dozer.DozerBeanMapper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class UserSignUpResourceTest {
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(XSignUp.class.getPackage())
                .addPackage(XSignUpResponse.class.getPackage())
                .addPackage(XSignUpMapper.class.getPackage())
                .addPackage(DozerMapperProducer.class.getPackage())
                .addPackage(DozerBeanMapper.class.getPackage())
                .addPackage(User.class.getPackage())
                .addPackage(NotFoundException.class.getPackage())
                .addPackage(UserFinder.class.getPackage())
                .addPackage(UserFinderImpl.class.getPackage())
                .addPackage(IndieUserFinder.class.getPackage())
                .addPackage(IndieUserFinderImpl.class.getPackage())
                .addPackage(UserSignUpService.class.getPackage())
                .addPackage(UserSignUpServiceImpl.class.getPackage())
                .addPackage(UserSignUpResource.class.getPackage())
                .addPackage(UserSignUpResourceImpl.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/queries/indie-user-finder-queries.xml", "META-INF/queries/indie-user-finder-queries.xml")
                .addAsResource("META-INF/queries/user-finder-queries.xml", "META-INF/queries/user-finder-queries.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @Test
    public void testSignUpHappyPath(@ArquillianResteasyResource UserSignUpResource userSignUpResource) {
        // Given
        XSignUp xsu = new XSignUp();
        xsu.setUsername("john.doe");
        xsu.getName().setFirstName("John");
        xsu.getName().setLastName("Doe");
//        xsu.setEmail("john.doe@petzila.com");

        // When
        Response result = userSignUpResource.signup(xsu);

        // Then
        assertNotNull(result);
//        assertEquals(HttpStatus.SC_CREATED, result.getStatus());
//        XSignUpResponse xsur = result.readEntity(XSignUpResponse.class);
//        assertNotNull(xsur);
//        assertEquals(XStatusType.SUCCESS, xsur.getStatus());
    }
}
