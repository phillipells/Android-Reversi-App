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

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

public final class DisplayNextView implements Animation.AnimationListener {
	private boolean mCurrentView;
	ImageView image1;
	ImageView image2;
	
	public DisplayNextView(boolean currentView, ImageView image1, ImageView image2) {
		mCurrentView = currentView;
		this.image1 = image1;
		this.image2 = image2;
	}
	
	public void onAnimationStart(Animation animation) {
	}
	
	public void onAnimationEnd(Animation animation) {
		image1.post(new SwapViews(mCurrentView, image1, image2));
	}
	
	public void onAnimationRepeat(Animation animation) {
	}
}