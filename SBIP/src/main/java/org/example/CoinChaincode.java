package org.example;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.*;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "CoinChaincode",
        info = @Info(title = "CoinChaincode contract",
                description = "Coin transaction implementation",
                version = "0.0.1",
                license =
                @License(name = "SPDX-License-Identifier: Apache-2.0",
                        url = "")
                ))

@Default
public final class CoinChaincode implements ContractInterface {

    @Transaction()
    public void send(Context ctx,int transactionID, int timestamp, String fromID, String toID, double amount, Integer publicKeyTO, Integer publicKeyFROM, String signature){

        //key is id
        // value is map: map<String,List<double>>
        ChaincodeStub stub = ctx.getStub();

        Map<String, List<Integer>>myMapTO;
        List<Integer> myListTO;
        myListTO = stub.getState(toID);

        Map<String,List<Integer>>myMapFROM;
        List<Integer> myListFROM;
        myListFROM = stub.getState(fromID);

        //0th index is for balance
        //1st index is for the public key

        Integer updatedTO = myListTO[0] + (int)amount;
        Integer updatedFROM = myListFROM[0] - (int)amount;

        CoinEntity c1 = new CoinEntity(toID,updatedTO,publicKeyTO);
        CoinEntity c2 = new CoinEntity(fromID,updatedFROM,publicKeyFROM);


        stub.putState(fromID,c1.convertToJSON().getBytes(UTF_8));
        stub.putState(toID,c2.convertToJSON().getBytes(UTF_8));
    }

    public Integer get(Context ctx,int transactionID, int timestamp, String myID, Integer myPublicKey, String signature){

        byte[] b = ctx.getStub().getState(myID);
        if(!b){
            throw new RuntimeException("The given user with the signature" + signature + "does not exist");
        }

        Map<String, List<Integer>>getAnswer;

        List<Integer> l = new ArrayList<>();
        l = getAnswer.get(myID);

        Integer temp;
        temp = l[0];

        return temp;
    }
}
