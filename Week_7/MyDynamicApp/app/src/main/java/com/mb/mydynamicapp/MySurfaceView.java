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

import java.util.ArrayList;

public class MySurfaceView extends SurfaceView implements Runnable {

    SurfaceHolder myHolder;
    Thread myThread;
    boolean isRunning = true;
    Paint pWhite;
//    MyGameObject myObject;
     ArrayList<MyGameObject> gameObjs = new ArrayList<MyGameObject>();


    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        pWhite = new Paint();
        pWhite.setColor(Color.WHITE);

        myThread = new Thread(this);
        myThread.start();
        myHolder = getHolder();

        MyGameObject myObject = new MyGameObject(100,300,10,10,null);
        MyGameObject myObject2 = new MyGameObject(200,200,10,10,null);
        MyGameObject myObject3 = new MyGameObject(300,100,10,10,null);

        gameObjs.add(new MyGameObject(100, 500, 2, -2, ContextCompat.getDrawable(context, R.drawable.fish1)));

        gameObjs.add(new MyGameObject(500, 500, -2, 2, ContextCompat.getDrawable(context, R.drawable.fish2)));

        gameObjs.add(new MyGameObject(300, 300, 4, 4, ContextCompat.getDrawable(context, R.drawable.fish3)));


//        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.fish1);
//        myObject = new MyGameObject(100,100,10,10,drawable);

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
            for( MyGameObject object : gameObjs ) {
                object.move(canvas);
            }

            myHolder.unlockCanvasAndPost(canvas);
        }

    }
}
