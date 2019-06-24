package com.acme.banking.dbo.service;

public class Guard {

    public static void checkNonNull(Object o, GuardService service) {
        if( o == null) {
            service.execute();
        }
    }
}
