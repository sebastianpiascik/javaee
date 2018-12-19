package pl.spiascik.ug.clothesapp;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pl.spiascik.ug.clothesapp.domain.Cloth;
import com.jayway.restassured.RestAssured;

public class ClothServiceIT {

    private static final String PERSON_FIRST_NAME = "Jasiu";
    private static final String PERSON_LAST_NAME = "Przyslowiowy-Kowalski";

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/clothesapp/api";
    }


    @Test
    public void addCloth(){
//        delete("/person/").then().assertThat().statusCode(200);
//
//        Person person = new Person(PERSON_FIRST_NAME, PERSON_LAST_NAME, 1976);
//
//        given().
//                contentType(MediaType.APPLICATION_JSON).
//                body(person).
//                when().
//                post("/person/").then().assertThat().statusCode(201);
    }

}
