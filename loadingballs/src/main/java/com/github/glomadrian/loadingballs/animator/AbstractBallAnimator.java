package com.github.glomadrian.loadingballs.animator;

import com.github.glomadrian.loadingballs.Ball;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrián García Lomas
 */
public abstract class AbstractBallAnimator {

  protected List<Ball> balls;
  protected BallAnimatorListener ballAnimatorListener;

  public AbstractBallAnimator() {
    balls = new ArrayList<>();
  }

  public void addBall(Ball ball) {
    balls.add(ball);
  }

  public void addBalls(List<Ball> balls) {
    this.balls.addAll(balls);
  }

  public void setBallPathAnimatorListener(BallAnimatorListener ballAnimatorListener) {
    this.ballAnimatorListener = ballAnimatorListener;
  }

  public abstract void start();

  public abstract void stop();

  public abstract void restart();

  public interface BallAnimatorListener {

    void onUpdate();
  }
}
