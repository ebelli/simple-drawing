package com.ebelli.simpledrawing.core;

public class CorePoint {
  public int x;
  public int y;

  public CorePoint(float x, float y) {
    this.x = (int) x;
    this.y = (int) y;
  }

  @Override
  public String toString() {
    return String.format("(%d,%d)", x, y);
  }
}
