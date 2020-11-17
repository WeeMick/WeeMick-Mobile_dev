package com.mb.mydynamicapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.core.content.ContextCompat;

public class MySurfaceView extends SurfaceView implements Runnable {

    SurfaceHolder myHolder;
    Thread myThread;
    boolean isRunning = true;
    Paint pWhite;
    MyGameObject myObject;


    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        pWhite = new Paint();
        pWhite.setColor(Color.WHITE);

        myThread = new Thread(this);
        myThread.start();
        myHolder = getHolder();
        myObject = new MyGameObject(100,100,10,10,null);

        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.fish1);
        myObject = new MyGameObject(100,100,10,10,drawable);

    }

    @Override
    public void run() {
        while(isRunning)
        {
            if(!myHolder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = myHolder.lockCanvas();
            canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(), pWhite);
            myObject.move(canvas);
            myHolder.unlockCanvasAndPost(canvas);
        }

    }
}
