package com.ebelli.simpledrawing.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Draw {
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
          for (List<CorePoint> line : mLines){
              for (int i = 1; i < line.size(); i++) {
                  CorePoint p0 = line.get(i - 1);
                  CorePoint p1 = line.get(i);
                  coreCanvas.drawLine(p0.x, p0.y, p1.x, p1.y, p0.color, p0.stroke);
              }
          }
      }
  }

    public void addPoint(float x, float y, int color, float stroke) {
        if (mLines.size()<mLineCount){
            ArrayList<CorePoint> line = new ArrayList<CorePoint>();
            line.add(new CorePoint(x, y,color,stroke));
            mLines.add(line);
        }else {
            mLines.get(mLineCount-1).add(new CorePoint(x, y,color,stroke));
        }
    }

    public void clear(){
        mLines.clear();
        mLineCount=1;
    }
}
