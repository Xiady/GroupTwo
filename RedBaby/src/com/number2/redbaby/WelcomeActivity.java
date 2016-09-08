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

		// �ҿؼ�
		image_welcome = (ImageView) findViewById(R.id.welcome_image);

		// ���ö�����Ч��
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

			// ��������
			@Override
			public void onAnimationEnd(Animation animation) {
				// ��ת����
				startActivity(new Intent(WelcomeActivity.this,
						HomeActivity.class));
				finish();
			}
		});
		// ���Ŷ���
		image_welcome.setAnimation(animation);

	}

}
