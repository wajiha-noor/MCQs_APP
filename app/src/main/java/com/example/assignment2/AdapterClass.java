package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    Context context;
    ArrayList <ModelClass> trueFalse;
    RadioGroup radioGroup;
    int count=0;

    AdapterClass(Context context,ArrayList<ModelClass> trueFalse){
        this.context=context;
        this.trueFalse=trueFalse;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cardsample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        holder.ques.setText(trueFalse.get(position).question);
        int id = radioGroup.getCheckedRadioButtonId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (id == holder.True.getId() && Objects.equals(trueFalse.get(holder.getAdapterPosition()).ans, "T")) {
                    count++;
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return trueFalse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ques;
        CardView cardView;
        RadioButton True,False;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ques=itemView.findViewById(R.id.ques);
            cardView= itemView.findViewById(R.id.cardView);
            radioGroup=itemView.findViewById(R.id.radioGroup);
            True=itemView.findViewById(R.id.True);
            False=itemView.findViewById(R.id.False);

        }
    }
    public int getCount(){
        return count;

    }

}
