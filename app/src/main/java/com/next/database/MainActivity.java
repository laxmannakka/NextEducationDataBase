package com.next.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button list_employee= (Button) findViewById(R.id.button);
        Button group_employee = (Button) findViewById(R.id.button2);
        list_employee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, LIstActivity.class);
                startActivity(intent);
            }
        });

        group_employee.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent listActivity = new Intent(MainActivity.this,ExpandableListViewActivity.class);
                startActivity(listActivity);
            }
        });    
    }



}
