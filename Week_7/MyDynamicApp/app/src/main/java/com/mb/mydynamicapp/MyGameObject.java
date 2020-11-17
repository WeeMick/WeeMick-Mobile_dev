package com.mb.mydynamicapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class MyGameObject {
    protected float x, y, dx, dy;
    protected Drawable image;
    Paint p = new Paint();
    float width=200, height=200;

    public MyGameObject(float x, float y, float dx, float dy, Drawable image) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.image = image;
        p.setColor(Color.RED);
        p.setTextSize(100);

    }

    void move(Canvas canvas)
    {
        x+=dx;
        y+=dy;
        if(x > canvas.getWidth() - width || x<0)
            dx=-dx;
        if(y > canvas.getHeight() - height || y<0)
            dy=-dy;
//        canvas.drawText("Hello", x, y, p);
        image.setBounds((int)x, (int)y, (int)(x + width), (int)(y + height));
        image.draw(canvas);
    }

}
