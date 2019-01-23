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

import java.text.ParseException;

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
        try{
            Cloth cloth = new Cloth("T-shirt name", "2018-10-10",10.00,true);
            given().
                    contentType(MediaType.APPLICATION_JSON).
                    body(cloth).
                    when().
                    post("/cloth/").then().assertThat().statusCode(201);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void removeCloth(){
        delete("/cloth/5").then().assertThat().statusCode(200);
    }

    @Test
    public void getClothById(){
        get("/cloth/2").then().assertThat().statusCode(200);
    }

}
