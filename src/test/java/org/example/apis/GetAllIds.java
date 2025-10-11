package org.example.apis;

import pojo.GetAllIdsPojo;

public class GetAllIds {

    private String endPoint = "/booking";
    private GetAllIdsPojo getAllIdsPojo;
    private String expectedToken;

    public GetAllIdsPojo getAllIdsPojo() {
        return getAllIdsPojo;
    }

    public void setAllIdsPojo(GetAllIdsPojo getAllIdsPojo) {
        this.getAllIdsPojo = getAllIdsPojo;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setToken(String token) {
        this.expectedToken = token;
    }

    public String getToken() {
        return expectedToken;
    }
}
