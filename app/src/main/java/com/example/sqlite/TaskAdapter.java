package com.example.sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.Myview> {
    private Context mCtx;
    private List<Model> Tablelist;


    public TaskAdapter (Context mainActivity, List<Model> m) {

        this.mCtx = mainActivity;
        this.Tablelist = m;
    }
    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.child,parent,false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview myview, int i) {

        Model m = Tablelist.get(i);

        myview.t1.setText(m.getName());
        myview.t2.setText(m.getCls());

    }

    @Override
    public int getItemCount() {
        return Tablelist.size();
    }

    public class Myview extends RecyclerView.ViewHolder {

        TextView  t1, t2;
        public Myview(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.cls);

        }
    }
}
