package com.luodong.circleprogressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author luodong
 * @date 2019/1/3 16:11
 * @describe 圆形进度view1
 */
public class CircleProgressView extends View {
    private int mWidth;
    private int mHeight;
    private float radius;//半径
    private float sweepAngle;
    private Paint mPaint;
    private Paint mPaintText;
    private float percentF;

    private int textColor = Color.RED;
    private float textSize = getResources().getDimension(R.dimen.default_text_size);
    private float progressWeight = getResources().getDimension(R.dimen.default_weight);
    private int progressColor = Color.RED;
    private int progressMax = 100;
    private int progressCur = 88;
    private boolean hasText = true;


    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        textColor = typedArray.getColor(R.styleable.CircleProgressView_textColor, textColor);
        textSize = typedArray.getDimension(R.styleable.CircleProgressView_textSize, textSize);
        progressWeight = typedArray.getDimension(R.styleable.CircleProgressView_progressWeight, progressWeight);
        progressColor = typedArray.getColor(R.styleable.CircleProgressView_progressColor, progressColor);
        progressMax = typedArray.getInteger(R.styleable.CircleProgressView_progressMax, progressMax);
        progressCur = typedArray.getInteger(R.styleable.CircleProgressView_progressCur, progressCur);
        hasText = typedArray.getBoolean(R.styleable.CircleProgressView_hasText, hasText);
        typedArray.recycle();
        init();
    }

    private void init() {

        //圆弧画笔
        mPaint = new Paint();
        mPaint.setColor(progressColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(progressWeight);
        mPaint.setStrokeCap(Paint.Cap.ROUND);//设置线冒样式，有圆 有方
        mPaint.setAntiAlias(true);//防止边缘的锯齿
        mPaint.setFilterBitmap(true);//对位图进行滤波处理

        //文字画笔
        mPaintText = new Paint();
        mPaintText.setColor(textColor);
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(textSize);
        mPaintText.setAntiAlias(true);//防止边缘的锯齿
        mPaintText.setFilterBitmap(true);//对位图进行滤波处理
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取View宽高与画笔并根据此绘制内容
        if (mHeight > mWidth) {
            radius = mWidth / 2 - progressWeight;
        } else {
            radius = mHeight / 2 - progressWeight;
        }
        canvas.translate(mWidth / 2, mHeight / 2);

        //数据
        percentF = ((float) progressCur / (float) progressMax);
        sweepAngle = 360 * percentF;

        //圆弧
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        canvas.drawArc(rectF, -90, sweepAngle, false, mPaint);

        if (hasText) {
            //百分比文字
            Rect rect = new Rect(-100, -100, 100, 100);//画一个矩形
            Paint.FontMetrics fontMetrics = mPaintText.getFontMetrics();
            float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
            float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
            int baseLineY = (int) (rect.centerY() - top / 2 - bottom / 2);//基线中间点的y轴计算公式
            canvas.drawText((int) (percentF * 100) + "%", rect.centerX(), baseLineY, mPaintText);
        }

    }

    public void setProgress(int cur, int total) {
        progressCur = cur;
        progressMax = total;
        invalidate();
    }
}
