package com.example.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.base.BaseActivity;
import com.example.mybanner.R;

public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mLeft_back;
    private TextView mTitle_bar;
    private LinearLayout mPhone_rlv;
    private TextView mPhone_num;
    private RelativeLayout mChange_password;
    private LinearLayout mWeChat_account;
    private TextView mWeChat_account_num;
    private LinearLayout mMicroblog_account;
    private TextView mMicroblog_account_num;
    private LinearLayout mQQ_account;
    private TextView mQQ_account_num;

    @Override
    protected int setLayout() {
        return R.layout.activity_account_security;
    }

    @Override
    protected void setListener() {
        mLeft_back.setOnClickListener(this);
        mPhone_rlv.setOnClickListener(this);
        mChange_password.setOnClickListener(this);
        mWeChat_account.setOnClickListener(this);
        mMicroblog_account.setOnClickListener(this);
        mQQ_account.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mTitle_bar.setText("账号与安全");
    }

    @Override
    protected void initView() {
        mLeft_back = (ImageView) findViewById(R.id.left_back);
        mTitle_bar = (TextView) findViewById(R.id.title_bar);
        mPhone_rlv = (LinearLayout) findViewById(R.id.phone_rlv);
        mPhone_num = (TextView) findViewById(R.id.phone_num);
        mChange_password = (RelativeLayout) findViewById(R.id.change_password);
        mWeChat_account = (LinearLayout) findViewById(R.id.weChat_account);
        mWeChat_account_num = (TextView) findViewById(R.id.weChat_account_num);
        mMicroblog_account = (LinearLayout) findViewById(R.id.microblog_account);
        mMicroblog_account_num = (TextView) findViewById(R.id.microblog_account_num);
        mQQ_account = (LinearLayout) findViewById(R.id.qq_account);
        mQQ_account_num = (TextView) findViewById(R.id.qq_account_num);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                CloseActivity();
                break;
            case R.id.phone_rlv:
                break;
            case R.id.change_password:
                break;
            case R.id.weChat_account_num:
                break;
            case R.id.microblog_account:
                break;
            case R.id.qq_account:
                break;
        }
    }
}
