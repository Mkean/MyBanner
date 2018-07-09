package com.example.mybanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author:王庆
 * date：On 2018/7/9
 */
public class IndexPoint extends View {

    private Paint mPaint;
    private Paint indexPaint;
    private int mRadius = 50;//圆形半径
    private int textSize;//字号大小
    private int index;
    private int length;


    public void setIndex(int index) {
        this.index = index;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public IndexPoint(Context context) {
        super(context);
    }

    public IndexPoint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setAlpha(100);
        mPaint.setStyle(Paint.Style.FILL);


        //设置文字画笔属性
        indexPaint = new Paint();
        indexPaint.setColor(Color.WHITE);
        indexPaint.setTextSize(24);
        indexPaint.setStyle(Paint.Style.FILL);
        indexPaint.setAntiAlias(true);
        textSize = (int) indexPaint.getTextSize();
    }

    public IndexPoint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(30, 30, 30, mPaint);
        if(index >=length){
            index =length;
        }
        if(index <=1){
            index = 1;
        }
        canvas.drawText(index + "/" + length, (float) 13, (float) 38, indexPaint);
    }
}
