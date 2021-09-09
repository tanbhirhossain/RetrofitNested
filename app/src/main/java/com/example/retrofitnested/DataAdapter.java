package com.example.retrofitnested;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Contact> arrayList = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        if (arrayList != null) {
            Contact contact = arrayList.get(i);

            viewHolder.tv_id.setText(contact.getId());
            viewHolder.tv_name.setText(contact.getName());
            viewHolder.tv_email.setText(contact.getEmail());
            viewHolder.tv_address.setText(contact.getAddress());
            viewHolder.tv_gender.setText(contact.getGender());

            viewHolder.tv_mobile.setText(contact.getPhone().getMobile());
            viewHolder.tv_home.setText(contact.getPhone().getMobile().toString());
            viewHolder.tv_office.setText(contact.getPhone().getOffice());
        }
    }

    @Override
    public int getItemCount() {
        return (arrayList == null) ? 0 : arrayList.size();
    }

    /**
     * This method for set list in array instead of constructor
     * @param arrayList
     */
    public void setArrayList(List<Contact> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name, tv_email, tv_address, tv_gender, tv_mobile, tv_home, tv_office;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_email =  itemView.findViewById(R.id.tv_email);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_gender =  itemView.findViewById(R.id.tv_gender);
            tv_mobile =  itemView.findViewById(R.id.tv_mobile);
            tv_home = itemView.findViewById(R.id.tv_home); // Incorrect view id was fix
            tv_office =  itemView.findViewById(R.id.tv_office);

        }
    }
}
