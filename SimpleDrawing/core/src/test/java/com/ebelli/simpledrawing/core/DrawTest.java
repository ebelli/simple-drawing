package com.ebelli.simpledrawing.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawTest implements CoreCanvas {
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
    assertEquals("drawLine(1,2,3,4)\n", canvasLog);
  }

  @Test
  public void drawLineWithThreePoints() throws Exception {
    Draw.addPoint(1.1f, 2.2f);
    Draw.addPoint(3.3f, 4.4f);
    Draw.addPoint(5.5f, 6.6f);
    Draw.drawOn(this);
    assertEquals("drawLine(1,2,3,4)\ndrawLine(3,4,5,6)\n", canvasLog);
  }

  @Override
  public void drawLine(int x0, int y0, int x1, int y1) {
    this.canvasLog += String.format("drawLine(%d,%d,%d,%d)\n", x0, y0, x1, y1);
  }
}
