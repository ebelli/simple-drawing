package com.ebelli.simpledrawing.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawTest implements CoreCanvas {
  public static final int RED         = 0xFFFF0000;
  public static final int BLACK       = 0xFF000000;
  public static final int DEFAULT_STROKE = 10;

  Draw Draw = new Draw();
  private String canvasLog = "";

  @Test
  public void empty() throws Exception {
    Draw.drawOn(this);
    assertEquals("", canvasLog);
  }

  @Test
  public void onePoint() throws Exception {
    Draw.addPoint(1.1f, 2.2f);
    Draw.drawOn(this);
    assertEquals("", canvasLog);
  }

  @Test
  public void twoPoints() throws Exception {
    Draw.addPoint(1.1f, 2.2f);
    Draw.addPoint(3.3f, 4.4f);
    Draw.drawOn(this);
    assertEquals("drawLine(1,2,3,4) - color("+ BLACK +") - stroke ("+ DEFAULT_STROKE +")\n", canvasLog);
  }

  @Test
  public void drawLineWithTwoPointsAndRedColor() throws Exception {
    Draw.addPoint(1.1f, 2.2f,RED,8);
    Draw.addPoint(3.3f, 4.4f);
    Draw.drawOn(this);
    assertEquals("drawLine(1,2,3,4) - color("+ RED +") - stroke ("+ 8 +")\n", canvasLog);
  }

  @Test
  public void drawLineWithTwoPointsAndRedColorAndStrokeSix() throws Exception {
    Draw.addPoint(1.1f, 2.2f,RED,6);
    Draw.addPoint(3.3f, 4.4f);
    Draw.drawOn(this);
    assertEquals("drawLine(1,2,3,4) - color("+ RED +") - stroke ("+ 6 +")\n", canvasLog);
  }
  @Test
  public void drawLineWithThreePoints() throws Exception {
    Draw.addPoint(1.1f, 2.2f);
    Draw.addPoint(3.3f, 4.4f);
    Draw.addPoint(5.5f, 6.6f);
    Draw.drawOn(this);
    assertEquals("drawLine(1,2,3,4) - color("+ BLACK +") - stroke ("+ DEFAULT_STROKE +")\ndrawLine(3,4,5,6) - color("+ BLACK +") - stroke ("+ DEFAULT_STROKE +")\n", canvasLog);
  }

  @Override
  public void drawLine(int x0, int y0, int x1, int y1, int color, float stroke) {
    this.canvasLog += String.format("drawLine(%d,%d,%d,%d) - color(%d) - stroke (%d)\n", x0, y0, x1, y1, color, (int)stroke);
  }
}
