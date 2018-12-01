package com.epiclancers.scrolllistener;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterForList  extends RecyclerView.Adapter<AdapterForList.TheListViewHolder>{


    Context context;
    ArrayList<String> arrayList;

    public AdapterForList(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TheListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.list_view, parent, false);
        return new TheListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheListViewHolder holder, int position) {
        holder.textView.append(" "+(++position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TheListViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public TheListViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }
}
