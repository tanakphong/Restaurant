package com.deverdie.restaurant.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deverdie.restaurant.R;
import com.deverdie.restaurant.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> dataList;

    public EmployeeAdapter(ArrayList<Employee> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.txtEmpName.setText(dataList.get(position).getEmployeeName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmployeeEmail());
        holder.txtEmpPhone.setText(dataList.get(position).getEmployeePhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail, txtEmpPhone;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            txtEmpName = itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail =  itemView.findViewById(R.id.txt_employee_email);
            txtEmpPhone =  itemView.findViewById(R.id.txt_employee_phone);
        }
    }
}
