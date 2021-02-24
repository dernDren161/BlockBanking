package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@DataType
public final class CoinEntity {

    @Property()
    private final Integer updatedTO;

    @Property()
    private final Integer publicKeyTO;

    @Property()
    private final String toID;


    private Map<String, List<Integer>> myMapTO;
    private List<Integer> myListTO;

    private Map<String,List<Integer>> myMapFROM;
    private List<Integer> myListFROM;


    public String convertToJSON(){
        return new JSONObject(this).toString();
    }

    public  CoinEntity(String toID,Integer updatedTO, Integer publicKeyTO){
        this.toID = toID;
        this.updatedTO = updatedTO;
        this.publicKeyTO = publicKeyTO;

        myListTO.add(updatedTO);
        myListTO.add(publicKeyTO);
        myMapTO.put(toID,myListTO);
    }

}
