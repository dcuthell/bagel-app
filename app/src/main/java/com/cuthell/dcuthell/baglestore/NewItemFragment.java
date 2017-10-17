package com.cuthell.dcuthell.baglestore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.DialogFragment;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cuthell.dcuthell.baglestore.R;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by dcuthell on 10/16/2017.
 */

public class NewItemFragment extends DialogFragment{

    Activity context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_newitem, container, false);
        final Bagel newBagel = new Bagel();

        context = getActivity();

        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        Button addButton = (Button) rootView.findViewById(R.id.addButton);

        final RadioGroup bagelTypeRadioGroup = (RadioGroup) rootView.findViewById(R.id.bagelTypeRadioGroup);
        final CheckBox cheddarCheckBox = (CheckBox) rootView.findViewById(R.id.cheddarCheckBox);
        final CheckBox creamCheckBox = (CheckBox) rootView.findViewById(R.id.creamCheckBox);
        final CheckBox butterCheckBox = (CheckBox) rootView.findViewById(R.id.butterCheckBox);
        final CheckBox ketchupCheckBox = (CheckBox) rootView.findViewById(R.id.ketchupCheckBox);
        final CheckBox novaCheckBox = (CheckBox) rootView.findViewById(R.id.novaCheckBox);
        final CheckBox turkeyCheckBox = (CheckBox) rootView.findViewById(R.id.turkeyCheckBox);

        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int bagelTypeId = bagelTypeRadioGroup.getCheckedRadioButtonId();
                final RadioButton bagelTypeRadioButton = (RadioButton) rootView.findViewById(bagelTypeId);
                String selection = bagelTypeRadioButton.getText().toString();
                newBagel.setType(selection);
                String output = "You selected a " + newBagel.getType();
                if(cheddarCheckBox.isChecked()){
                    newBagel.addTopping("Cheddar Cheese");
                }
                if(creamCheckBox.isChecked()){
                    newBagel.addTopping("Cream Cheese");
                }
                if(butterCheckBox.isChecked()){
                    newBagel.addTopping("Butter");
                }
                if(ketchupCheckBox.isChecked()){
                    newBagel.addTopping("Ketchup");
                }
                if(novaCheckBox.isChecked()){
                    newBagel.addTopping("Nova");
                }
                if(turkeyCheckBox.isChecked()){
                    newBagel.addTopping("Turkey Bacon");
                }
                output += newBagel.getToppings();
                Intent intent = new Intent(context, NewOrder.class);
                Bundle bundle = new Bundle();
                intent.putExtra("bagelType", "BAAAAAAAAAA");
                startActivity(intent);
//                intent.putExtra("bagelToppings", newBagel.getToppings());
//                dismiss();
            }
        });


        return rootView;
    }

}
