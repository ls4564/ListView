package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    TextView tv1,tv2,tv3,tv4;
    ListView lv;
    Intent gi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv3);
        lv = (ListView) findViewById(R.id.lv);


        gi = getIntent();
        double x1 = gi.getDoubleExtra("x1",-1);
        tv1.setText(String.valueOf(x1));

        double[] arr = new double[20];
        boolean b1 = gi.getBooleanExtra("bool",true);
        //tv2.setText(" "  + b1);
        double k = gi.getDoubleExtra("k",0);

        give_arr(arr,x1,k,b1);
        tv2.setText(" "  + arr[19]);
        String[] str3 = {"anna","banan","zipi"};

        Double[] doubleArr = new Double[arr.length];//הרשימה תומכת רק באובייקטים אז צריך להעביר את המערך double שהוא "טיפוס פשוט" למערך של אןבייקטים
        for (int i = 0; i < arr.length; i++)
        {
            doubleArr[i] = arr[i];  // המרה מ-double ל-Double
        }
            ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, android.R.layout.simple_list_item_1, doubleArr);
        lv.setAdapter(adp);




    }//לעשות שאם זה הנדסי זה יראה Q ועם זה חשבוני זה יראה N
    // N - מקום האיבר

    public void give_arr(double[] arr ,double a , double k ,boolean option)
    {// false - Engineering, true - Invoice
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}