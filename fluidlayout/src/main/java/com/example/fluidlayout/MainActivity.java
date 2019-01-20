package com.example.fluidlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.shuru)
    EditText shuru;
    @BindView(R.id.sou)
    Button sou;
    @BindView(R.id.id_flowlayout)
    FlowLayout idFlowlayout;
    private List<String> list=new ArrayList<>();

    private ArrayList<String> strings;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sou.setOnClickListener(new View.OnClickListener() {

            private String name;

            @Override
            public void onClick(View v) {
                name = shuru.getText().toString();

                    TextView tv = new TextView(MainActivity.this);
                    tv.setPadding(28, 10, 28, 10);
                    tv.setText(name);
                    tv.setMaxEms(10);
                    tv.setSingleLine();
                    tv.setLayoutParams(layoutParams);
                    idFlowlayout.addView(tv, layoutParams);

            }
        });

        for (int i = 0; i <10; i++) {
            list.add("Android");
            list.add("Java");
            list.add("IOS");
            list.add("python");
        }


//往容器内添加TextView数据
        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (idFlowlayout != null) {
            idFlowlayout.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(28, 10, 28, 10);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setLayoutParams(layoutParams);
            idFlowlayout.addView(tv, layoutParams);
        }
    }
}
