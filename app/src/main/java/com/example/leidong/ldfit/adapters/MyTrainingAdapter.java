package com.example.leidong.ldfit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.ldfit.MyApplication;
import com.example.leidong.ldfit.R;
import com.example.leidong.ldfit.models.MyTraining;


/**
 * Created by leido on 2018/3/30.
 */

public class MyTrainingAdapter extends RecyclerView.Adapter<MyTrainingAdapter.ViewHolder> {
    private Context context;
    private MyTraining.MyTrainingBean[] myTrainingBeans = null;

    public MyTrainingAdapter(Context context, MyTraining.MyTrainingBean[] myTrainingBeans){
        this.context = context;
        this.myTrainingBeans = new MyTraining.MyTrainingBean[myTrainingBeans.length];
        for(int i = 0; i < myTrainingBeans.length; i++){
            this.myTrainingBeans[i] = myTrainingBeans[i];
        }
    }

    @Override
    public MyTrainingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.my_training_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyTrainingAdapter.ViewHolder holder, final int position) {
        holder.myTrainingName.setText(myTrainingBeans[position].getMyTrainingname());
        holder.myTrainingDuration.setText(myTrainingBeans[position].getMyTrainingDuration() + "分钟 ");
        holder.myTrainingDesc.setText(myTrainingBeans[position].getMyTrainingDesc());
        holder.myTrainingExist.setText(myTrainingBeans[position].isMyTrainingExist() ? "已下载" : "未下载");

        holder.myTrainingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyApplication.getContext(), "点击我的训练" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myTrainingBeans.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout myTrainingLayout;
        TextView myTrainingName;
        TextView myTrainingDuration;
        TextView myTrainingDesc;
        TextView myTrainingExist;

        ViewHolder(View itemView) {
            super(itemView);
            myTrainingLayout = itemView.findViewById(R.id.my_training_layout);
            myTrainingName = itemView.findViewById(R.id.my_training_name);
            myTrainingDuration = itemView.findViewById(R.id.my_training_duration);
            myTrainingDesc = itemView.findViewById(R.id.my_training_desc);
            myTrainingExist = itemView.findViewById(R.id.my_training_exist);
        }
    }
}
