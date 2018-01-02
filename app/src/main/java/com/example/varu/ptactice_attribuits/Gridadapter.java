package com.example.varu.ptactice_attribuits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by varu on 26-12-2017.
 */

public class Gridadapter extends BaseAdapter {
    Context context;
    private List<Model> objects;

    LayoutInflater layoutInflater;
    View view;

    public Gridadapter(Context context, List<Model> objects) {
        this.context = context;
        this.objects = objects;
    }




    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Model getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Model item= getItem(position);
        if(convertView==null){
            view=layoutInflater.inflate(R.layout.single_items,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.image11);
            TextView textView=(TextView)view.findViewById(R.id.text11);
            imageView.setImageResource(item.getRes());
            textView.setText(item.getName());

        }
        return view;
    }
}
