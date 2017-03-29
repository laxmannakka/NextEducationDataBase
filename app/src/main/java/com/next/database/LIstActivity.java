package com.next.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.next.database.Database.DataBaseHandler;
import com.next.database.modal.Dept;
import com.next.database.modal.Employee;
import com.next.database.modal.ListViewAdapter;

import java.util.List;

public class LIstActivity extends AppCompatActivity
{

   private ExpandableListView mExpandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
     //   mExpandableListView = (ExpandableListView) findViewById(R.id.expandable_listview);

        ListView listView = (ListView) findViewById(R.id.listview);
        DataBaseHandler db = new DataBaseHandler(this);
        db.addDepartMentstoDb(new Dept(1,"Android"));
        db.addDepartMentstoDb(new Dept(2,"JavaScript"));
        db.addDepartMentstoDb(new Dept(3,"Java"));
        List<Dept> deptArrayList = db.getAllDepartMents();

        db.addEmployeeDetails(new Employee(1,"Laxman","12-09-2012","8500819120",11));
        db.addEmployeeDetails(new Employee(1,"nadim","11-01-2012","99999999",12));
        db.addEmployeeDetails(new Employee(2,"ppppp","19-01-2012","909090909",13));
        db.addEmployeeDetails(new Employee(2,"llll","10-09-12","75009098",14));
        db.addEmployeeDetails(new Employee(2,"llll","10-09-12","75009098",15));
        db.addEmployeeDetails(new Employee(3,"llll","10-09-12","75009098",16));
        db.addEmployeeDetails(new Employee(3,"llll","10-09-12","75009098",17));


        List<Employee> employeeList = db.getEmployeesAndDepartment();
        ListViewAdapter adapter = new ListViewAdapter(employeeList,this);
        listView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent(LIstActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
