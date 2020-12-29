package com.linkv.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Xiaohong on 2020/12/29.
 * desc:
 */
public class MyCustomView extends View {
    public static final int SAMPLE_TYPE_ROTATE = 1;
    public static final int SAMPLE_TYPE_RESTORE = 2;
    public static final int SAMPLE_TYPE_SCALE = 3;

    public MyCustomView(Context context) {
        super(context);
    }
    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 画箭头线的画笔
    Paint mLinePaint = new Paint();

    // 控件宽、高
    int mViewWidth = getWidth();
    int mViewHeight = getHeight();
    int mHalfWidth = getWidth();
    int mHalfHeight = getHeight();


    public int mSampleType = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mLinePaint.setStrokeWidth(8);
        mLinePaint.setColor(Color.BLUE);
        mViewWidth = getWidth();
        mViewHeight = getHeight();
        mHalfWidth = getWidth() / 2;
        mHalfHeight = getHeight() / 2;


        if (mSampleType == 0){
            // 画箭头
            drawUpArrow(canvas);
            // 画一个左上角的园
            drawLeftUpCircle(canvas);
        }else if(mSampleType == SAMPLE_TYPE_ROTATE){
            // 以中心顺时针旋转画布90度
            canvas.rotate(90, mHalfWidth, mHalfHeight);
            // 画箭头
            drawUpArrow(canvas);
            // 画圆
            drawLeftUpCircle(canvas);
        }else if(mSampleType == SAMPLE_TYPE_RESTORE){
            // 保存画布状态
            canvas.save();
            // 以中心顺时针旋转画布90度
            canvas.rotate(90, mHalfWidth, mHalfHeight);
            // 画箭头
            drawUpArrow(canvas);
            // 恢复画布状态。
            canvas.restore();
            // 画圆
            drawLeftUpCircle(canvas);
        }else{
            // 缩放画布
            canvas.scale(0.5f, 0.5f);
            // 画箭头
            drawUpArrow(canvas);
            // 画圆
            drawLeftUpCircle(canvas);
        }
    }

    // 画一个左上角的圆
    private void drawLeftUpCircle(Canvas canvas) {
        canvas.drawCircle(100, 100, 80, mLinePaint);
    }

    // 画一个向上的箭头
    private void drawUpArrow(Canvas canvas) {
        canvas.drawLine(mHalfWidth, 0, 0, mHalfHeight, mLinePaint); // 左边的蓝色加粗斜杠
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStrokeWidth(4);
        canvas.drawLine(mHalfWidth, 0, mViewWidth, mHalfHeight, mLinePaint);// 右边的斜杠
        canvas.drawLine(mHalfWidth, 0, mHalfWidth, mViewHeight, mLinePaint);// 垂直的竖杠
    }


    public void setSampleType(int sampleType) {
        mSampleType = sampleType;
        invalidate();
    }
}
