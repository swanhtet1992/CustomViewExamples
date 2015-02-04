package com.swanhtetaung.android.customviewexamples;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author SH (swanhtet@nexlabs.co)
 */
public class CircleTextView extends View {

  private int mCircleColor, mTextColor;
  private int mTextSize;
  private String mText;

  private Paint mPaint;

  public CircleTextView(Context context, AttributeSet attrs) {
    super(context, attrs);

    TypedArray attributes = null;

    try {
      mPaint = new Paint();
      attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView);

      mCircleColor = attributes.getColor(R.styleable.CircleTextView_circle_color, 0);
      mTextColor = attributes.getColor(R.styleable.CircleTextView_label_color, 0);
      mText = attributes.getString(R.styleable.CircleTextView_label);
      mTextSize = attributes.getInteger(R.styleable.CircleTextView_label_size, 18);
    } finally {
      if (attributes != null) {
        attributes.recycle();
      }
    }
  }

  @Override protected void onDraw(Canvas canvas) {
    final int viewWidthHalf = getMeasuredWidth() / 2;
    final int viewHeightHalf = getMeasuredHeight() / 2;
    int radius = 0;

    if (viewWidthHalf > viewHeightHalf) {
      radius = viewHeightHalf - 10;
    } else {
      radius = viewWidthHalf - 10;
    }

    mPaint.setStyle(Style.FILL);
    mPaint.setAntiAlias(true);
    mPaint.setColor(mCircleColor);

    canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, mPaint);

    mPaint.setColor(mTextColor);
    mPaint.setTextAlign(Align.CENTER);
    mPaint.setTextSize(mTextSize);

    canvas.drawText(mText, viewWidthHalf, viewHeightHalf, mPaint);
  }

  public int getCircleColor() {
    return mCircleColor;
  }

  public int getTextColor() {
    return mTextColor;
  }

  public String getText() {
    return mText;
  }

  public void setCircleColor(int color) {
    this.mCircleColor = color;
  }

  public void setTextColor(int color) {
    this.mTextColor = color;
  }

  public void setText(String text) {
    this.mText = text;
  }
}
