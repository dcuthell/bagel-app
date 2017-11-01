package com.cuthell.dcuthell.bagelstore.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcuthell on 10/16/2017.
 */

@Parcel
public class Bagel {
    public String type;
    public List<String> toppings = new ArrayList<>();

    public Bagel(){}

    public Bagel(String type, ArrayList<String> toppings){
        this.type = type;
        this.toppings = toppings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public String getToppingsAsString(){
        String output = "";
        if(this.toppings.size() < 1 ){
            return output;
        }
        if(this.toppings.size() < 2 ){
            output += "With " + this.toppings.get(0);
            return output;
        }
        if(this.toppings.size() < 3){
            output += " With " + this.toppings.get(0) + " and " + this.toppings.get(1);
            return output;
        }
        else{
            output += " With " + this.toppings.get(0);
            for(int i = 1; i < (this.toppings.size()-1); i++){
                output += ", " + this.toppings.get(i);
            }
            output += ", and " + this.toppings.get((this.toppings.size()-1));
            return output;
        }
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
    public void addTopping(String topping) {
        this.toppings.add(topping);
    }
}
