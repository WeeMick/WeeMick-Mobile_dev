package com.mb.sensorsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    private float x,y,z;
    private Paint p = new Paint();

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        p=new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setColor(Color.GREEN);
        p.setStrokeWidth(3);
        p.setTextSize(80);
        setBackgroundColor(Color.LTGRAY);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("Hello "+x+","+y+","+z, 100+50*x, 600+50*y, p);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getZ() {
        return z;
    }

    @Override
    public void setZ(float z) {
        this.z = z;
    }
}
