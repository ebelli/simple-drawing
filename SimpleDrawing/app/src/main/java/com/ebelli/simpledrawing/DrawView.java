package com.ebelli.simpledrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ebelli.simpledrawing.core.CoreCanvas;
import com.ebelli.simpledrawing.core.Draw;


public class DrawView extends View {
  private Draw drawSpike = new Draw();

  final Paint paint = new Paint();

  public DrawView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public DrawView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public DrawView(Context context) {
    super(context);
  }

  @Override
  protected void onDraw(final Canvas canvas) {

    paint.setColor(Color.BLUE);
    paint.setStrokeWidth(8);
    drawSpike.drawOn(new CoreCanvas() {
      @Override
      public void drawLine(int x0, int y0, int x1, int y1) {
        canvas.drawLine(x0, y0, x1, y1, paint);
      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    System.out.println(event);
    switch (event.getAction()) {
      case MotionEvent.ACTION_MOVE:
        drawSpike.addPoint(event.getX(), event.getY());
          break;
        case MotionEvent.ACTION_UP:
            drawSpike.addPoint(0, 0);
            break;
    }
    this.invalidate();
    return true;
  }
}
