package com.next.database.modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.next.database.R;

import java.util.List;

/**
 * Created by next on 25/3/17.
 */
public class ListViewAdapter extends BaseAdapter
{
     private List<Employee> employeeList;
   private List<Dept> deptList;
     Context context;

    public ListViewAdapter(List<Employee> employeeList, Context context)
    {
        this.employeeList = employeeList;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder viewholder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
            viewholder = new ViewHolder();
            viewholder.empId = (TextView) convertView.findViewById(R.id.empId);
            viewholder.empName = (TextView) convertView.findViewById(R.id.emp_name);
            viewholder.date_Joining = (TextView)convertView.findViewById(R.id.date);
            viewholder.depId =(TextView)convertView.findViewById(R.id.deptId);
            viewholder.depName =(TextView)convertView.findViewById(R.id.depName);

            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.empId.setText(String .valueOf(employeeList.get(position).getEmpId()));
        viewholder.empName.setText(employeeList.get(position).getEmployeeName());
        viewholder.date_Joining.setText(employeeList.get(position).getJoiningDate());
        viewholder.depId.setText(String.valueOf(employeeList.get(position).getDepartMentId()));
        viewholder.depName.setText(employeeList.get(position).getDepartment());
        return convertView;
    }


    public class ViewHolder {
        TextView empId;
        TextView empName;
        TextView date_Joining;
        TextView depId;
        TextView depName;
    }
}
