package com.itair.verymaid;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.itair.verymaid.fra.Home1Fra;
import com.itair.verymaid.fra.Home2Fra;
import com.itair.verymaid.fra.Home3Fra;
import com.itair.verymaid.fra.Home4Fra;
/**
 * Fragment 的切换类
 */
public class MainActivity extends FragmentActivity implements OnClickListener {

	private Button mBt1, mBt2, mBt3, mBt4;	//四个TAB按钮
	private FragmentManager mFM = null;		//
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		init();

		change(new Home1Fra());
		setSelected(mBt1);
	}

	private void init() {
		mBt1 = (Button) findViewById(R.id.tab_bt_1);
		mBt2 = (Button) findViewById(R.id.tab_bt_2);
		mBt3 = (Button) findViewById(R.id.tab_bt_3);
		mBt4 = (Button) findViewById(R.id.tab_bt_4);

		mBt1.setOnClickListener(this);
		mBt2.setOnClickListener(this);
		mBt3.setOnClickListener(this);
		mBt4.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tab_bt_1:
			
			change(new Home1Fra());
			setSelected(mBt1);
			break;
		case R.id.tab_bt_2:

			change(new Home2Fra());
			setSelected(mBt2);
			break;
		case R.id.tab_bt_3:

			change(new Home3Fra());
			setSelected(mBt3);
			break;
		case R.id.tab_bt_4:

			change(new Home4Fra());
			setSelected(mBt4);
			break;
		default:
			break;
		}
	}
	
	private void setSelected(Button btn){
		mBt1.setSelected(false);
		mBt2.setSelected(false);
		mBt3.setSelected(false);
		mBt4.setSelected(false);
		
		btn.setSelected(true);
	}

	/**
	 * 切换fragement
	 */
	private void change(Fragment fragment) {
		if (null == mFM)
			mFM = getSupportFragmentManager();
		FragmentTransaction ft = mFM.beginTransaction();
		ft.replace(R.id.content_container, fragment);
		ft.commitAllowingStateLoss();
	}
	
	private static Boolean isQuit = false;
	private Timer timer = new Timer();

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isQuit == false) {
				isQuit = true;
				Toast.makeText(getBaseContext(), "再次点击确定退出软件",
						Toast.LENGTH_SHORT).show();
				TimerTask task = null;
				task = new TimerTask() {
					@Override
					public void run() {
						isQuit = false;
					}
				};
				timer.schedule(task, 2000);
			} else {
				finish();
			}
		}
		return false;
	}

}
