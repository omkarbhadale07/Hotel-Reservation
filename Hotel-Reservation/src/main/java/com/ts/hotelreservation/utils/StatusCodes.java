package com.ts.hotelreservation.utils;

public class StatusCodes
{
    public static int OPERATIONSUCCESSFULL;
    public static int UNKNOWNERROR;
    public static int WRONGLOGINCREDENTIALS;
    public static int ADMINNOTLOGGEDIN;
    public static int USERWITHEMAILIDALREADYEXIST;
    public static int CUSTOMERNOTEXIST;
    public static int WRONGCUSTOMERCREDENTIALS;
    public static int CUSTOMERNOTLOGGEDIN;
    public static int SUPERADMINNOTEXIST;
    public static int ITERNARYNOTEXIST;
   
    
    
    
    static {
        StatusCodes.OPERATIONSUCCESSFULL = 1;
        StatusCodes.UNKNOWNERROR = -1;
        StatusCodes.WRONGLOGINCREDENTIALS = -2;
        StatusCodes.ADMINNOTLOGGEDIN = -3;
        StatusCodes.USERWITHEMAILIDALREADYEXIST = -4;
        StatusCodes.CUSTOMERNOTEXIST = -5;
        StatusCodes.WRONGCUSTOMERCREDENTIALS = -6;
        StatusCodes.CUSTOMERNOTLOGGEDIN = -7;
        StatusCodes.SUPERADMINNOTEXIST = -8;
        StatusCodes.ITERNARYNOTEXIST = -9;
    }
}