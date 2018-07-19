package com.example.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.BaseActivity;
import com.example.custom.SlideSwitch;
import com.example.mybanner.R;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mLeft_Back;
    private TextView mTitle_Bar;
    private TextView mRight_Title;
    private RelativeLayout mPersonalData;
    private RelativeLayout mAccountSecurity;
    private RelativeLayout mMessageReception;
    private SlideSwitch mSlide_switch;
    private RelativeLayout mClearCache;
    private TextView mClearCacheSize;
    private RelativeLayout mEncourage;
    private RelativeLayout mAbout;
    private Button mExitLogin;


    @Override
    protected int setLayout() {
        return R.layout.activity_settings;
    }

    protected void setListener() {
        mSlide_switch.setOnStateChangedListener(new SlideSwitch.OnStateChangedListener() {
            @Override
            public void onStateChanged(boolean state) {
                if (state) {
                    Toast.makeText(SettingsActivity.this, "开关已打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SettingsActivity.this, "开关已关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mLeft_Back.setOnClickListener(this);
        mRight_Title.setOnClickListener(this);
        mPersonalData.setOnClickListener(this);
        mAccountSecurity.setOnClickListener(this);
        mClearCache.setOnClickListener(this);
        mEncourage.setOnClickListener(this);
        mAbout.setOnClickListener(this);
        mExitLogin.setOnClickListener(this);
    }

    protected void initData() {

    }

    protected void initView() {
        mLeft_Back = (ImageView) findViewById(R.id.left_back);//返回
        mTitle_Bar = (TextView) findViewById(R.id.title_bar);//标题
        mRight_Title = (TextView) findViewById(R.id.right_title);//右边标题
        mPersonalData = (RelativeLayout) findViewById(R.id.personalData);//个人资料
        mAccountSecurity = (RelativeLayout) findViewById(R.id.accountSecurity);//账号与安全
        mMessageReception = (RelativeLayout) findViewById(R.id.messageReception);//接收消息
        mSlide_switch = (SlideSwitch) findViewById(R.id.slide_switch);//接收消息滑动开关
        mClearCache = (RelativeLayout) findViewById(R.id.clearCache);//清除缓存
        mEncourage = (RelativeLayout) findViewById(R.id.encourage);//鼓励一下
        mAbout = (RelativeLayout) findViewById(R.id.About);//关于天使之家
        mClearCacheSize = (TextView) findViewById(R.id.clearCacheSize);//缓存大小
        mExitLogin = (Button) findViewById(R.id.exitLogin);//退出登录
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                CloseActivity();
                break;
            case R.id.right_title:
                break;
            case R.id.personalData:
                startActivity(PersonalActivity.class);
                break;
            case R.id.accountSecurity:
                startActivity(AccountSecurityActivity.class);
                break;
            case R.id.clearCache:
                break;
            case R.id.encourage:
                break;
            case R.id.About:
                break;
            case R.id.exitLogin:
                break;


            default:
                break;
        }
    }
}
