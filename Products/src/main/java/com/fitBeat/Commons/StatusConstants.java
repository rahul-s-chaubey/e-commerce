package com.fitBeat.Commons;

import java.math.BigDecimal;

public class StatusConstants
{
    private StatusConstants(){}

    public static String PM_USER_CREATED_MSG = "User Created";
    public static Integer PM_USER_CREATED_CODE = 1000;


    public static String PM_USER_CREATION_BAD_REQUEST_MSG = "Bad Request, Unable to create User";
    public static Integer PM_USER_CREATION_BAD_REQUEST_CODE = 1001;


    public static String PM_INTERNAL_SERVER_MSG = "Something went wrong";
    public static Integer PM_INTERNAL_SERVER_CODE = 1002;


    public static String PM_USER_ALREADY_EXISTS_MSG = "User Already Exists";
    public static Integer PM_USER_ALREADY_EXISTS_CODE = 1003;

    
    
    
    public static String PRODUCT_CREATED_MSG = "Product Added Successfully ";
    public static Integer PRODUCT_CREATED_CODE = 2000;
    public static String PRODUCT_CREATED_DATA = "OK";


    public static String PRODUCT_CREATION_BAD_REQUEST_MSG = "Bad Request, Unable to add Product";
    public static Integer PRODUCT_CREATION_BAD_REQUEST_CODE = 2001;
    public static String PRODUCT_CREATED_BAD_DATA = "Bad Request";


    public static String PRODUCT_INTERNAL_SERVER_MSG = "Something went wrong";
    public static Integer PRODUCT_INTERNAL_SERVER_CODE = 2002;
    public static String PRODUCT_INTERNAL_SERVER_CODE_DATA = "Bad Request";
    
    public static String PRODUCT_RESPONSE_MSG = "Product list fetched Successfully ";
    public static Integer PRODUCT_RESPONSE_CODE = 2003;
    public static String PRODUCT_RESPONSE_DATA = "FETCHED";
    
    public static String PRODUCT_UPDATION_MSG = "Product Updated Successfully ";
    public static Integer PRODUCT_UPDATION_CODE = 2004;
    public static String PRODUCT_UPDATION_DATA = "Updated";
    
    public static String PRODUCT_DELETION_MSG = "Product Deleted Successfully ";
    public static Integer PRODUCT_DELETION_CODE = 2005;
    public static String PRODUCT_DELETION_DATA = "Deleted";
    
    public static String PRODUCT_DELETION_FAIL_MSG = "Unable to delete product ";
    public static Integer PRODUCT_DELETION_FAIL_CODE = 2006;
    public static String PRODUCT_DELETION_FAIL_DATA = "Failed deletion";

    
    public static String PRODUCT_RATE ="rate";
    public static String PRODUCT_PRICE ="price";
    public static String PRODUCT_SIZE ="size";
    
	public static char YES = 'Y';
	public static char NO = 'N';
    

}
