package com.example.varu.ptactice_attribuits;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by varu on 22-12-2017.
 */

public class MyAdapter extends PagerAdapter {
    int[] resorces;
    private Context context;

    public MyAdapter(int[] resorces, Context context) {
        this.resorces = resorces;
        this.context = context;
    }

    @Override
    public int getCount() {
        return resorces.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resorces[position],container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
    }
}
