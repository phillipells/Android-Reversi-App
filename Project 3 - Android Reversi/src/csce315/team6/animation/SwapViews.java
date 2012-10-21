/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package csce315.team6.animation;

import csce315.team6.reversi.R;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public final class SwapViews implements Runnable {
	private boolean mIsFirstView;
	ImageView image1;
	ImageView image2;
	
	public SwapViews(boolean isFirstView, ImageView image1, ImageView image2) {
		mIsFirstView = isFirstView;
		this.image1 = image1;
		this.image2 = image2;
		//Rotate3dAnimation rotation;
	}
	
	public void run() {
		final float centerX = image1.getWidth() / 2.0f;
		final float centerY = image1.getHeight() / 2.0f;
		final Rotate3dAnimation rotation;
		
		if (mIsFirstView) {
			image1.setImageResource(R.drawable.black);
			image1.setTag("black");
			/*
			image1.setVisibility(View.GONE);
			image2.setVisibility(View.VISIBLE);
			image2.requestFocus();
			*/
			rotation = new Rotate3dAnimation(-90, 0, centerX, centerY, 0, false);
		} else {
			image2.setImageResource(R.drawable.white);
			image2.setTag("white");
			/*
			 image2.setVisibility(View.GONE);
			 image1.setVisibility(View.VISIBLE);
			 image1.requestFocus();
			 */
			 rotation = new Rotate3dAnimation(90, 0, centerX, centerY, 0, false);
		}
		
		rotation.setDuration(150);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new DecelerateInterpolator());
		
		if (mIsFirstView) {
			image1.startAnimation(rotation);
			//image2.startAnimation(rotation);
		} else {
			image2.startAnimation(rotation);
			//image1.startAnimation(rotation);
		}
	}
}