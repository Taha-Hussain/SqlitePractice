package com.ticktech.sqlitepractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ticktech.sqlitepractice.Model.Product;
import com.ticktech.sqlitepractice.adoptor.ProductAdaptor;
import com.ticktech.sqlitepractice.datasource.ProductDatasurce;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    ProductAdaptor productAdaptor;
    ListView listView;
    ArrayList<Product> arrayList;
    ProductDatasurce productDatasurce;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        context=this;
        listView=(ListView)findViewById(R.id.listview);

        productDatasurce=new ProductDatasurce(context);
        arrayList=productDatasurce.getlist();
        productAdaptor=new ProductAdaptor(context,R.layout.row,arrayList);
        listView.setAdapter(productAdaptor);







    }







}
