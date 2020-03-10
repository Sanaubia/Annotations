package com.example.annotations;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {



    @ViewById
    TextView text;
    @ViewById
    TextView pressed;


    @ViewById
    Button clickMe;


    @UiThread
    void doInUiThread(int Number){
        text.setText(String.valueOf(Number));


    }

    @UiThread
    void updatePressed(int Pressed){
        pressed.setText(String.valueOf(Pressed));


    }



    @Click(R.id.clickMe)
    void clickMePressed(){

        //String test = String.valueOf(text1.getText());
        //Integer pressed = Integer.valueOf(test);
       Integer result = Integer.valueOf(text.getText().toString());
        Integer pressedNum = Integer.valueOf(pressed.getText().toString());

        backgroundThread(result);
        buttonPressedUpdate(pressedNum);
    }

    @Background
    void backgroundThread(int Number) {

        int number = Number;
        number = number + number;
        doInUiThread(number);
    }

    @Background
    void buttonPressedUpdate(int Pressed){

        int number = Pressed + 1;
        updatePressed(number);

    }



}


