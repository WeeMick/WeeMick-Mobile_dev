package com.mb.mydrawingapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    Paint paint;
    float x=100,y=100;
    Bitmap myBitmap = null;
    Canvas myBitmapCanvas = null;
    int width=800, height=800;


    OnTouchListener t1Listener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            x=event.getX();
            y=event.getY();
            v.invalidate();
            return true;
        }
    };

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(100);
        setOnTouchListener(t1Listener);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        myBitmapCanvas.drawCircle(x, y,10,paint);
        canvas.drawBitmap(myBitmap,0,0,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getMeasuredWidth();
        height=getMeasuredHeight();
        myBitmap = Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565);
        myBitmapCanvas = new Canvas(myBitmap);
    }
}

