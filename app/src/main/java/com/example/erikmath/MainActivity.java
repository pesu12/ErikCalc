package com.example.erikmath;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainfunction();

        //Button for play again
        final Button playAgain = (Button) findViewById(R.id.buttonReplay);
        playAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainfunction();
            }
        });
    }

    private void mainfunction() {
        //Clear
        TextView correctOrBad = (TextView) findViewById(R.id.textCorrectOrWrong);
        correctOrBad.setText(" ");
        EditText mEdit   = (EditText)findViewById(R.id.textInput);
        mEdit.setText("");
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        //Create formula class and generate Formula string
        NumberFormula formula = new NumberFormula();
        TextView textView = (TextView) findViewById(R.id.textFormula);
        String generatedFormula = formula.generateNumbers();
        textView.setText(generatedFormula);

        //getSum
        /*
        editText.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //...
                    // Perform your action on key press here
                    // ...
                    return true;
                }
                return false;
            }
        });
        */

        Button getSum = (Button) findViewById(R.id.getSum);
        getSum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Get text from Input
                final EditText mEdit;
                TextView mText;
                mEdit   = (EditText)findViewById(R.id.textInput);
                String sum = mEdit.getText().toString();
                //Check sum
                if(formula.getResult().equals(sum)){
                    TextView correctOrBad = (TextView) findViewById(R.id.textCorrectOrWrong);
                    correctOrBad.setText("RÄTT");
                    getWindow().getDecorView().setBackgroundColor(Color.rgb(0,153,76));
                } else {
                    TextView correctOrBad = (TextView) findViewById(R.id.textCorrectOrWrong);
                    correctOrBad.setText("FEL");
                    getWindow().getDecorView().setBackgroundColor(Color.rgb(255,51,51));
                }
            }
        });

    }
}