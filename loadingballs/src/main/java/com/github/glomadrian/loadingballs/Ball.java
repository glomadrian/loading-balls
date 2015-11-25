package com.github.glomadrian.loadingballs;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * @author Adrián García Lomas
 */
public class Ball {

  private Paint paint;
  private float size;
  private Point position;
  private int color;

  public Ball(int size) {
    this.size = size;
    init();
  }

  public Ball(float size, int color) {
    this.color = color;
    this.size = size;
    init();
  }

  private void init() {
    initPaint();
    initPoint();
  }

  private void initPaint() {
    paint = new Paint();
    paint.setColor(color);
    paint.setAntiAlias(true);
  }

  private void initPoint() {
    position = new Point();
  }

  public Paint getPaint() {
    return paint;
  }

  public void setPaint(Paint paint) {
    this.paint = paint;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition(int x, int y) {
    this.position.set(x, y);
  }

  public void render(Canvas canvas) {
    canvas.drawCircle(position.x, position.y, size, paint);
  }
}
