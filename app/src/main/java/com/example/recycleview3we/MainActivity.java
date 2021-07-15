package com.example.recycleview3we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemCLICKlistner{
    private ArrayList<Employee>employeeList=new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView cardView;
    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtAddress;
    private Button mBtnDone;
    private EmployeeAdapter view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitViews();
        buildEmployee();
        setLayout();
    }

    private void setLayout() {
         view =new EmployeeAdapter(employeeList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(view);
    }

    private void buildEmployee() {
        for (int i =0;i<50;i++){
            Employee employee = new Employee("nalini",i+1,"bainchua");
            employeeList.add(employee);
        }
    }

    private void intitViews() {
        mBtnDone=findViewById(R.id.btnDone);
        mEtAddress=findViewById(R.id.etAddress);
        mEtAge=findViewById(R.id.etAge);
        mEtName=findViewById(R.id.etName);
        cardView=findViewById(R.id.editCardView);
        recyclerView=findViewById(R.id.recyclerView);

    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        cardView.setVisibility(View.VISIBLE);
        mEtName.setText(employee.getName());
        mEtAge.setText(employee.getAge()+"");
        mEtAddress.setText(employee.getAddress());

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee new_employee=new Employee(mEtName.getText().toString(),Integer.parseInt(mEtAge.getText().toString()),mEtAddress.getText().toString());

                cardView.setVisibility(View.GONE);
                employeeList.set(position,new_employee);
                view.notifyDataSetChanged();

            }
        });

    }
}