package com.ticktech.sqlitepractice.Handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ticktech.sqlitepractice.Model.Product;

import java.util.ArrayList;

/**
 * Created by Taha on 07/09/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shop";
    private static final String TABLE_NAME = "productInfo";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_EXPIRY_DATE = "expiryDate";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT , " + KEY_PRICE + " TEXT, " + KEY_EXPIRY_DATE + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Creating tables again
        onCreate(sqLiteDatabase);
    }


    public void addProduct(Product Product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, Product.getName());
        values.put(KEY_PRICE, Product.getPrice());
        values.put(KEY_EXPIRY_DATE, Product.getExpiryDate());
        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }


    public void updateProduct(Product Product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, Product.getName());
        values.put(KEY_PRICE, Product.getPrice());
        values.put(KEY_EXPIRY_DATE, Product.getExpiryDate());
        // Inserting Row
        db.update(TABLE_NAME, values, KEY_ID + "=?",new String[]{String.valueOf(Product.getId())});
        db.close(); // Closing database connection
    }


    public void deleteProduct(String id) {
        Product p = new Product();
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NAME, KEY_ID + "=" + id, new String[]{String.valueOf(p.getId())});
        db.execSQL("Delete From "+ TABLE_NAME +" where Id = "+ id);
        db.close();
    }

    // Getting All Shops
   // public void getAllProduct() {
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productList = new ArrayList<Product>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product p = new Product();
                p.setId(Integer.parseInt(cursor.getString(0)));
                p.setName(cursor.getString(1));
                p.setPrice(cursor.getString(2));
                p.setExpiryDate(cursor.getString(3));
// Adding contact to list
                productList.add(p);
            }
            while (cursor.moveToNext());
        }

       /* for (Product products : productList)
        {
            String log = "Id: " + products.getId() + " ,Product Name: " + products.getName() + " ,Product Price: " + products.getPrice() + " ,Expiry Date: " + products.getExpiryDate();
// Writing shops to log
            Log.d("Product: ", log);

        }*/
        return productList;
    }



}
