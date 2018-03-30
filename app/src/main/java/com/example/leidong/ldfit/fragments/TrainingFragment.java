package com.example.leidong.ldfit.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.ldfit.MyApplication;
import com.example.leidong.ldfit.R;
import com.example.leidong.ldfit.adapters.MyRecommendAdapter;
import com.example.leidong.ldfit.adapters.MyTrainingAdapter;
import com.example.leidong.ldfit.models.MyRecommend;
import com.example.leidong.ldfit.models.MyTraining;
import com.example.leidong.ldfit.ui.GraphActivity;
import com.example.leidong.ldfit.ui.MyParamsActivity;
import com.example.leidong.ldfit.utils.LoadDataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leido on 2018/3/18.
 */

public class TrainingFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "TrainingFragment";

    @BindView(R.id.iv_avatar)
    ImageView mAvatar;

    @BindView(R.id.tv_weight)
    TextView mWeight;

    @BindView(R.id.tv_growth_value)
    TextView mGrowthValue;

    @BindView(R.id.ll_total_exercise)
    LinearLayout mTotalExerciseLayout;

    @BindView(R.id.tv_total_exercise)
    TextView mTotalExercise;

    @BindView(R.id.tv_total_days)
    TextView mTotalDays;

    @BindView(R.id.tv_week_exercise)
    TextView mWeekExercise;

    @BindView(R.id.my_training_list)
    RecyclerView mMyTrainingList;

    @BindView(R.id.my_recommend_list)
    RecyclerView mMyRecommendList;

    MyTraining.MyTrainingBean[] myTrainingBeans;
    MyRecommend.MyRecommendBean[] myRecommendBeans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_training, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        mAvatar.setOnClickListener(this);
        mTotalExerciseLayout.setOnClickListener(this);

        myTrainingBeans = LoadDataUtils.loadMyTrainingJson();
        mMyTrainingList.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        mMyTrainingList.setAdapter(new MyTrainingAdapter(MyApplication.getContext(), myTrainingBeans));

        myRecommendBeans = LoadDataUtils.loadMyRecommendJson();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApplication.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mMyRecommendList.setLayoutManager(linearLayoutManager);
        mMyRecommendList.setAdapter(new MyRecommendAdapter(MyApplication.getContext(), myRecommendBeans));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.iv_avatar:
                clickAvatar();
                break;
            case R.id.ll_total_exercise:
                clickTotalExerciseLayout();
                break;
        }
    }

    /**
     * 点击全部运动信息
     */
    private void clickTotalExerciseLayout() {
        Intent intent = new Intent(MyApplication.getContext(), GraphActivity.class);
        startActivity(intent);
    }

    /**`
     * 点击头像
     */
    private void clickAvatar() {
        Intent intent = new Intent(getActivity(), MyParamsActivity.class);
        startActivity(intent);
    }
}
