package com.example.powerstation.traceparsingxml;

import java.util.HashMap;

/**
 * Created by andrey on 14.05.2015.
 */
public class Food extends HashMap<String, String> {

    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";


    public Food(String name, String price, String description) {
        super();
        super.put(NAME, name);
        super.put(PRICE, price);
        super.put(DESCRIPTION, description);
    }
}
