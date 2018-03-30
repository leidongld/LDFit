package com.example.leidong.ldfit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.ldfit.MyApplication;
import com.example.leidong.ldfit.R;
import com.example.leidong.ldfit.models.MyRecommend;
import com.squareup.picasso.Picasso;

/**
 * Created by leido on 2018/3/30.
 */

public class MyRecommendAdapter extends RecyclerView.Adapter<MyRecommendAdapter.ViewHolder> {
    private Context context;
    private MyRecommend.MyRecommendBean[] myRecommendBeans;

    public MyRecommendAdapter(Context context, MyRecommend.MyRecommendBean[] myRecommendBeans) {
        this.context = context;
        this.myRecommendBeans = new MyRecommend.MyRecommendBean[myRecommendBeans.length];
        for(int i = 0; i < myRecommendBeans.length; i++){
            this.myRecommendBeans[i] = myRecommendBeans[i];
        }
    }

    @Override
    public MyRecommendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.my_recommend_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRecommendAdapter.ViewHolder holder, final int position) {
        Picasso.get().load(myRecommendBeans[position].getMyRecommendImage()).resize(100, 50).centerCrop().into(holder.myRecommendImage);
        holder.myRecommendDesc.setText(myRecommendBeans[position].getMyRecommendDesc());
        holder.getMyRecommendNote.setText(myRecommendBeans[position].getMyRecommendNote());

        holder.myRecommendLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyApplication.getContext(), "点击我的推荐" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myRecommendBeans.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout myRecommendLayout;
        ImageView myRecommendImage;
        TextView myRecommendDesc;
        TextView getMyRecommendNote;

        ViewHolder(View itemView) {
            super(itemView);

            myRecommendLayout = itemView.findViewById(R.id.my_recommend_layout);
            myRecommendImage = itemView.findViewById(R.id.my_recommend_iamge);
            myRecommendDesc = itemView.findViewById(R.id.my_recommend_desc);
            getMyRecommendNote = itemView.findViewById(R.id.my_recommend_note);
        }
    }
}
