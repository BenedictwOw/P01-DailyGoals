package com.myapplicationdev.android.p01_dailygoals;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String mypreference = "mypref";
    public static final String Radio1 = "radioKey1";
    public static final String Radio2 = "radioKey2";
    public static final String Radio3 = "radioKey3";
    public static final String Reflection = "reflectionKey";
    public String reflection;
    public Integer radio1;
    public Integer radio2;
    public Integer radio3;
    public RadioGroup rg1;
    public RadioGroup rg2;
    public RadioGroup rg3;
    public EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        etName = (EditText) findViewById(R.id.editText);
        //Getting id of the selected radio button in the RadioGroup



        Button btnOk = (Button)findViewById(R.id.button1);
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId1);
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton)findViewById(selectedButtonId3);
                //Put name and age into an array
                String[] info = {etName.getText().toString(),rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString()};
                //Create an intent to start another activity called DemoActivities
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                //Passing string array holding the name and age to new activity
                i.putExtra("info",info);
                //Step 1: Saving the Data
                saveData();
                //start the new activity
                startActivity(i);
            };
        });
        loadData();
        updateViews();
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(mypreference,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Reflection, etName.getText().toString());
        editor.putInt(Radio1, rg1.indexOfChild(findViewById(rg1.getCheckedRadioButtonId())));
        editor.putInt(Radio2, rg2.indexOfChild(findViewById(rg2.getCheckedRadioButtonId())));
        editor.putInt(Radio3, rg3.indexOfChild(findViewById(rg3.getCheckedRadioButtonId())));
        editor.commit();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(mypreference,MODE_PRIVATE);
        reflection = sharedPreferences.getString(Reflection, "");
        radio1 = sharedPreferences.getInt(Radio1,-1);
        radio2 = sharedPreferences.getInt(Radio2,-1);
        radio3 = sharedPreferences.getInt(Radio3,-1);
    }
    public void updateViews(){
        etName.setText(reflection);
        if( radio1 >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.radioGroup1)).getChildAt(radio1)).setChecked(true);
        }
        if( radio2 >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.radioGroup2)).getChildAt(radio2)).setChecked(true);
        }
        if( radio3 >= 0){
            ((RadioButton) ((RadioGroup)findViewById(R.id.radioGroup3)).getChildAt(radio3)).setChecked(true);
        }
    }
}