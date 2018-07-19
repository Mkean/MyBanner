package com.example.home;

import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.base.BaseActivity;
import com.example.mybanner.R;
import com.example.ui.SettingsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mLeftClose;
    private ImageView mRightTask;
    private RelativeLayout mPersonal;
    private SimpleDraweeView mHeadPortrait;
    private TextView mNickName;
    private TextView mLevel;
    private TextView mIntegralAmount;
    private TextView mPersonalHomepage;
    private ImageView mRightLeft;
    private RelativeLayout mAttention;
    private RelativeLayout mCollections;
    private RelativeLayout mMessages;
    private RelativeLayout mShoppingCart;
    private RelativeLayout mOrders;
    private RelativeLayout mAddresses;
    private RelativeLayout mWishList;
    private RelativeLayout mIntegral;
    private RelativeLayout mCustomerService;
    private RelativeLayout mSettings;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected int setLayout() {

        return R.layout.activity_home;
    }

    protected void setListener() {
        mLeftClose.setOnClickListener(this);
        mRightTask.setOnClickListener(this);
        mPersonal.setOnClickListener(this);
        mHeadPortrait.setOnClickListener(this);
        mNickName.setOnClickListener(this);
        mLevel.setOnClickListener(this);
        mIntegralAmount.setOnClickListener(this);
        mPersonalHomepage.setOnClickListener(this);
        mRightLeft.setOnClickListener(this);
        mPersonalHomepage.setOnClickListener(this);
        mAttention.setOnClickListener(this);
        mCollections.setOnClickListener(this);
        mMessages.setOnClickListener(this);
        mShoppingCart.setOnClickListener(this);
        mOrders.setOnClickListener(this);
        mAddresses.setOnClickListener(this);
        mWishList.setOnClickListener(this);
        mIntegral.setOnClickListener(this);
        mCustomerService.setOnClickListener(this);
        mSettings.setOnClickListener(this);
    }

    protected void initData() {
        Uri parse = Uri.parse("https://cbu01.alicdn.com/img/ibank/2018/147/387/8580783741_1348415983.400x400.jpg");
        mHeadPortrait.setImageURI(parse);
    }

    protected void initView() {
        mLeftClose = (ImageView) findViewById(R.id.left_close);
        mRightTask = (ImageView) findViewById(R.id.right_task);
        mPersonal = (RelativeLayout) findViewById(R.id.personal);
        mHeadPortrait = (SimpleDraweeView) findViewById(R.id.headPortrait);
        mNickName = (TextView) findViewById(R.id.nickName);
        mLevel = (TextView) findViewById(R.id.level);
        mIntegralAmount = (TextView) findViewById(R.id.integralAmount);
        mPersonalHomepage = (TextView) findViewById(R.id.personalHomepage);
        mRightLeft = (ImageView) findViewById(R.id.right_left);
        mAttention = (RelativeLayout) findViewById(R.id.attention);
        mCollections = (RelativeLayout) findViewById(R.id.collections);
        mMessages = (RelativeLayout) findViewById(R.id.messages);
        mShoppingCart = (RelativeLayout) findViewById(R.id.shoppingCart);
        mOrders = (RelativeLayout) findViewById(R.id.orders);
        mAddresses = (RelativeLayout) findViewById(R.id.addresses);
        mWishList = (RelativeLayout) findViewById(R.id.wishList);
        mIntegral = (RelativeLayout) findViewById(R.id.integral);
        mCustomerService = (RelativeLayout) findViewById(R.id.customerService);
        mSettings = (RelativeLayout) findViewById(R.id.settings);

    }

    //重写back事件，改变退出状态
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_close:

                break;
            case R.id.right_task:

                break;
            case R.id.personal:

                break;
            case R.id.headPortrait:

                break;
            case R.id.nickName:

                break;
            case R.id.level:

                break;
            case R.id.integralAmount:

                break;
            case R.id.personalHomepage:

                break;
            case R.id.right_left:

                break;

            case R.id.attention:

                break;
            case R.id.collections:

                break;
            case R.id.messages:

                break;
            case R.id.shoppingCart:

                break;
            case R.id.orders:

                break;
            case R.id.addresses:

                break;
            case R.id.wishList:

                break;
            case R.id.integral:

                break;
            case R.id.customerService:

                break;

            case R.id.settings:
                startActivity(SettingsActivity.class);
                break;
            default:
                break;


        }
    }

}
