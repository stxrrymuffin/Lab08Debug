package com.example.chenjessicalab08;

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
public class DrawView extends View {
    Paint p = new Paint();
    Path face = new Path();
    Path backHair = new Path();

    Bitmap layerOne = BitmapFactory.decodeResource(getResources(),R.drawable.layer1);
    Bitmap layerTwo = BitmapFactory.decodeResource(getResources(),R.drawable.layer2);
    Bitmap layerThree = BitmapFactory.decodeResource(getResources(),R.drawable.layer3);
    Bitmap layerFour = BitmapFactory.decodeResource(getResources(),R.drawable.layer4);
    Bitmap layerFive = BitmapFactory.decodeResource(getResources(),R.drawable.layer5);
    Bitmap layerSix = BitmapFactory.decodeResource(getResources(),R.drawable.layer6);
    Bitmap layerSeven = BitmapFactory.decodeResource(getResources(),R.drawable.layer7);
    Bitmap layerEight = BitmapFactory.decodeResource(getResources(),R.drawable.layer8);
    Bitmap layerNine = BitmapFactory.decodeResource(getResources(),R.drawable.layer9);
    Bitmap layerTen = BitmapFactory.decodeResource(getResources(),R.drawable.layer10);
    Bitmap layerEleven = BitmapFactory.decodeResource(getResources(),R.drawable.layer11);
    Bitmap layerTwelve = BitmapFactory.decodeResource(getResources(),R.drawable.layer12);
    Bitmap layerThirteen = BitmapFactory.decodeResource(getResources(),R.drawable.layer13);
    Bitmap layerFourteen = BitmapFactory.decodeResource(getResources(),R.drawable.layer14);
    Bitmap layerFifteen = BitmapFactory.decodeResource(getResources(),R.drawable.layer15);
    Bitmap layerSixteen = BitmapFactory.decodeResource(getResources(),R.drawable.layer16);
    Bitmap layerSeventeen = BitmapFactory.decodeResource(getResources(),R.drawable.layer17);
    Bitmap layerEighteen = BitmapFactory.decodeResource(getResources(),R.drawable.layer18);
    Bitmap layerNineteen = BitmapFactory.decodeResource(getResources(),R.drawable.layer19);
    Bitmap layerTwenty = BitmapFactory.decodeResource(getResources(),R.drawable.layer20);
    Rect imageRect = new Rect(200,700,936,1436);
    int y = 0, dY = 5, dD=5, d=0, frameCt = 0, parody=1;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        p.setStrokeWidth(12);

        p.setColor(Color.argb(255,251,242,232));
       /* face.addOval(350,1010,450,1120, Path.Direction.CW);
        face.arcTo(400,840,750,1110,-40,359,true);
        face.arcTo(420,1000,680,1110,100,359,true);
        face.addOval(700,950,830,1060, Path.Direction.CW);
        face.close();*/
        //ok i tried but it took too long and its too ugly so im importing everything haha

        frameCt = frameCt%6;
        //this just says like pick whether u want
        //the animation to move cw or ccw
        if (frameCt == 0) {
            if (parody == 1)
                parody = -1;
            else
                parody = 1;
        }

        //THREE LINES ROT
        if (frameCt < 3) {
            canvas.rotate(-15,558+200,443+700);
            System.out.println(frameCt);
        }
        else {
            canvas.rotate(15,558+200,443+700);
            System.out.println(frameCt);
        }
        //THREE LINES LAYER
        canvas.drawBitmap(layerOne,null,imageRect,p);
        //SHIFT CANVAS BACK + FLOWER ROT
        if (frameCt < 3) {
            canvas.rotate(15,558+200,443+700);
            canvas.rotate(30,129+200,496+700);
        }
        else {
            canvas.rotate(-15,558+200,443+700);
            canvas.rotate(-30,129+200,496+700);
        }
        //FLOWER 1 LAYER
        canvas.drawBitmap(layerTwo,null,imageRect,p);
        //SHIFT CANVAS BACK + FLOWER 2 ROT
        if (frameCt < 3) {
            canvas.rotate(-30,129+200,496+700);
            canvas.rotate(30,176+200,549+700);
        }
        else {
            canvas.rotate(30,129+200,496+700);
            canvas.rotate(-30,176+200,549+700);
        }
        //FLOWER 2 LAYER
        canvas.drawBitmap(layerThree,null,imageRect,p);
        //SHIFT CANVAS BACK
        if (frameCt < 3) {
            canvas.rotate(-30,176+200,549+700);
        }
        else {
            canvas.rotate(30,176+200,549+700);
        }

