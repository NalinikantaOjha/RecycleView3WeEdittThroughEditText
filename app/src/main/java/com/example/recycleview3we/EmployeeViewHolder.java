package com.example.recycleview3we;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvAddress;
    private ImageView mTvEdit;
    private itemCLICKlistner itemCLICKlistner;
    public EmployeeViewHolder(@NonNull View itemView,itemCLICKlistner itemCLICKlistner) {
        super(itemView);
        intiData(itemView);
        this.itemCLICKlistner=itemCLICKlistner;
    }

    private void intiData(View itemView) {
        mTvAddress=itemView.findViewById(R.id.tvAddress);
        mTvAge=itemView.findViewById(R.id.tvAge);
        mTvEdit=itemView.findViewById(R.id.ivEdit);
        mTvName=itemView.findViewById(R.id.tvName);

    }
    public void setData(Employee employee){
        mTvName.setText(employee.getName());
        mTvAge.setText(employee.getAge()+"");
        mTvAddress.setText(employee.getAddress());
        mTvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCLICKlistner.onItemClicked(getAdapterPosition(),employee);

            }
        });


    }

}
