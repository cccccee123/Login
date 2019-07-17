package com.example.login.Ca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login.R;

public class Product_ActivityCa extends AppCompatActivity {

    private TextView tvtitle,txtprice,tvdescription,tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        txtprice=(TextView) findViewById(R.id.txtprice);
        tvcategory = (TextView) findViewById(R.id.txtCat);


        tvdescription = (TextView) findViewById(R.id.txtDesc);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Price = intent.getExtras().getString("Price");
        String Catergory = intent.getExtras().getString("Catergory");


        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values

        tvtitle.setText(Title);
        txtprice.setText(Price);
        tvcategory.setText(Catergory);

        tvdescription.setText(Description);
        img.setImageResource(image);


    }


    }