        //CAPE LAYER
        canvas.drawBitmap(layerFour,null,imageRect,p);
        //MAIN BODY BACK LAYER
        canvas.drawBitmap(layerFive,null,imageRect,p);

        //MAIN HEAD LAYER + ROT
        canvas.rotate((float) (-0.5*frameCt*parody),408+200,461+700);
        canvas.drawBitmap(layerSix,null,imageRect,p);
        canvas.rotate((float) (0.5*frameCt*parody),408+200,461+700);

        //RIGHT ARM ROT
        canvas.rotate(frameCt*parody,445+200,482+700);
        canvas.drawBitmap(layerSeven,null,imageRect,p);
        canvas.rotate(-frameCt*parody,445+200,482+700);

        //MAIN BODY FRONT LAYER
        canvas.drawBitmap(layerEight,null,imageRect,p);

        //LEFT ARM SECTION ROT
        canvas.rotate(-2*frameCt*parody,320+200,509+700);
        canvas.drawBitmap(layerNine,null,imageRect,p);
        //LEFT ARM SLEEVE ROT
        canvas.rotate(-4*(frameCt-3)*parody,320+200,509+700);
        canvas.drawBitmap(layerTen,null,imageRect,p);
        canvas.rotate(4*(frameCt-3)*parody,320+200,509+700);
        canvas.rotate(2*frameCt*parody,320+200,509+700);

        //MAIN HEAD ROT (for hair, hat, braids)
        canvas.rotate((float) (-0.5*frameCt*parody),408+200,461+700);
        //LEFT BRAID ROT
        canvas.rotate(-2*(frameCt-4)*parody,272+200,371+700);
        canvas.drawBitmap(layerEleven,null,imageRect,p);
        canvas.rotate(2*(frameCt-4)*parody,272+200,371+700);

        //HAIR FRONT DETAILS
        canvas.drawBitmap(layerTwelve,null,imageRect,p);
        canvas.drawBitmap(layerThirteen,null,imageRect,p);

        //RIGHT BRAID ROT
        canvas.rotate(-2*(frameCt)*parody,510+200,332+700);
        canvas.drawBitmap(layerFourteen,null,imageRect,p);
        canvas.rotate(2*(frameCt)*parody,510+200,332+700);

        //FRONT BANG ROT
        canvas.rotate(-2*(frameCt-2)*parody,384+200,256+700);
        canvas.drawBitmap(layerFifteen,null,imageRect,p);
        canvas.rotate(2*(frameCt-2)*parody,384+200,256+700);

        //HAT BOW RIGHT ROT
        canvas.rotate(-5*(frameCt-2)*parody,192+200,293+700);
        canvas.drawBitmap(layerSixteen,null,imageRect,p);
        canvas.rotate(5*(frameCt-2)*parody,192+200,293+700);

        //MAIN HAT
        canvas.drawBitmap(layerSeventeen,null,imageRect,p);

        //HAT BOW LEFT ROT
        canvas.rotate(-5*(frameCt-3)*parody,192+200,293+700);
        canvas.drawBitmap(layerEighteen,null,imageRect,p);
        canvas.rotate(5*(frameCt-3)*parody,192+200,293+700);

        //HAT BOW RECTANGLE THING
        canvas.rotate(-5*(frameCt-4)*parody,202+200,290+700);
        canvas.drawBitmap(layerNineteen,null,imageRect,p);
        canvas.rotate(5*(frameCt-4)*parody,202+200,290+700);

        //HAT BOW LOOP
        canvas.drawBitmap(layerTwenty,null,imageRect,p);
        //rotate canvas back
        canvas.rotate((float) (0.5*frameCt*parody),408+200,461+700);

        //canvas.drawPath(face,p);
        //canvas.rotate(d,300,400);
        //p.setColor(Color.BLACK);
        //backHair.addArc(100,600,200,800,0,359);
        //canvas.drawPath(backHair,p);

        frameCt += 1;
        //canvas.drawCircle(100,500, 130.5f, p);
        //y += dY;
        //y%=getHeight();


       invalidate();
    }
}
