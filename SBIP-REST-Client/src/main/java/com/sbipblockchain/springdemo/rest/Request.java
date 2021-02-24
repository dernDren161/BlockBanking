package com.sbipblockchain.springdemo.rest;

import java.sql.Timestamp;

public class Request {

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private double t = Math.random() * (2-0+1)+0;


    private double id=t;
    private String time = timestamp.toString();
    private String fromID;
    private String toID;
    private double amount;
    private int publicKey;


}
