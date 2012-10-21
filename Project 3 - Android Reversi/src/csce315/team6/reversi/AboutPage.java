package csce315.team6.reversi;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;
import android.os.Bundle;

public class AboutPage extends Activity implements OnGestureListener {
	private GestureDetector elSwipe;
	private ViewFlipper switchy;
	private static final int SWIPE_MIN_VEL = 100;
	private static final int SWIPE_MIN_DIST = 100;
	@Override
	public void onCreate(Bundle gameChoice) {
        super.onCreate(gameChoice);
        setContentView(R.layout.aboutpage);
        switchy = (ViewFlipper) findViewById(R.id.viewFlipper);
        elSwipe = new GestureDetector(this, this);
    }
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return elSwipe.onTouchEvent(event);
	}
	
	public boolean onDown(MotionEvent e) {
		return false;
	}
	
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		float ev1X = e1.getX();
		float ev2X = e2.getX();
		final float xdistance = Math.abs(ev1X - ev2X);
		final float xvelocity = Math.abs(velocityX);
		if( (xvelocity > SWIPE_MIN_VEL) && (xdistance > SWIPE_MIN_DIST)) {
			if(ev1X > ev2X) {
				previousView();
			}
			else {
				nextView();
			}
		}
		return false;
	}
	
	public void onLongPress(MotionEvent e) {
	}
	
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		return false;
	}
	
	public void onShowPress(MotionEvent e) {
	}
	
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}
	
	private void previousView() {
		switchy.setInAnimation(this, R.anim.in_anim1);
		switchy.setOutAnimation(this, R.anim.out_anim1);
		switchy.showPrevious();
	}
	
	private void nextView() {
		switchy.setInAnimation(this, R.anim.in_anim);
		switchy.setOutAnimation(this, R.anim.out_anim);
		switchy.showNext();
	}

}