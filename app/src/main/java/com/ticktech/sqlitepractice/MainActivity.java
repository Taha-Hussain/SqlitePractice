package com.ticktech.sqlitepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ticktech.sqlitepractice.Handler.DBHandler;
import com.ticktech.sqlitepractice.Model.Product;

public class MainActivity extends AppCompatActivity {

    private EditText prodName,prodIdToDelete,prodPrice,prodExpiry,updateProdName,updateProdPrice,updateProdExpiry,prodIdToUpdate;
    DBHandler db;
    Product p;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = new Product();
        db = new DBHandler(this);
        prodName = (EditText) findViewById(R.id.productName);
        prodPrice = (EditText) findViewById(R.id.productPrice);
        prodExpiry = (EditText)     findViewById(R.id.productExpiry);
        prodIdToDelete = (EditText)     findViewById(R.id.productIdToDelete);


        updateProdName = (EditText) findViewById(R.id.updateProductName);
        updateProdPrice = (EditText) findViewById(R.id.updateProductPrice);
        updateProdExpiry = (EditText)     findViewById(R.id.updateProductExpiry);
        prodIdToUpdate = (EditText)     findViewById(R.id.productIdToUpdate);

    }

    public void submitProduct(View view) {

        p.setName(prodName.getText().toString());
        p.setPrice(prodPrice.getText().toString());
        p.setExpiryDate(prodExpiry.getText().toString());
        db.addProduct(p);
        Toast.makeText(MainActivity.this, "Product Entered" , Toast.LENGTH_SHORT).show();
        prodName.setText("");
        prodPrice.setText("");
        prodExpiry.setText("");
        /*db.getAllProduct();*/

    }
    public void show(View view)
    {
        Intent intent=new Intent(this,DataActivity.class);
        startActivity(intent);
    }

    public void deleteProduct(View view)
    {
        db.deleteProduct(prodIdToDelete.getText().toString());
        /*db.getAllProduct();*/
        Toast.makeText(MainActivity.this, "Product Deleted" , Toast.LENGTH_SHORT).show();
    }

    public void updateProduct(View view)
    {
        p.setName(updateProdName.getText().toString());
        p.setPrice(updateProdPrice.getText().toString());
        p.setExpiryDate(updateProdExpiry.getText().toString());
        p.setId(Integer.parseInt(prodIdToUpdate.getText().toString()));
        db.updateProduct(p);
     /*   db.getAllProduct();*/
        Toast.makeText(MainActivity.this, "Product Updated" , Toast.LENGTH_SHORT).show();
    }



}
