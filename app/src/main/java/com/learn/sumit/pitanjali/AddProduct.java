package com.learn.sumit.pitanjali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddProduct extends AppCompatActivity {
    EditText id,name,quantity,rate;
    Button add;
    ArrayList<Products> products=new ArrayList<Products>();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        DataHolder.setData(products);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        setContentView(R.layout.activity_add_product);

        id =findViewById(R.id.id);
        name= findViewById(R.id.name);
        quantity= findViewById(R.id.quantity);
        rate= findViewById(R.id.rate);
        add= findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id=id.getText().toString();
                String Name=name.getText().toString();
                String Quantity=quantity.getText().toString();
                String Rate=rate.getText().toString();

                if(Id.equals("")||Name.equals("")||Quantity.equals("")||Rate.equals("")){
                    if(Id.equals("")) id.setError("please enter id");
                    if(Name.equals(""))  name.setError("please enter name");
                    if(Quantity.equals("")) quantity.setError("please enter quantity");
                    if(Rate.equals("")) rate.setError("please enter rate");
                }
                else{
                    id.setText("");
                    name.setText("");
                    quantity.setText("");
                    id.setText("");
                    rate.setText("");
                   products.add(new Products(Integer.parseInt(Id),Name,Integer.parseInt(Quantity),Double.parseDouble(Rate)));
                    /*products.add(new Products(1,"kesh",100,20.0));
                    products.add(new Products(11,"kanti",200,100.0));
                    products.add(new Products(110,"keshkanti",10,20.2));*/
                    Toast.makeText(AddProduct.this, "|Item "+Name+" | Id: "+Id+"| is added to stock", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

}
