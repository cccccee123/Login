package com.example.login.Ca;

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

import com.example.login.Pro.Product;
import com.example.login.Pro.RecyclerViewAdapter;
import com.example.login.R;

import java.util.ArrayList;
import java.util.List;

public class DetailCa extends AppCompatActivity {
    List<Product> lstProduct;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

setTitle("Carema");
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);





        lstProduct = new ArrayList<>();
        lstProduct.add(new Product("Olympus 輕便數碼相機 \n "+"Tough TG-6","HK$3,680(行)\n "+ "HK$3,280(水)","數碼相機","描述 : 上市日期:2019年9月\n" +
                "像素:1200萬像素\n" +
                "屏幕:3.0 吋\n" +
                "光學變焦:4x\n" +
                "防水:15米：相當於JIS/IEC保護等級第8級（IPX8）\n" +
                "儲存媒體:SD\n" +
                "重量:253g\n" +
                "尺寸:113 x 66 x 32.4mm",R.drawable.carema1));
        lstProduct.add(new Product("Leica M-E [Typ 240]","HK$35,000(行)\n"+"HK$32,000(水)","數碼相機","描述 :上市日期:2019年7月\n" +
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
                "尺寸:157.3 x 74.9 x 9.1mm",R.drawable.carema2));
        lstProduct.add(new Product("Hasselblad X1D II 50C","HK$46,000(行)\n"+"HK$44,800(水)","數碼相機","描述 :上市日期:2019年7月\n" +
                "像素:5000萬像素\n" +
                "儲存媒體:SD / SDHC / SDXC 記憶咭\n" +
                "重量:650g",R.drawable.carema3));
        lstProduct.add(new Product("Fujifilm FinePix SL300\n "+"數碼相機","HK$1,210(水)","數碼相機","描述 :像素:1400萬像素\n" +
                "屏幕:3.0\n" +
                "光學變焦:30x\n" +
                "防水:否\n" +
                "儲存媒體:SD / SDHC / SDXC\n" +
                "重量:510g\n" +
                "尺寸:122 x 93 x 100mm",R.drawable.carema4));
        lstProduct.add(new Product("Canon PowerShot \n"+"G7X Mark II","HK$3,270(行)\n"+ "HK$HK$3,140(水)","數碼相機","描述 :上市日期:2016年2月\n" +
                "像素:2010萬像素\n" +
                "屏幕:3.0吋\n" +
                "光學變焦:4x\n" +
                "數碼變焦:4.2x\n" +
                "儲存媒體:SD/SDHC/SDXC/HS-I\n" +
                "重量:294g\n" +
                "尺寸:105.5 x 60.9 x 42.0mm",R.drawable.carema5));
        lstProduct.add(new Product("Ricoh GR III","HK$7,250(行)\n"+ "HK$6,680(水)","數碼相機","描述 :上市日期:2019年4月\n" +
                "像素:2424萬像素\n" +
                "屏幕:3\n" +
                "儲存媒體:SD\n" +
                "重量:257g\n" +
                "尺寸:109.4 x 61.9 x 33.2mm",R.drawable.carema6));
        lstProduct.add(new Product("Fujifilm FinePix AX350\n"+" 高畫質輕巧數碼相機","HK$460(水)","數碼相機","描述 :像素:1600萬像素\n" +
                "屏幕:3.0\n" +
                "光學變焦:5x\n" +
                "數碼變焦:4x\n" +
                "防水:否\n" +
                "儲存媒體:SD / SDHC\n" +
                "重量:168g\n" +
                "尺寸:93.0 x 60.2 x 27.8mm",R.drawable.carema7));



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
            Toast.makeText(this,"Clicked Carema",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
