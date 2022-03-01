package com.example.rakelinkmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter2 extends ArrayAdapter {
    List list=new ArrayList();
    public ContactAdapter2(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add(Contacts2 object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row=convertView;
        ContactHolder2 contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout2,parent,false);
            contactHolder=new ContactHolder2();
            contactHolder.tx_lieoverduration=(TextView) row.findViewById(R.id.tx_lieoverduration);
            contactHolder.tx_rakeno=(TextView) row.findViewById(R.id.tx_rakeno);
            contactHolder.tx_trainname=(TextView) row.findViewById(R.id.tx_trainname);
            contactHolder.tx_trainno=(TextView) row.findViewById(R.id.tx_trainno);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder=(ContactHolder2) row.getTag();
        }
        Contacts2 contacts=(Contacts2) this.getItem(position);
        //contactHolder.tx_station.setText(contacts.getStation());
        //contactHolder.tx_code.setText(contacts.getCode());
        //contactHolder.tx_arrday.setText(contacts.getArrday());
        //contactHolder.tx_arrtime.setText(contacts.getArrtime());
        //contactHolder.tx_depday.setText(contacts.getDepday());
        //contactHolder.tx_deptime.setText(contacts.getDeptime());
        contactHolder.tx_lieoverduration.setText(contacts.getLieoverduration());
        contactHolder.tx_rakeno.setText(contacts.getRakeno());
        contactHolder.tx_trainname.setText(contacts.getTrainname());
        contactHolder.tx_trainno.setText(contacts.getTrainno());
        return row;
    }
    static class ContactHolder2 {
        TextView tx_lieoverduration, tx_rakeno, tx_trainname,tx_trainno;
    }
}
