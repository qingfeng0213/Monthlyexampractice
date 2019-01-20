package com.example.monthlyexampractice.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monthlyexampractice.MainActivity;
import com.example.monthlyexampractice.R;
import com.example.monthlyexampractice.ZhuActivity;
import com.example.monthlyexampractice.bean.LoginBean;
import com.example.monthlyexampractice.login.loginmvp.presenter.LoginPresenterIMPL;
import com.example.monthlyexampractice.login.loginmvp.view.ILoginView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    @BindView(R.id.login_name_et)
    EditText loginNameEt;
    @BindView(R.id.login_pswd_et)
    EditText loginPswdEt;
    @BindView(R.id.login_lgbt)
    Button loginLgbt;
    @BindView(R.id.login_san)
    Button loginSan;
    private LoginPresenterIMPL loginPresenterIMPL;

    //A.定义装平台的容器
    public ArrayList<SnsPlatform> platforms = new ArrayList<SnsPlatform>();
    private SHARE_MEDIA[] list = {SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE};
    private UMShareAPI mUMShareAPI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenterIMPL = new LoginPresenterIMPL(this);
        loginLgbt.setOnClickListener(new View.OnClickListener() {

            private String pwd;
            private String name;
            @Override
            public void onClick(View v) {
                name = loginNameEt.getText().toString();
                pwd = loginPswdEt.getText().toString();
                if (!name.isEmpty() && !pwd.isEmpty()) {
                    loginPresenterIMPL.getModelData(name,pwd);
                }
            }
        });

        //A.三方平台,添加到遍历的集合中
        initPlatforms();
        //A.获取UM的对象
        mUMShareAPI = UMShareAPI.get(LoginActivity.this);
        //A.获取是否授权
        final boolean isauth = UMShareAPI.get(this).isAuthorize(this, platforms.get(0).mPlatform);
        //A.点击QQ的头像,进行授权
        loginSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isauth){
                    Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
                    mUMShareAPI.deleteOauth(LoginActivity.this, platforms.get(0).mPlatform,authListener);
                }else{
                    mUMShareAPI.doOauthVerify(LoginActivity.this, platforms.get(0).mPlatform,authListener);
                }
                mUMShareAPI.getPlatformInfo(LoginActivity.this, platforms.get(0).mPlatform,authListener);

            }
        });


    }

    @Override
    public void getViewData(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void jumpActivity() {
        Intent intent = new Intent(LoginActivity.this, ZhuActivity.class);
        startActivity(intent);
    }
    private void initPlatforms() {

        //A.集合清空
        platforms.clear();
        //A.通过for循环,把数组数据添加到集合中
        for (SHARE_MEDIA e : list) {
            if (!e.toString().equals(SHARE_MEDIA.GENERIC.toString())) {
                platforms.add(e.toSnsPlatform());
            }
        }
    }
    //A.
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    //A.
    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调，可以用来处理等待框，或相关的文字提示
        }

        @Override//授权成功时回调
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Intent intent = new Intent(LoginActivity.this,ZhuActivity.class);
            startActivity(intent);
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    //B.分享的逻辑代码
    private UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(LoginActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };
}
