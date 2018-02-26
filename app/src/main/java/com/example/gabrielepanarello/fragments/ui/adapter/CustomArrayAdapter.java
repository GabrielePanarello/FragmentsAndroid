package com.example.gabrielepanarello.fragments.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gabrielepanarello.fragments.R;
import com.example.gabrielepanarello.fragments.data.Pizza;

import java.util.List;

/**
 * Created by Gabriele Panarello on 22/02/2018.
 */

public class CustomArrayAdapter extends ArrayAdapter<Pizza>{

    private final Context context;
    private List<Pizza> values;


    public CustomArrayAdapter(Context context, List<Pizza> values) {
        super(context, R.layout.item_layout, values);
        this.context = context;
        this.values = values;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewOptimize(position, convertView, parent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View getViewOptimize(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.pizza = (TextView) convertView.findViewById(R.id.pizzaName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Da qui in poi si lavora con il viewHolder, esempio:
        Pizza pizza = getItem(position);
        viewHolder.pizza.setText(pizza.getNome());


        //ritorno la view
        return convertView;
    }

    private class ViewHolder {
        public TextView pizza;
    }

}
