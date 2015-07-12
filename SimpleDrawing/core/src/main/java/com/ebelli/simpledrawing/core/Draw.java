package com.ebelli.simpledrawing.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Draw {
//  private List<CorePoint> points = new ArrayList<>();
  private List<List<CorePoint>> mLines = new ArrayList<>();
  private int mLineCount;

    public Draw() {
        mLineCount=1;
    }

    public Collection<CorePoint> getSegments() {
    return mLines.get(mLineCount);
  }

    public int addLine(){
        mLineCount++;
        return mLineCount;
    }

  public void addPoint(float x, float y) {
      if (mLines.size()<mLineCount){
          ArrayList<CorePoint> line = new ArrayList<CorePoint>();
          line.add(new CorePoint(x, y));
          mLines.add(line);
      }else {
          mLines.get(mLineCount-1).add(new CorePoint(x, y));
      }
  }

  public void drawOn(CoreCanvas coreCanvas) {
      if (mLines.size()>0) {
          for (int i = 1; i < mLines.get(mLineCount - 1).size(); i++) {
              CorePoint p0 = mLines.get(mLineCount - 1).get(i - 1);
              CorePoint p1 = mLines.get(mLineCount - 1).get(i);
              coreCanvas.drawLine(p0.x, p0.y, p1.x, p1.y);
          }
      }
  }
}
