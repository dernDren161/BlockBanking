package com.sbipblockchain.springdemo.rest;

import java.security.PrivateKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Base64;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import static java.nio.charset.StandardCharsets.UTF_8;


// class that generates the signature for a value string 'builtString'

public class MySignature {

    public static String sign(String builtString,PrivateKey privateKey) throws Exception{
        Signature s = Signature.getInstance("SHA256withRSA");
        s.initSign(privateKey);
        s.update(builtString.getBytes(UTF_8));

        byte[] signing = s.sign();

        return Base64.getEncoder().encodeToString(signing);

    }

}
