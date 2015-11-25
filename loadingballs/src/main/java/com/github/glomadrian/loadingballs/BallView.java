package com.github.glomadrian.loadingballs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.github.glomadrian.loadingballs.animator.AbstractBallAnimator;
import com.github.glomadrian.loadingballs.animator.BallPathAnimator;
import com.github.glomadrian.loadingballs.animator.BallSizeAnimator;
import com.github.glomadrian.loadingballs.factory.PathFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrián García Lomas
 */
public class BallView extends View {

  private List<Ball> balls;
  private float minBallSize;
  private float maxBallSize;
  private float ballSize = 20;
  private BallPathAnimator ballPathAnimator;
  private BallSizeAnimator ballSizeAnimator;
  private int numberOfBalls = 3;
  private int ballSizeAnimationDuration = 400;
  private int ballPathAnimationDuration = 1500;
  private boolean sizeAnimationEnabled = false;
  private int[] ballColors;
  private String pathType;

  public BallView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public BallView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    defaultBallColors();
    initAttributes(attrs);
    createBalls();
  }

  private void defaultBallColors() {
    ballColors = new int[] { -9956, -46262, -12742913 };
  }

  private void initAttributes(AttributeSet attrs) {
    TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.LoadingBalls);
    numberOfBalls = attributes.getInt(R.styleable.LoadingBalls_balls, numberOfBalls);
    ballSize = attributes.getDimension(R.styleable.LoadingBalls_ball_size, ballSize);
    minBallSize = attributes.getDimension(R.styleable.LoadingBalls_min_ball_size, ballSize / 2);
    maxBallSize = attributes.getDimension(R.styleable.LoadingBalls_max_ball_size, ballSize * 2);
    ballSizeAnimationDuration =
        attributes.getInt(R.styleable.LoadingBalls_size_cycle_time, ballSizeAnimationDuration);
    ballPathAnimationDuration =
        attributes.getInt(R.styleable.LoadingBalls_movement_cycle_time, ballPathAnimationDuration);
    sizeAnimationEnabled =
        attributes.getBoolean(R.styleable.LoadingBalls_enable_size_animation, false);
    initColorsAttributes(attributes);
    pathType = attributes.getString(R.styleable.LoadingBalls_path);
    if (pathType == null) {
      pathType = PathFactory.INFINITE;
    }
  }

  private void initColorsAttributes(TypedArray attributes) {
    int arrayResourceId = attributes.getResourceId(R.styleable.LoadingBalls_ball_colors, 0);
    if (arrayResourceId != 0) {
      ballColors = getResources().getIntArray(arrayResourceId);
    }
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    Path path = PathFactory.makePath(pathType, new Point(w / 2, h / 2), w, h, (int) maxBallSize);
    initBallPathAnimator(path);
    if (sizeAnimationEnabled) {
      initBallSizeAnimator(path);
    }
    start();
  }

  private void initBallPathAnimator(Path path) {
    ballPathAnimator = new BallPathAnimator(path, ballPathAnimationDuration);
    ballPathAnimator.setBallPathAnimatorListener(new AnimatorListener());
    ballPathAnimator.addBalls(balls);
  }

  private void initBallSizeAnimator(Path path) {
    ballSizeAnimator =
        new BallSizeAnimator(path, ballSizeAnimationDuration, minBallSize, maxBallSize);
    ballSizeAnimator.addBalls(balls);
  }

  private void createBalls() {
    balls = new ArrayList<>();
    for (int i = 0, k = 0; i < numberOfBalls; i++, k++) {
      if (!(ballColors.length - 1 >= k)) {
        k = 0;
      }
      balls.add(new Ball(ballSize, ballColors[k]));
    }
  }

  public void start() {
    ballPathAnimator.start();
    if (sizeAnimationEnabled) {
      ballSizeAnimator.start();
    }
  }

  public void stop() {
    ballPathAnimator.stop();
    if (sizeAnimationEnabled) {
      ballSizeAnimator.start();
    }
  }

  public void restart() {
    ballPathAnimator.restart();
    if (sizeAnimationEnabled) {
      ballSizeAnimator.restart();
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    for (Ball ball : balls) {
      ball.render(canvas);
    }
  }

  private class AnimatorListener implements AbstractBallAnimator.BallAnimatorListener {

    @Override
    public void onUpdate() {
      invalidate();
    }
  }
}
