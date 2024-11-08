package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity2 extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    TextView tv1,tv2,tv3,tv4;
    ListView lv;
    Intent gi;

    double[] arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        lv = (ListView) findViewById(R.id.lv);


        gi = getIntent();
        double x1 = gi.getDoubleExtra("x1",-1);
        tv1.setText(String.valueOf(x1));

        arr = new double[20];
        boolean b1 = gi.getBooleanExtra("bool",true);
        //tv2.setText(" "  + b1);
        double k = gi.getDoubleExtra("k",0);

        give_arr(x1,k,b1);
        /*
        Double[] doubleArr = new Double[arr.length];//הרשימה תומכת רק באובייקטים אז צריך להעביר את המערך double שהוא "טיפוס פשוט" למערך של אןבייקטים
        for (int i = 0; i < arr.length; i++)
        {
            doubleArr[i] = arr[i];  // המרה מ-double ל-Double
        }
            ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, android.R.layout.simple_list_item_1, doubleArr);

         */
        String[] arrStr = new String[arr.length];//הרשימה תומכת רק באובייקטים אז צריך להעביר את המערך double שהוא "טיפוס פשוט" למערך של אןבייקטים
        for (int i = 0; i < arr.length; i++)
        {
            arrStr[i] = String.format("%.2f", arr[i]);  // המרה מ-double ל-Double
        }

            ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrStr);
        lv.setAdapter(adp);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);

    }

    public void give_arr(double a , double k ,boolean option)
    {
        //input - the function get 2 doubles variable and one boolean, false - Engineering, true - Invoice
        //output - the function field the arr with the Invoicing or engineering series
        arr[0] = a;
        if (option)//Invoice
        {
            for (int i = 1; i < 20; i++) {
                arr[i] = arr[i-1] + k;
            }
        }
        else//Engineering
        {
            for (int i = 1; i < 20; i++)
            {
                arr[i] =  arr[i-1] * k;
            }
        }
    }
    public double sum_numbers(int index)
    {
        //input - the function get index of the arr
        //output - the function return the sum of the number between 0-index
        double sum = 0;
        for(int i = 0 ; i < index ; i++)
        {
            sum = sum + arr[i];
        }
        return sum;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        tv2.setText(String.format("%.2f", arr[position]));
        tv3.setText( (position)+1 + " ");
        tv4.setText(String.format("%.2f",sum_numbers(position)) + "");
    }

    public void go_back(View view)
    {
        finish();
    }
}