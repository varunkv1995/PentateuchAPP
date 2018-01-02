package com.example.varu.ptactice_attribuits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Grid extends AppCompatActivity {

    GridView gridView;
    String values[]={"1.app","2.app","3.app","4.app","5.app","6.app","7.app","8.app","9.app","10.app","11.app","12.app","13.app","14.app","15.app"};
    int images[]={
            R.drawable.ic_action_gallery,
            R.drawable.ic_action_home1,
            R.drawable.ic_action_n1,
            R.drawable.ic_action_out,
            R.drawable.ic_action_n1,
            R.drawable.ic_action_gallery,
            R.drawable.ic_action_home1,
            R.drawable.ic_action_n1,
            R.drawable.ic_action_out,
            R.drawable.ic_action_n1,
            R.drawable.ic_action_gallery,
            R.drawable.ic_action_home1,
            R.drawable.ic_action_n1,
            R.drawable.ic_action_out,
            R.drawable.ic_action_n1,


    };

    private List<Model> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        for(int i=0;i<images.length;i++)
            lists.add(new Model(values[i],images[i]));//creating model and adding
        GridView gridView=(GridView)findViewById(R.id.grid);
        Gridadapter g =new Gridadapter(this,lists);
        gridView.setAdapter(g);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Model item = (Model) parent.getItemAtPosition(position);//matching the things
                if(item.getName().equals("1.app")) {

                    startActivity(new Intent(Grid.this, App1.class));
                }
                if(item.getName().equals("2.app"))
                {
                    startActivity(new Intent(Grid.this,cardview.class));

                }


                Toast.makeText(getApplicationContext(),"selected application is:"+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }
        });
}
}


