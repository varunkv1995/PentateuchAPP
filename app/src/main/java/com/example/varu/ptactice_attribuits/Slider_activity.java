package com.example.varu.ptactice_attribuits;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Slider_activity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager pager;
    private TextView[] textViews;
    private LinearLayout linearLayout;
    private int[] colors;
    private int cur = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_activity);
        pager = (ViewPager)findViewById(R.id.pager);
        linearLayout = (LinearLayout)findViewById(R.id.layout_dot);
        colors = new int[]{Color.BLUE,Color.GREEN,Color.rgb(153,50,204)};
        int[] res = {R.layout.welcome1,R.layout.welcome2,R.layout.welcome3};/*add to resorce*/
        MyAdapter adapter = new MyAdapter(res,this);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
        textViews = new TextView[3];/*3 pages*/
        for(int i=0;i<res.length;i++){
            textViews[i] = new TextView(this);
            textViews[i].setText(Html.fromHtml("&#8226;"));
            textViews[i].setTextSize(30);
            textViews[i].setTextColor(colors[0]);
            linearLayout.addView(textViews[i]);
        }
        textViews[0].setTextColor(cur);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<textViews.length;i++)
            textViews[i].setTextColor(colors[position]);/*set the page colour */
        textViews[position].setTextColor(cur);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
