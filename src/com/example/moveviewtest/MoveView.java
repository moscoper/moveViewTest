package com.example.moveviewtest;

import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MoveView extends ImageView {

	GestureDetector gd;
	private float startDistance;
	private int TYPE = 0;

	public void setCanMove() {
		this.setClickable(true);
		gd = new GestureDetector(this.getContext(), new OnGestureListener() {

			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2,
					float distanceX, float distanceY) {
				// TODO Auto-generated method stub
				View view = MoveView.this;
				if (TYPE == 0) {
					view.setX(view.getX() + (e2.getX() - e1.getX())
							* view.getScaleX());
					view.setY(view.getY() + (e2.getY() - e1.getY())
							* view.getScaleY());
					return true;
				}
				return false;

			}

			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2,
					float velocityX, float velocityY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		gd.onTouchEvent(event);
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:

			break;
		case MotionEvent.ACTION_UP:

			break;
		case MotionEvent.ACTION_POINTER_UP:
			TYPE = 0;
			break;
		case MotionEvent.ACTION_MOVE:
			if (TYPE == 1) {
				float dis = getDistance(event);
				if (dis > 10f) {
					View view = MoveView.this;
					float s = dis / startDistance;
					view.setScaleX(view.getScaleX() * s);
					view.setScaleY(view.getScaleY() * s);
				}
			}

			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			startDistance = getDistance(event);
			if (startDistance > 10f) {
				TYPE = 1;
			}
			break;

		default:
			break;
		}
		return super.onTouchEvent(event);
	}

	public float getDistance(MotionEvent event) {
		float xdis = event.getX(1) - event.getX(0);
		float ydis = event.getY(1) - event.getY(0);

		return (float) Math.sqrt(xdis * xdis + ydis * ydis);
	}

	public MoveView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

	}

}
