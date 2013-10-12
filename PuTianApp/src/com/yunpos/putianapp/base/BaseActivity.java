package com.yunpos.putianapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.yunpos.putianapp.R;
import com.yunpos.putianapp.util.AppManager;

public abstract class BaseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
		onCreate();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// ½áÊøActivity&´Ó¶ÑÕ»ÖÐÒÆ³ý
		AppManager.getAppManager().finishActivity(this);
		
	}
	protected abstract void onCreate();
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			this.overridePendingTransition(R.anim.activity_close_enter, R.anim.activity_close_exit);
			
			return true;
		} 
		
		return super.onKeyDown(keyCode, event);
	}
}
