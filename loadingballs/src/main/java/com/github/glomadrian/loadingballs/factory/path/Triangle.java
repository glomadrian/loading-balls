package com.github.glomadrian.loadingballs.factory.path;

import android.graphics.Path;
import android.graphics.Point;

/**
 * @author Adrián García Lomas
 */
public class Triangle extends BallPath {

  public Triangle(Point center, int pathWidth, int pathHeight, int maxBallSize) {
    super(center, pathWidth, pathHeight, maxBallSize);
  }

  @Override
  public Path draw() {
    Path path = new Path();
    path.moveTo(maxBallSize, pathHeight - maxBallSize);
    path.lineTo(center.x, maxBallSize);
    path.lineTo(pathWidth - maxBallSize, pathHeight - maxBallSize);
    path.lineTo(maxBallSize, pathHeight - maxBallSize);
    return path;
  }
}
