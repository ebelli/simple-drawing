package com.ebelli.simpledrawing.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Draw {
  private List<CorePoint> points = new ArrayList<>();

  public Collection<CorePoint> getSegments() {
    return points;
  }

  public void addPoint(float x, float y) {
    points.add(new CorePoint(x, y));
  }

  public void drawOn(CoreCanvas coreCanvas) {
      for(int i = 1; i < points.size(); i++) {
        CorePoint p0 = points.get(i-1);
        CorePoint p1 = points.get(i);
        coreCanvas.drawLine(p0.x, p0.y, p1.x, p1.y);
      }
  }
}
