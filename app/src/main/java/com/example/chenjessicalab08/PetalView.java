package com.example.chenjessicalab08;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PetalView extends View {
    Paint p = new Paint();
    Path face = new Path();
    Path backHair = new Path();

    Bitmap background = BitmapFactory.decodeResource(getResources(),R.drawable.cherrybg);
    Bitmap petalOne = BitmapFactory.decodeResource(getResources(),R.drawable.petal1);
    Bitmap petalTwo = BitmapFactory.decodeResource(getResources(),R.drawable.petal2);
    Bitmap petalThree = BitmapFactory.decodeResource(getResources(),R.drawable.petal3);

    int dX = 10, dY = 50, dD=5, d=0, frameCt = 0;
    List<List<Integer>> listOfLists = new ArrayList<>();
    public PetalView(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setStrokeWidth(12);


        //canvas.drawBitmap(background,null,new Rect(0,0,getWidth(),getHeight()),p);
        frameCt = frameCt%6;

        if (frameCt == 0) {
            //instantiate a bunch in random pos w/ random size and random rot
            // UGH IM LAZY
            for (int i = 0; i < 5; i++) {
                //size, startY, startX, petalType, fallSpeed, fallDirection
                List<Integer> innerList = new ArrayList<>();
                innerList.add((int) (Math.random() * (80 - 30 + 1)) + 30);
                innerList.add((int) (Math.random() * (5 - 50 + 1)));
                innerList.add((int) (Math.random() * (getWidth())));
                innerList.add((int) (Math.random() * (3)));
                innerList.add((int) (Math.random() * (100-40+1))+40);
                innerList.add(((Math.random() < 0.5 ? -1 : 1)) * 5);
                listOfLists.add(innerList);
            }
        }

        for (List<Integer> lst : listOfLists) {
            if (lst.get(3) == 0)
                canvas.drawBitmap(petalOne,null,new Rect(lst.get(2)+lst.get(5),lst.get(1)+lst.get(4),lst.get(2)+lst.get(0)+lst.get(5),lst.get(1)+lst.get(4)+lst.get(0)),p);
            else if (lst.get(3) == 1)
                canvas.drawBitmap(petalTwo,null,new Rect(lst.get(2)+lst.get(5),lst.get(1)+lst.get(4),lst.get(2)+lst.get(0)+lst.get(5),lst.get(1)+lst.get(4)+lst.get(0)),p);
            else
                canvas.drawBitmap(petalThree,null,new Rect(lst.get(2)+lst.get(5),lst.get(1)+lst.get(4),lst.get(2)+lst.get(0)+lst.get(5),lst.get(1)+lst.get(4)+lst.get(0)),p);
        }

        Iterator<List<Integer>> iterator = listOfLists.iterator();
        while (iterator.hasNext()) {
            List<Integer> element = iterator.next();
            if (element.get(1) >= getHeight() || element.get(2) >= getWidth() || element.get(2) <= 0) {
                iterator.remove();
            }
        }

        for (int i = 0; i < listOfLists.size(); i++) {
            listOfLists.set(i,new ArrayList<>(List.of(listOfLists.get(i).get(0),listOfLists.get(i).get(1)+listOfLists.get(i).get(4),listOfLists.get(i).get(2)+listOfLists.get(i).get(5),listOfLists.get(i).get(3),listOfLists.get(i).get(4),listOfLists.get(i).get(5))));
        }

        //canvas.drawPath(face,p);
        //canvas.rotate(d,300,400);
        //p.setColor(Color.BLACK);
        //backHair.addArc(100,600,200,800,0,359);
        //canvas.drawPath(backHair,p);

        //if (d == 120) {
        //    dD = -5;
        //}
        //if (d == -120) {
        //    dD = 5;
        //}
        //d+=dD;
        //d%=360;
        frameCt += 1;
        //canvas.drawCircle(100,500, 130.5f, p);
        //y += dY;
        //y%=getHeight();
        invalidate();
    }
}