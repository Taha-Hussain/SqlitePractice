package com.ticktech.sqlitepractice.adoptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ticktech.sqlitepractice.Model.Product;
import com.ticktech.sqlitepractice.R;

import java.util.ArrayList;

/**
 * Created by Taha on 07/09/2016.
 */
public class ProductAdaptor extends ArrayAdapter<Product> {

    Context context;
    public ProductAdaptor(Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product item=getItem(position);

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview=layoutInflater.inflate(R.layout.row,parent,false);

        TextView name=(TextView)rowview.findViewById(R.id.name);
        TextView price=(TextView)rowview.findViewById(R.id.price);
        TextView expdate=(TextView)rowview.findViewById(R.id.expirarydate);

        expdate.setText(item.getExpiryDate());
        price.setText(item.getPrice());
        name.setText(item.getName());

        return rowview;


    }
}
