package com.example.healtha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapter extends BaseAdapter {

    ArrayList<HashMap<String, String>> list;
Context context;

    public SimpleAdapter(ArrayList<HashMap<String,String>> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v=((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.multi_lines,null);
        TextView a,b,c,d,e;
        a=v.findViewById(R.id.line_a);
        b=v.findViewById(R.id.line_b);
        c=v.findViewById(R.id.line_c);
        d=v.findViewById(R.id.line_d);
        e=v.findViewById(R.id.line_e);
        a.setText(list.get(position).get("Line1"));
        b.setText(list.get(position).get("Line2"));
        c.setText(list.get(position).get("Line3"));
        d.setText(list.get(position).get("Line4"));
        e.setText(list.get(position).get("Line5"));
        
        return v;
    }
}
