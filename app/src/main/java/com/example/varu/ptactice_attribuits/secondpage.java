package com.example.varu.ptactice_attribuits;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class secondpage extends AppCompatActivity {
private Button timebtn;
    private EditText editText1,value;
    private RatingBar ratingBar;


    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        Bundle b = getIntent().getExtras();
        TextView textView = (TextView)findViewById(R.id.tv_user);
        textView.setText("Welcome \n" + b.getString("username")+"\nemail:"+b.getString("email")+"\nphone:"+b.getString("phone")+"\nadress:"+b.getString("adress")+"\nDOB:"+b.getString("textViewDob")+"\ngender:"+b.getString("gender"));
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav);
        drawerLayout = (DrawerLayout)findViewById(R.id.drwa);
        View header = navigationView.getHeaderView(0);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opened,R.string.closed);
        toggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        drawerLayout.addDrawerListener(toggle);
        TextView textView1 = (TextView)header.findViewById(R.id.un);
        textView1.setText( b.getString("username"));
        TextView textView2 = (TextView)header.findViewById(R.id.el);
        textView2.setText( b.getString("email"));
Button timebtn=(Button)findViewById(R.id.time1);
        final TextView value=(TextView)findViewById(R.id.value);
        RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);

        final EditText  editText1=(EditText)findViewById(R.id.editText) ;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu_home:finish();
                        break;
                    case R.id.menu_exit:System.exit(0);
                        break;
                    case R.id.menu_intro:
                        Intent i = new Intent(secondpage.this,Slider_activity.class);
                        startActivity(i);
                        break;
                    case R.id.cards:
                        Intent i1= new Intent(secondpage.this,cardview.class);
                        startActivity(i1);
                        break;
                    case R.id.grid:
                        Intent ill=new Intent(secondpage.this,Grid.class);
                        startActivity(ill);


                }

                return false;
            }
        });

timebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
               editText1.setText( ""  + selectedHour + ":" + selectedMinute);
            }
        }, hour, minute,true);//24 hrs true
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();


    }
});

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("value is "+ rating);
            }
        });




    }
}
