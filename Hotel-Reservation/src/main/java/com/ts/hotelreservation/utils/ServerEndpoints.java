package com.ts.hotelreservation.utils;

public class ServerEndpoints
{
    public static final String BASE_URL = "http://localhost:8080/CRM/";
    public static String USER_AGENT;
    public static final int SALES = 1;
    public static final int OPERATION_HEAD = 4;
    
    static {
        ServerEndpoints.USER_AGENT = "Mozilla/5.0";
    }
}