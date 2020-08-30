package com.example.a10012756.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {


    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonClear;
    Button buttonEquals;
    TextView output;
    ArrayList<String> list = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = findViewById(R.id.ID_Button1);
        buttonTwo = findViewById(R.id.ID_Button2);
        buttonThree = findViewById(R.id.ID_Button3);
        buttonFour = findViewById(R.id.ID_Button4);
        buttonFive = findViewById(R.id.ID_Button5);
        buttonSix = findViewById(R.id.ID_Button6);
        buttonSeven = findViewById(R.id.ID_Button7);
        buttonEight = findViewById(R.id.ID_Button8);
        buttonNine = findViewById(R.id.ID_Button9);
        buttonZero = findViewById(R.id.ID_Button0);
        buttonPlus = findViewById(R.id.ID_PlusSign);
        buttonMinus = findViewById(R.id.ID_MinusSign);
        buttonMultiply = findViewById(R.id.ID_MultiplySign);
        buttonDivide = findViewById(R.id.ID_DivisionSign);
        buttonClear = findViewById(R.id.ID_Clear);
        buttonEquals = findViewById(R.id.ID_EqualsSign);
        output = findViewById(R.id.ID_Output);

    }

    public void ClickedOne(View v) {
        output.setText(output.getText() + "1");
    }

    public void ClickedTwo(View v) {
        output.setText(output.getText() + "2");
    }

    public void ClickedThree(View v) {
        output.setText(output.getText() + "3");
    }

    public void ClickedFour(View v) {
        output.setText(output.getText() + "4");
    }

    public void ClickedFive(View v) {
        output.setText(output.getText() + "5");
    }

    public void ClickedSix(View v) {
        output.setText(output.getText() + "6");
    }

    public void ClickedSeven(View v) {
        output.setText(output.getText() + "7");
    }

    public void ClickedEight(View v) {
        output.setText(output.getText() + "8");
    }

    public void ClickedNine(View v) {
        output.setText(output.getText() + "9");
    }

    public void ClickedZero(View v) {
        output.setText(output.getText() + "0");
    }

    public void ClickedPlus(View v) {
        output.setText(output.getText() + "+");
    }

    public void ClickedMinus(View v) {
        output.setText(output.getText() + "-");
    }

    public void ClickedMultiply(View v) {
        output.setText(output.getText() + "*");
    }

    public void ClickedDivide(View v) {
        output.setText(output.getText() + "/");
    }

    public void ClickedClear(View v) {
        output.setText("");
        list.clear();
    }

    public void ClickedEquals(View v){

        StringTokenizer tokens = new StringTokenizer(String.valueOf(output.getText()), "+-/*", true);
        while (tokens.hasMoreTokens()) {
            list.add(tokens.nextToken());
        }
        for (int x = 0; x < list.size(); x++)
        {
            try {
                if(list.get(0).equals("+") || list.get(0).equals("-") || list.get(0).equals("*")
                        ||list.get(0).equals("/") || list.get(list.size()-1).equals("+") || list.get(list.size()-1).equals("-")
                        || list.get(list.size()-1).equals("*") ||list.get(list.size()-1).equals("/")){
                    output.setText("Error: illegal statement");
                    return;
                }
                if (list.get(x).equals("*")) {
                    double mult = Double.valueOf(list.get(x - 1)) * Double.valueOf(list.get(x + 1));
                    list.remove(x + 1);
                    list.remove(x - 1);
                    list.set(x - 1, Double.toString(mult));
                    x = 0;
                } else if (list.get(x).equals("/")) {
                        if (Double.valueOf(list.get(x + 1)) == 0) {
                           output.setText("Error: Divide by zero ");
                            return;
                        }
                        double div = Double.valueOf(list.get(x - 1)) / Double.valueOf(list.get(x + 1));
                        list.remove(x + 1);
                        list.remove(x - 1);
                        list.set(x - 1, Double.toString(div));
                        x = 0;
                }
            }catch(IllegalArgumentException e)
            {
                output.setText("Error: Illegal Argument");
                return;
            }catch(ArithmeticException e)
            {
                output.setText("Error: Arithmetic Exception");
                return;
            }
        }

        for (int x = 0; x < list.size(); x++) {
            try {
                if (list.get(x).equals("+")) {
                    double add = Double.valueOf(list.get(x - 1)) + Double.valueOf(list.get(x + 1));
                    list.remove(x + 1);
                    list.remove(x - 1);
                    list.set(x - 1, Double.toString(add));
                    x = 0;
                } else if (list.get(x).equals("-")) {
                    double sub = Double.valueOf(list.get(x - 1)) - Double.valueOf(list.get(x + 1));
                    list.remove(x + 1);
                    list.remove(x - 1);
                    list.set(x - 1, Double.toString(sub));
                    x = 0;
                }
            }catch(IllegalArgumentException e)
            {
                output.setText("Error: Illegal Argument");
                return;
            }catch(ArithmeticException e)
            {
                output.setText("Error: Arithmetic Exception");
                return;
            }
        }
        output.setText(list.get(0));
        list.clear();
    }

}
