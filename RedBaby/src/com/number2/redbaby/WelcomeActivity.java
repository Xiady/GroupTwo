package com.number2.redbaby;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {

	private ImageView image_welcome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_welcome);

		// 找控件
		image_welcome = (ImageView) findViewById(R.id.welcome_image);

		// 设置动画的效果
		@SuppressWarnings("static-access")
		Animation animation = new AnimationUtils().loadAnimation(this,
				R.anim.alpha);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			// 动画结束
			@Override
			public void onAnimationEnd(Animation animation) {
				// 跳转界面
				startActivity(new Intent(WelcomeActivity.this,
						HomeActivity.class));
				finish();
			}
		});
		// 播放动画
		image_welcome.setAnimation(animation);

	}

}
