package com.example.varu.ptactice_attribuits;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
 Button btn,btnDob;
 EditText name,phone,adress,email;
CheckBox CB;
    private Spinner spinner;
    private EditText textViewDob;
    private  String gender;
    private  RadioGroup radioGroup;
    private RadioButton radioButton, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        adress = (EditText) findViewById(R.id.adress);
        btnDob = (Button)findViewById(R.id.btn_dob);
        email = (EditText) findViewById(R.id.email);
        CB=(CheckBox)findViewById(R.id.checkBox4);
        textViewDob = (EditText) findViewById(R.id.tv_dob);
        spinner = (Spinner)findViewById(R.id.spinner);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButton=(RadioButton)findViewById(R.id.radioButton) ;
        radioButton2=(RadioButton)findViewById(R.id.radioButto2) ;
        /*radio*/
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.radioButton:gender = "Male";
                        break;
                    case R.id.radioButto2:gender = "Female";
                        break;
                }
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                DatePickerDialog dialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        if(year<1995||year>2017)
                        {
                           Toast.makeText(getApplicationContext(),"not eligible",Toast.LENGTH_LONG).show();

                        }
                        else {

                            textViewDob.setText(year + "/" + month + "/" + dayOfMonth);
                        }
                    }
                },calendar.YEAR,calendar.MONTH,calendar.DAY_OF_MONTH);
                dialog.show();


            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(email.getText().toString())||TextUtils.isEmpty(name.getText().toString())||TextUtils.isEmpty(phone.getText().toString())||TextUtils.isEmpty(adress.getText().toString()))
                {
                  LayoutInflater   inflater=getLayoutInflater();
                    View view=inflater.inflate(R.layout.toastcoustm,(ViewGroup)findViewById(R.id.toast));
                    Toast toast=new Toast(getApplicationContext());
                    toast.setView(view);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                   toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
return;


                }
                if (!email.getText().toString().matches("^[a-zA-Z0-9.]*@[a-zA-Z]*.(com|in)"))
                {
                    email.setText("");
                    email.setHintTextColor(Color.RED);
                    email.setHint("invalid email id");
                    return;
                }


                    if(phone.getText().toString().length()>10||phone.getText().length()<10)
                {
                    phone.setText("");
                    phone.setHintTextColor(Color.RED);
                  phone.setHint("invalid phone number");
                    return;
                }
                if(name.getText().toString().length()<3){

                    name.setText("");
                    name.setHintTextColor(Color.RED);
                    name.setHint("Enter vaild Name");
                    return;
                }

                if(!textViewDob.getText().toString().matches("^[0-9]{4}\\/[0-9][0-9]?\\/[]0-9][0-9]?"))
                {
                    Toast.makeText(getApplicationContext(),"please select the DOB",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(gender))
                {
                    Toast.makeText(getApplicationContext(),"please select gender",Toast.LENGTH_LONG).show();
                    return;
                }
                
                     else {
                        Intent intent = new Intent(MainActivity.this, secondpage.class);
                        intent.putExtra("username",name.getText().toString());
                    intent.putExtra("email",email.getText().toString());
                    intent.putExtra("phone",phone.getText().toString());
                    intent.putExtra("adress",adress.getText().toString());
                    intent.putExtra("textViewDob",textViewDob.getText().toString());
                    intent.putExtra("gender",gender.toString());
                        startActivity(intent);
                    }



            }
        });
        CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CB.isChecked())
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);

            }
        });


    }
@Override
        public void onBackPressed()
        {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }

        });
builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();

    }
});
AlertDialog alertDialog=builder.create();
            alertDialog.setMessage("EXITE");
            alertDialog.setTitle("Alert");
            alertDialog.setIcon(R.drawable.ic_action_gallery);
            alertDialog.show();






    }
}
