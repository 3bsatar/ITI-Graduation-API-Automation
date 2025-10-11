package org.example.tests;

import io.restassured.response.Response;
import org.example.apis.TokenApi;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pojo.CreateTokenPojo;

public class BaseTest {
    protected String token;

    @BeforeClass
    public void setupToken() {
        CreateTokenPojo tokenData = new CreateTokenPojo();
        tokenData.setUsername("admin");
        tokenData.setPassword("password123");

        TokenApi tokenApi = new TokenApi();
        Response tokenResponse = tokenApi.createToken(tokenData);

        tokenResponse.prettyPrint();
        Assert.assertEquals(tokenResponse.statusCode(), 200, "Token generation failed!");

        token = tokenResponse.jsonPath().getString("token");
        System.out.println("✅ Token Generated: " + token);
    }
}
