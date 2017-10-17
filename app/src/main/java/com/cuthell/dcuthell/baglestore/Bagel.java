package com.cuthell.dcuthell.baglestore;

import java.util.ArrayList;

/**
 * Created by dcuthell on 10/16/2017.
 */

public class Bagel {
    public String type;
    public ArrayList<String> toppings;

    public Bagel(){
        this.type = "None";
        this.toppings = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
    public void addTopping(String topping) {
        this.toppings.add(topping);
    }
}
