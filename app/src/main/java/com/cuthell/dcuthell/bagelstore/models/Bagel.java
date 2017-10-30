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

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
    public void addTopping(String topping) {
        this.toppings.add(topping);
    }
}
