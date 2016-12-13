package com.example.sm.problem2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    ArrayList<Employee> emp_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emp_list=new ArrayList<>();
        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);

        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee;

        switch (v.getId()){
            case R.id.btn_inc:
                // need something here

                break;

            case R.id.btn_dec:
                break;

            case R.id.btn_store:

                employee=new Employee(edit_name.getText().toString(),Integer.parseInt(edit_age.getText().toString()),Integer.parseInt(edit_salary.getText().toString()));
                adapter.add(employee);
                break;

            case R.id.btn_modify:
                employee=new Employee(edit_name.getText().toString(),Integer.parseInt(edit_age.getText().toString()),Integer.parseInt(edit_salary.getText().toString()));
                adapter.add(employee);
                break;

            case R.id.btn_delete:
               adapter.delete(adapter.getpos());
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
