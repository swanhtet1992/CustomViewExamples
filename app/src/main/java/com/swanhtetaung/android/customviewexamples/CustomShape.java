package com.swanhtetaung.android.customviewexamples;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author SH (swanhtet@nexlabs.co)
 */
public class CustomShape extends View {

  private float mDim;
  private int mShape, mColor;
  private Paint mPaint;

  final int CIRCLE = 0;
  final int RECTANGLE = 1;

  public CustomShape(Context context, AttributeSet attrs) {
    super(context, attrs);

    TypedArray attributes = null;

    try {
      mPaint = new Paint();
      attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomShape);

      mDim = attributes.getDimension(R.styleable.CustomShape_dimen, 20f);
      mShape = attributes.getInteger(R.styleable.CustomShape_shape, 0);
      mColor = attributes.getInteger(R.styleable.CustomShape_custom_color, 0);
    } finally {
      if (attributes != null) {
        attributes.recycle();
      }
    }
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    mPaint.setStyle(Style.FILL);
    mPaint.setAntiAlias(true);
    mPaint.setColor(mColor);

    switch (mShape) {
      case CIRCLE:
        canvas.drawCircle(mDim, mDim, mDim, mPaint);
        break;
      case RECTANGLE:
        canvas.drawRect(0, 0, mDim, mDim, mPaint);
        break;
    }
  }
}
