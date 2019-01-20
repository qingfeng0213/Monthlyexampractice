package com.example.monthlyexampractice;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monthlyexampractice.fragment.CarFragment;
import com.example.monthlyexampractice.fragment.HomeFragment;
import com.example.monthlyexampractice.fragment.MyFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuActivity extends AppCompatActivity {

    @BindView(R.id.edit_top_main)
    EditText editTopMain;
    @BindView(R.id.bn_edit_main)
    Button bnEditMain;
    @BindView(R.id.flowLayout_main)
    FlowLayout flowLayoutMain;
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    private List<String> list = new ArrayList<>();
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        ButterKnife.bind(this);

        for (int i = 0; i < 10; i++) {
            list.add("Android");
            list.add("Java");
            list.add("IOS");
            list.add("python");
        }

        //往容器内添加TextView数据
        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowLayoutMain != null) {
            flowLayoutMain.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(28, 10, 28, 10);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setBackgroundResource(R.color.colorPrimary);
            tv.setLayoutParams(layoutParams);
            flowLayoutMain.addView(tv, layoutParams);
        }
        bnEditMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTopMain.getText())) {
                    Toast.makeText(ZhuActivity.this, "搜索内容为空，请输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    TextView tv = new TextView(ZhuActivity.this);
                    tv.setPadding(28, 10, 28, 10);
                    tv.setText(editTopMain.getText());
                    tv.setMaxEms(10);
                    tv.setSingleLine();
                    tv.setBackgroundResource(R.color.colorPrimary);
                    tv.setLayoutParams(layoutParams);
                    flowLayoutMain.addView(tv, layoutParams);
                }
            }
        });

        flowLayoutMain.setVisibility(View.GONE);

        editTopMain.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    flowLayoutMain.setVisibility(View.VISIBLE);
                } else {
                    flowLayoutMain.setVisibility(View.GONE);
                }
            }
        });

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.common_tab_btn_home_n_xhdpi, HomeFragment.class)
                .addTabItem("购物车", R.drawable.common_tab_btn_list_n_xhdpi, CarFragment.class)
                .addTabItem("我的", R.drawable.common_tab_btn_my_n_xhdpi, MyFragment.class)
                .isShowDivider(false);

        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                linearLayout.setFocusable(true);
                linearLayout.setFocusableInTouchMode(true);
                linearLayout.requestFocus();
                return false;
            }
        });
    }
}
