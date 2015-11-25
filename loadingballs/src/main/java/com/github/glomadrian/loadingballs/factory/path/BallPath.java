package com.github.glomadrian.loadingballs.factory.path;

import android.graphics.Path;
import android.graphics.Point;

/**
 * @author Adrián García Lomas
 */
public abstract class BallPath {

  protected Point center;
  protected int pathWidth;
  protected int pathHeight;
  protected int maxBallSize;

  public BallPath(Point center, int pathWidth, int pathHeight, int maxBallSize) {
    this.center = center;
    this.pathWidth = pathWidth;
    this.pathHeight = pathHeight;
    this.maxBallSize = maxBallSize;
  }

  public abstract Path draw();

  protected void initializePoints(Point[] points) {
    for (int i = 0; i < points.length; i++) {
      points[i] = new Point();
    }
  }
}
