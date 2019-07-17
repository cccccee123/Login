package com.example.login.Pro;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {
    List<Product> lstProduct;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

setTitle("Phone");
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);





        lstProduct = new ArrayList<>();
        lstProduct.add(new Product("Vivo iQOO Neo (8+128GB)","HK$2,880(行)\n "+ "HK$2,880(水)","智能電話","描述 : 作業系統:Android 9.0\n" +
                "制式:4G/3G/2G\n" +
                "顯示屏:6.38吋\n" +
                "解像度:2340 x 1080\n" +
                "處理器:Android 9\n" +
                "前鏡頭:1200萬像素\n" +
                "後鏡頭:1200+800+200萬像素\n" +
                "容量:128GB\n" +
                "記憶體:8GB\n" +
                "功能:雙卡,指紋解鎖,面部解鎖\n" +
                "重量:198.5g\n" +
                "尺寸:159.53 x 75.23 x 8.13mm",R.drawable.vivo));
        lstProduct.add(new Product("OPPO Reno Z (8+128GB)","HK$2,688(水)","智能電話","描述 :上市日期:2019年7月\n" +
                "作業系統:Android 9.0\n" +
                "制式:4G\n" +
                "顯示屏:6.4吋\n" +
                "解像度:2340 x 1080\n" +
                "處理器:MTK P90\n" +
                "前鏡頭:3200萬像素\n" +
                "後鏡頭:4800+500萬像素\n" +
                "容量:128GB\n" +
                "記憶體:8GB\n" +
                "功能:雙卡,NFC\n" +
                "重量:186g\n" +
                "尺寸:157.3 x 74.9 x 9.1mm",R.drawable.oppa));
        lstProduct.add(new Product("OnePlus 7 GM1900 (8+256GB)","HK$3,898(行)\n"+ "HK$3,950(水)","智能電話","描述 :上市日期:2019年6月\n" +
                "作業系統:Android\n" +
                "制式:4G\n" +
                "顯示屏:6.41吋\n" +
                "處理器:Qualcomm Snapdragon 855\n" +
                "容量:256GB\n" +
                "記憶體:8GB\n" +
                "功能:雙卡,面部解鎖,NFC\n" +
                "重量:182g\n" +
                "尺寸:157.7 x 74.8 x 8.2mm",R.drawable.oneplus));
        lstProduct.add(new Product("OnePlus 7 Pro" + "(8+256GB)","HK$5,398(行)\n" +
                "HK$4,678(水)","智能電話","描述 :上市日期:2019年5月\n" +
                "作業系統:Andriod\n" +
                "制式:4G/3G/2G\n" +
                "顯示屏:6.67吋\n" +
                "處理器:Qualcomm Snapdragon 855\n" +
                "前鏡頭:1600萬像素\n" +
                "後鏡頭:4800+1600+800萬像素\n" +
                "容量:256GB\n" +
                "記憶體:8GB\n" +
                "功能:雙卡,指紋解鎖,面部解鎖,NFC\n" +
                "重量:206g\n" +
                "尺寸:162.6 x 75.9 x 8.8mm",R.drawable.oneplus2));

        lstProduct.add(new Product("Samsung Galaxy A60 \n" +"(6+128GB)","HK$2,088(行)\n" +
                "HK$1,798(水)","智能電話","描述 :上市日期:2019年5月\n" +
                "作業系統:Android 9.0\n" +
                "制式:4G\n" +
                "顯示屏:6.3吋\n" +
                "前鏡頭:1600萬像素\n" +
                "後鏡頭:3200+800+500萬像素\n" +
                "容量:128GB\n" +
                "記憶體:6GB\n" +
                "功能:雙卡,指紋解鎖,面部解鎖,SD卡槽,NFC\n" +
                "重量:162g\n" +
                "尺寸:155.2 x 73.9 x 7.9mm",R.drawable.samsung));
        lstProduct.add(new Product("Samsung Galaxy S10+ (8+128GB)","HK$HK$5,186(行)\n" +
                "HK$4,698(水)","智能電話","描述 :上市日期:2019年\n" +
                "作業系統:Android 9.0 (Pie)\n" +
                "顯示屏:6.4吋\n" +
                "解像度:3040 x 1440\n" +
                "前鏡頭:1000 + 800萬像素\n" +
                "後鏡頭:1200萬像素\n" +
                "容量:128GB\n" +
                "記憶體:8GB\n" +
                "功能:雙卡,指紋解鎖,面部解鎖,SD卡槽,NFC\n" +
                "重量:175g\n" +
                "尺寸:74.1 x 157.6 x 7.8mm",R.drawable.samsung1));
        lstProduct.add(new Product("Apple iPhone XR 128GB","HK$5,978(行)\n" +
                "HK$5,720(水)","智能電話","描述 :上市日期:2018年10月\n" +
                "作業系統:iOS 12\n" +
                "顯示屏:6.1吋\n" +
                "解像度:1792 x 828\n" +
                "處理器:A12\n" +
                "前鏡頭:700萬像素\n" +
                "後鏡頭:1200萬像素\n" +
                "容量:128GB\n" +
                "記憶體:3GB\n" +
                "功能:雙卡,面部解鎖,NFC\n" +
                "重量:194g\n" +
                "尺寸:150.9 x 75.7 x 8.3mm",R.drawable.iphonexr));
        lstProduct.add(new Product("ASUS ZenFone 6\n " +"(ZS630KL) (8+256GB)","HK$5,680(行)\n" +
                "HK$5,510(水)","智能電話","描述 :上市日期:2019年\n" +
                "作業系統:Android 9\n" +
                "顯示屏:6.4吋\n" +
                "解像度:2340 x 1080\n" +
                "處理器:Qualcomm Snapdragon 855\n" +
                "後鏡頭:4800+1300萬像素\n" +
                "容量:256GB\n" +
                "記憶體:8GB\n" +
                "功能:雙卡,SD卡槽,NFC\n" +
                "重量:190g\n" +
                "尺寸:159.1 x 75.44 x 9.1mm",R.drawable.asus));
        lstProduct.add(new Product("Google Pixel 3a XL (4+64GB)" ,"HK$3,888(行)\n" +
                "HK$3,580(水)","智能電話","描述 :上市日期:2019年5月\n" +
                "作業系統:Andriod\n" +
                "制式:4G/3G/2G\n" +
                "顯示屏:6.0吋\n" +
                "解像度:2160 x 1080\n" +
                "處理器:Snapdragon 670\n" +
                "前鏡頭:800萬像素\n" +
                "後鏡頭:1200萬像素\n" +
                "容量:64GB\n" +
                "記憶體:4GB\n" +
                "功能:指紋解鎖,面部解鎖\n" +
                "重量:167g\n" +
                "尺寸:160.1 x 76.1 x 8.2mm",R.drawable.google));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstProduct);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.barforphone, menu);




        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.toolbar1){
            Toast.makeText(this,"Clicked Phone",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
