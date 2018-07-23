package com.example.ui;

import android.app.Dialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.base.BaseActivity;
import com.example.bean.AreaData;
import com.example.bean.AreaModel;
import com.example.mybanner.R;
import com.example.mylibrary.DatePickerDialog;
import com.example.mylibrary.DateUtil;
import com.example.utils.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 未完成效果：
 * 性别、孩子年龄、城市
 * 待完善：
 * EditText焦点问题
 */
public class PersonalActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "PersonalActivity";
    private SimpleDraweeView mHeadPortrait;
    private EditText mNickName;
    private TextView mLeft_cancel;
    private TextView mRight_title;
    private TextView mChange_headPortrait;
    private TextView mSex;
    private EditText mPersonalized_signature_content;
    private TextView mBirth;
    private TextView mChild_age;
    private TextView mCity;
    private Dialog dateDialog;
    private RelativeLayout mBirth_rlv;
    private RelativeLayout mSex_rlv;
    private RelativeLayout mChild_age_rlv;
    private RelativeLayout mCity_rlv;
    private OptionsPickerView pickerView;


    @Override
    protected int setLayout() {
        return R.layout.activity_personal;
    }

    @Override
    protected void setListener() {
        mHeadPortrait.setOnClickListener(this);
        mLeft_cancel.setOnClickListener(this);
        mRight_title.setOnClickListener(this);
        mChange_headPortrait.setOnClickListener(this);
        mSex_rlv.setOnClickListener(this);
        mBirth_rlv.setOnClickListener(this);
        mChild_age_rlv.setOnClickListener(this);
        mCity_rlv.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        pickerView = new OptionsPickerView(this);
        Uri parse = Uri.parse("https://cbu01.alicdn.com/img/ibank/2018/147/387/8580783741_1348415983.400x400.jpg");
        mHeadPortrait.setImageURI(parse);
        new MyAsyncTask().execute();
    }

    @Override
    protected void initView() {
        mHeadPortrait = (SimpleDraweeView) findViewById(R.id.headPortrait);//头像
        mNickName = (EditText) findViewById(R.id.nickName);//昵称
        mLeft_cancel = (TextView) findViewById(R.id.left_cancel);//取消
        mRight_title = (TextView) findViewById(R.id.right_title);//保存
        mChange_headPortrait = (TextView) findViewById(R.id.change_headPortrait);//修改头像
        mSex_rlv = (RelativeLayout) findViewById(R.id.sex_rlv);//性别
        mSex = (TextView) findViewById(R.id.sex);//性别
        mPersonalized_signature_content = (EditText) findViewById(R.id.Personalized_signature_content);//个性签名
        mBirth = (TextView) findViewById(R.id.birth);//生日
        mBirth_rlv = (RelativeLayout) findViewById(R.id.birth_rlv);//生日
        mChild_age = (TextView) findViewById(R.id.child_age);//孩子年龄
        mChild_age_rlv = (RelativeLayout) findViewById(R.id.child_age_rlv);//孩子年龄
        mCity = (TextView) findViewById(R.id.city);//城市
        mCity_rlv = (RelativeLayout) findViewById(R.id.city_rlv);//城市


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.headPortrait:
                break;
            case R.id.left_cancel:
                CloseActivity();
                break;
            case R.id.right_title:
                Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_headPortrait:
                break;
            case R.id.sex_rlv:
                break;
            case R.id.birth_rlv:
                setABirthday(DateUtil.getDateForString("1990-01-01"));
                break;
            case R.id.child_age_rlv:
                break;
            case R.id.city_rlv:
                pickerView.show();
                break;
            default:
                break;

        }
    }

    private void setABirthday(List<Integer> date) {

//        //获取当前年月日
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);//当前年
//        int month = calendar.get(Calendar.MONTH);//当前月
//        int day = calendar.get(Calendar.DAY_OF_MONTH);//当前日
//        //new一个日期选择对话框的对象,并设置默认显示时间为当前的年月日时间.
//        DatePickerDialog dialog = new DatePickerDialog(this, mdateListener, year, month, day);
//        dialog.show();
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {

                mBirth.setText(dates[0] + "年" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "月"
                        + (dates[2] > 9 ? dates[2] : ("0" + dates[2])) + "日");

            }

            @Override
            public void onCancel() {

            }
        })

                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);

        builder.setMaxYear(DateUtil.getYear());
        builder.setMaxMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMaxDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        dateDialog = builder.create();
        dateDialog.show();

    }

    class MyAsyncTask extends AsyncTask<Void, Void, AreaModel> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected AreaModel doInBackground(Void... params) {

            return Utils.readAreaJson(getApplicationContext(), AreaModel.class);
        }

        @Override
        protected void onPostExecute(AreaModel areaModel) {
            super.onPostExecute(areaModel);

            if (null == areaModel) {
                return;
            }
            List<AreaData> datas = areaModel.getData();
            if (null == datas || datas.isEmpty()) {
                return;
            }
            final ArrayList<String> areaList = new ArrayList<>();
            final ArrayList<ArrayList<String>> cities = new ArrayList<>();

            for (AreaData data : datas) {
                if (null == data) {
                    continue;
                }
                if (!TextUtils.isEmpty(data.getName())) {
                    areaList.add(data.getName());
                }
                cities.add(data.getCities());
            }

            if (null != pickerView) {
                pickerView.setPicker(areaList, cities, true);
                pickerView.setCyclic(false);

                pickerView.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        mCity.setText(getString(R.string.area_text, areaList.get(options1) + " - " + cities.get(options1).get(option2)));
                    }
                });
            }
        }
    }
}
