package com.yunpos.putianapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.yunpos.putianapp.R;

public class UIHelperUtil {

	/**
	 * 隐藏输入键盘
	 * 
	 * @param v
	 */
	public static void hideSoftInput(View v) {
		InputMethodManager imm = (InputMethodManager) v.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm.isActive()) {
			imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
		}
	}

	/**
	 * 启动新activity
	 * 
	 * @param activity
	 * @param intent
	 */
	public static void startActivity(final Activity activity, Intent intent) {
		activity.startActivity(intent);
		activity.overridePendingTransition(R.anim.activity_open_enter,
				R.anim.activity_open_exit);
	}

	/**
	 * 关闭当前activity
	 * 
	 * @param activity
	 */
	public static void finishActivity(final Activity activity) {
		activity.finish();
		activity.overridePendingTransition(R.anim.activity_close_enter,
				R.anim.activity_close_exit);
	}

	/**
	 * 启动新的activity并关闭当前activity
	 * 
	 * @param activity
	 * @param intent
	 */
	public static void startAndFinishActivity(final Activity activity,
			Intent intent) {
		activity.startActivity(intent);
		activity.finish();
		activity.overridePendingTransition(R.anim.activity_open_enter,
				R.anim.activity_open_exit);
	}

	/**
	 * listview、scrollView共存
	 * 
	 * @param listView
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

}
