package com.sahydo.openmarketapp.utilities;

public class EmailTemplateUtil {

    private EmailTemplateUtil() {

    }

    public static final String OPENMARKET_SUCCESSFULLY_CREATED_SUBJECT = "Openmarket Request created successfully";
    public static final String OPENMARKET_FAILURE_CREATE_SUBJECT = "Problems With Openmarket";
    public static final boolean IS_ENABLED_EMAILING = System.getenv("IS_ENABLED_EMAILING") != null
            && System.getenv("IS_ENABLED_EMAILING").equals("true");

}
