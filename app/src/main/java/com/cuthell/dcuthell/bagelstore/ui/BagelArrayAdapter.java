package com.cuthell.dcuthell.bagelstore.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cuthell.dcuthell.bagelstore.models.Bagel;

import java.util.ArrayList;

/**
 * Created by dcuthell on 10/16/2017.
 */

public class BagelArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<Bagel> mBagelList;

    public BagelArrayAdapter(Context context, int resource, ArrayList<Bagel> mBagelList){
        super(context, resource);
        this.mBagelList = mBagelList;
    }

    @Override
    public Object getItem(int position){
        String type = mBagelList.get(position).getType();
        String toppings = getBagelDetails(position);
        return String.format("%s \n %s", type, toppings);
    }

    @Override
    public int getCount(){
        return mBagelList.size();
    }

    public String getBagelDetails(int bagelId){
        String output = "";
        Bagel selectedBagel = mBagelList.get(bagelId);
        ArrayList<String> toppings = selectedBagel.getToppings();
        if(toppings.size() < 1 ){
            return output;
        }
        if(toppings.size() < 2 ){
            output += "With " + toppings.get(0);
            return output;
        }
        if(toppings.size() < 3){
            output += " With " + toppings.get(0) + " and " + toppings.get(1);
            return output;
        }
        else{
            output += " With " + toppings.get(0);
            for(int i = 1; i < (toppings.size()-1); i++){
                output += ", " + toppings.get(i);
            }
            output += ", and " + toppings.get((toppings.size()-1));
            return output;
        }
    }
}
