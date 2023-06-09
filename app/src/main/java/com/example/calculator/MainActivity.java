package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result, texte;
    Button buttonC, buttoncos, buttonsin, buttontan, button9, button8, button7, button6, button5;
    Button button4, button3, button2, button1, button0, buttonvirgule, buttonmoins, buttonplus, buttondivise, buttonmultiple, buttonegale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        texte = findViewById(R.id.text);

        assignId(buttonC, R.id.buttonC);
        assignId(buttoncos, R.id.buttoncos);
        assignId(buttonsin, R.id.buttonsin);
        assignId(buttontan, R.id.buttontan);
        assignId(buttondivise, R.id.buttondivise);
        assignId(buttonmultiple, R.id.buttonmutiple);
        assignId(buttonplus, R.id.buttonplus);
        assignId(buttonmoins, R.id.buttonmoins);
        assignId(buttonegale, R.id.buttonegale);
        assignId(buttonvirgule, R.id.buttonvirgule);
        assignId(button0, R.id.button0);
        assignId(button1, R.id.button1);
        assignId(button2, R.id.button2);
        assignId(button3, R.id.button3);
        assignId(button4, R.id.button4);
        assignId(button5, R.id.button5);
        assignId(button6, R.id.button6);
        assignId(button7, R.id.button7);
        assignId(button8, R.id.button8);
        assignId(button9, R.id.button9);
    }

    void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();


        if (buttonText.equals("C")) {
            texte.setText("");
            result.setText("");
        } else if (buttonText.equals("=")) {
            String dataToCalculate = texte.getText().toString();
            String resultat = Calculate(dataToCalculate);
            result.setText(resultat);
        } else{
            String data = texte.getText().toString();
            if (data.equals("")){
                if (buttonText.equals("cos") || buttonText.equals("sin") || buttonText.equals("tan")) {
                    texte.setText( buttonText + " ");
                } else {
                    texte.setText( buttonText);}
            } else {
                if(buttonText.equals("+") || buttonText.equals("x") || buttonText.equals("/") || buttonText.equals("-")  ) {
                    texte.setText(data + " " + buttonText + " ");
                } else if (buttonText.equals("cos") || buttonText.equals("sin") || buttonText.equals("tan")) {
                        texte.setText(data + buttonText + " ");
                } else {
                    texte.setText(data + buttonText);
                }
            }

        }
    }

    public String Calculate(String dataToCalculate){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(dataToCalculate.split(" ")));
        System.out.println(list.size());
        try{
            for(int k=0; k<list.size(); k++) {
                String s = list.get(k);
                if (s.equals("cos")){
                    String n = list.get(k+1);
                    double angdeg = Double.valueOf(n).doubleValue();
                    double result = Math.cos((angdeg* Math.PI / 180));
                    double resultarr = Math.round(result*1000000.0)/1000000.0;
                    System.out.println(resultarr);
                    String resultat = String.valueOf(resultarr);
                    String s1 = list.remove(k+1);
                    String s2 = list.remove(k);
                    list.add(k,resultat);
                } else if (s.equals("sin")){
                    String n = list.get(k+1);
                    double angdeg = Double.valueOf(n).doubleValue();
                    double result = Math.sin((angdeg* Math.PI / 180));
                    double resultarr = Math.round(result*1000000.0)/1000000.0;
                    System.out.println(resultarr);
                    String resultat = String.valueOf(resultarr);
                    String s1 = list.remove(k+1);
                    String s2 = list.remove(k);
                    list.add(k,resultat);
                } else if (s.equals("tan")){
                    String n = list.get(k+1);
                    double angdeg = Double.valueOf(n).doubleValue();
                    double result = Math.tan((angdeg* Math.PI / 180));
                    double resultarr = Math.round(result*1000000.0)/1000000.0;
                    System.out.println(resultarr);
                    String resultat = String.valueOf(resultarr);
                    String s1 = list.remove(k+1);
                    String s2 = list.remove(k);
                    list.add(k,resultat);
                }
            }
            if (list.size()==1){
                return list.get(0);
            } else {
                do {
                    System.out.println(list.size());
                    String nb1_a = list.get(0);
                    String nb2_a = list.get(2);
                    double nb1 = Double.valueOf(nb1_a).doubleValue();
                    double nb2 = Double.valueOf(nb2_a).doubleValue();
                    String op = list.get(1);
                    double result = 0;
                    if (op.equals("+")) {
                        result = nb1 + nb2;
                    } else if (op.equals("-")) {
                        result = nb1 - nb2;
                    } else if (op.equals("x")) {
                        result = nb1 * nb2;
                    } else if (op.equals("/")) {
                            result = nb1 / nb2;
                    }
                    String resultat = String.valueOf(result);
                    list.remove(2);
                    list.remove(1);
                    list.remove(0);
                    list.add(0,resultat);
            } while(list.size() !=1);
                return list.get(0);
            }
        } catch (Exception e){
            return "erreur";
        }
    }
}
