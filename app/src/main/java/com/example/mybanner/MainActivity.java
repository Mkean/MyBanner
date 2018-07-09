package com.example.mybanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CycleViewPager pager;
    private List<Integer> list = new ArrayList<>();
    private List<ImageView> list1;
    private Context _context;
    private IndexPoint mIndexPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this._context = this;
        initView();
        initData();
        initListener();
    }

    protected void initView() {
//找到我们的ViewPager和指示点的容器
        pager = (CycleViewPager) findViewById(R.id.banner);
        mIndexPoint = (IndexPoint) findViewById(R.id.indexPoint);
    }

    @Override
    public void onStart() {
        super.onStart();
        //当activity可见的时候开启轮播图
        pager.startScroll();
    }

    @Override
    public void onStop() {
        super.onStop();
//不可见的时候关闭轮播图
        pager.stopScroll();
    }

    protected void initData() {
//初始化轮播图数据
        if (list.size() == 0) {
            list.add(R.drawable.picture1);
            list.add(R.drawable.picture2);
            list.add(R.drawable.picture3);
            list.add(R.drawable.picture4);
        }

        int currentItem = pager.getCurrentItem();
        mIndexPoint.setIndex(currentItem+1);
        mIndexPoint.setLength(list.size());
        pager.setAdapter(new MyItemPagerAdapter(_context, list));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mIndexPoint.setIndex(position);
                mIndexPoint.invalidate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }


    protected void initListener() {
        pager.setOnItemClickListener(new CycleViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //可以在这里做跳转的操作，当轮播图页面被点击的时候，就会响应
                Toast.makeText(_context, "跳转到详情界面"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
