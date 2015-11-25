package com.github.glomadrian.loadingballs.factory.path;

import android.graphics.Path;
import android.graphics.Point;

/**
 * @author Adrián García Lomas
 */
public class Star extends BallPath {

  public Star(Point center, int pathWidth, int pathHeight, int maxBallSize) {
    super(center, pathWidth, pathHeight, maxBallSize);
  }

  @Override
  public Path draw() {
    int squareWidth = pathHeight / 4;
    int middleSquare = squareWidth / 2;

    Point[] squarePoints = new Point[4];
    initializePoints(squarePoints);
    squarePoints[0].set(center.x - middleSquare, center.y - middleSquare);
    squarePoints[1].set(center.x + middleSquare, squarePoints[0].y);
    squarePoints[2].set(squarePoints[1].x, center.y + middleSquare);
    squarePoints[3].set(squarePoints[0].x, squarePoints[2].y);

    Point[] starPoints = new Point[4];
    initializePoints(starPoints);
    starPoints[0].set(maxBallSize, center.y);
    starPoints[1].set(center.x, maxBallSize);
    starPoints[2].set(pathWidth - maxBallSize, center.y);
    starPoints[3].set(center.x, pathHeight - maxBallSize);

    Path starPath = new Path();

    starPath.moveTo(starPoints[0].x, starPoints[0].y);
    starPath.lineTo(squarePoints[0].x, squarePoints[0].y);

    for (int i = 1; i < 4; i++) {
      starPath.lineTo(starPoints[i].x, starPoints[i].y);
      starPath.lineTo(squarePoints[i].x, squarePoints[i].y);
    }

    starPath.close();

    return starPath;
  }
}
