package com.github.glomadrian.loadingballssample.animator;

import android.animation.ValueAnimator;
import android.graphics.Path;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.github.glomadrian.loadingballssample.Ball;

/**
 * @author Adrián García Lomas
 */
public class BallSizeAnimator extends AbstractBallAnimator {

  private int duration;
  private float offset;
  private Path path;
  private float minBallSize;
  private float maxBallSize;

  public BallSizeAnimator(Path path, int duration, float minBallSize, float maxBallSize) {
    this.duration = duration;
    this.path = path;
    this.minBallSize = minBallSize;
    this.maxBallSize = maxBallSize;
  }

  public void start() {
    for (int i = 0; i < balls.size(); i++) {
      createBallAnimatorAndStart(balls.get(i), 300 * i);
    }
  }

  private void createBallAnimatorAndStart(Ball ball, int startDelay) {
    ValueAnimator valueAnimator = new ValueAnimator();
    valueAnimator.setFloatValues(minBallSize, maxBallSize);
    valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    valueAnimator.setDuration(duration);
    valueAnimator.addUpdateListener(new BallUpdateListener(ball));
    valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
    valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
    valueAnimator.setStartDelay(startDelay);
    valueAnimator.start();
  }

  private class BallUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    private Ball ball;

    public BallUpdateListener(Ball ball) {
      this.ball = ball;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
      float value = (float) animation.getAnimatedValue();
      ball.setSize((int) value);
    }
  }
}
