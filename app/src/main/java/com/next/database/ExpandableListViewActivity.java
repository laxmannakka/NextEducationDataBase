package com.next.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.next.database.Database.DataBaseHandler;
import com.next.database.adapter.ExpandableLIstViewAdapter;
import com.next.database.modal.Dept;
import com.next.database.modal.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewActivity extends AppCompatActivity
{
    private ExpandableListView mExpandableListView;
    private List<Employee> mList = new ArrayList<>();
    HashMap<Integer,List<Employee>> selectdMap = new HashMap<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandable_listview);
        DataBaseHandler db = new DataBaseHandler(this);
      final  List<Dept> deptArrayList = db.getAllDepartMents();
       // List<Employee> employeeList = db.getAllEmployees();

        final ExpandableLIstViewAdapter adapter = new ExpandableLIstViewAdapter(mList, deptArrayList,this);
         mExpandableListView.setAdapter(adapter);
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id)
            {

                mList= new DataBaseHandler(ExpandableListViewActivity.this).getChildData(deptArrayList.get(groupPosition).getDepartmentId());
               selectdMap.put(groupPosition,mList);
                adapter.setHashMap(selectdMap);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
