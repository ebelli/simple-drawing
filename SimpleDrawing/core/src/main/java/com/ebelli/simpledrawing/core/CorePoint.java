package com.ebelli.simpledrawing.core;

public class CorePoint {

  public static final int BLACK       = 0xFF000000;
    public static final float STROKE = 10;

  public int x;
  public int y;
  public int color;
  public float stroke;

    public CorePoint(float x, float y) {
        this.x = (int) x;
        this.y = (int) y;
        this.color = BLACK;
        this.stroke = STROKE;
    }

  public CorePoint(float x, float y, int color, float stroke) {
    this.x = (int) x;
    this.y = (int) y;
    this.color = color;
    this.stroke = stroke;
  }

  @Override
  public String toString() {
    return String.format("(%d,%d)", x, y);
  }
}
