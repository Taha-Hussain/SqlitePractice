package com.ticktech.sqlitepractice.datasource;

import android.content.Context;

import com.ticktech.sqlitepractice.Handler.DBHandler;
import com.ticktech.sqlitepractice.Model.Product;

import java.util.ArrayList;

/**
 * Created by Taha on 07/09/2016.
 */
public class ProductDatasurce {

    DBHandler dbHandler;

    public ProductDatasurce(Context context) {
        dbHandler = new DBHandler(context);

    }

    public ArrayList<Product> getlist()
    {

        ArrayList<Product>arrayList;

        arrayList=dbHandler.getAllProduct();

        return arrayList;
    }
}
