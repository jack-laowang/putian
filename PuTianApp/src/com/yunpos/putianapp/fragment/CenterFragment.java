package com.yunpos.putianapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.yunpos.putianapp.R;

public class CenterFragment extends Fragment implements OnClickListener {

	// 按钮
	RadioButton mFrag_dail, mFrag_records, mFrag_text, mFrag_contact,
			mFrag_favourites;
	// 页面
	Fragment mDiscount, mShoppingFragment, mPutianFragment, mDiscoveryFragmentt, mContent;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View center = inflater.inflate(R.layout.center_fragment, null);

		initView(center);
		initLsnr(center);
		
		// 初始化各个fragment
		mDiscount = new DiscountFragment();
		mShoppingFragment = new ShoppingFragment();
		mPutianFragment = new RealizePutianFragment();
		mDiscoveryFragmentt = new DiscoveryFragment();
//		mFragmentFavourites = new RightFragment();
		
		//默认显示页面mFragmentDail
		getFragmentManager().beginTransaction()
				.replace(R.id.content_view, mDiscount).commit();
		mContent = mDiscount;
//		View Tab = (View) LayoutInflater.from(getActivity()).inflate(
//				R.layout.tab_indicator, null);
//		TextView text0 = (TextView) Tab.findViewById(R.id.title);
//		text0.setText("0");
//		
//		View Tab1 = (View) LayoutInflater.from(getActivity()).inflate(
//				R.layout.tab_indicator, null);
//		TextView text1 = (TextView) Tab1.findViewById(R.id.title);
//		text1.setText("1");
//		
//		View Tab2 = (View) LayoutInflater.from(getActivity()).inflate(
//				R.layout.tab_indicator, null);
//		TextView text2 = (TextView) Tab2.findViewById(R.id.title);
//		text2.setText("2");
//		
//		View Tab3 = (View) LayoutInflater.from(getActivity()).inflate(
//				R.layout.tab_indicator, null);
//		TextView text3 = (TextView) Tab3.findViewById(R.id.title);
//		text3.setText("3");
//
//		
//		TabHost tabHost = (TabHost)centerView.findViewById(R.id.tabhost);
//        tabHost.setup();   //Call setup() before adding tabs if loading TabHost using findViewById(). 
//        
//        tabHost.addTab(tabHost.newTabSpec("nitab").setIndicator(Tab).setContent(R.id.tab1));
//        tabHost.addTab(tabHost.newTabSpec("wotab").setIndicator(Tab1).setContent(R.id.tab2));
//        tabHost.addTab(tabHost.newTabSpec("tatab").setIndicator(Tab2).setContent(R.id.tab3));
//        tabHost.addTab(tabHost.newTabSpec("wetab").setIndicator(Tab3).setContent(R.id.tab4));
		
		return center;
	}

	private void initLsnr(View center) {
		// TODO Auto-generated method stub
		mFrag_dail.setOnClickListener(this);
		mFrag_records.setOnClickListener(this);
		mFrag_text.setOnClickListener(this);
		mFrag_contact.setOnClickListener(this);
	}

	private void initView(View center) {
		// TODO Auto-generated method stub
		mFrag_dail = (RadioButton)center.findViewById(R.id.frag_dail);
		mFrag_dail.setChecked(true);
		mFrag_records = (RadioButton)center.findViewById(R.id.frag_records);
		mFrag_text = (RadioButton) center.findViewById(R.id.frag_text);
		mFrag_contact = (RadioButton) center.findViewById(R.id.frag_contact);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		// 该方法用于设置各个fragment布局与TabWidget之间的关联

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.frag_dail:
			switchContent(mContent, mDiscount);
			break;
		case R.id.frag_records:
			switchContent(mContent, mShoppingFragment);
			break;
		case R.id.frag_text:
			switchContent(mContent, mPutianFragment);
			break;
		case R.id.frag_contact:
			switchContent(mContent, mDiscoveryFragmentt);
			break;
		}
	}
	
	/**
	 * 跳转
	 * 
	 * @param from
	 * @param to
	 */
	public void switchContent(Fragment from, Fragment to) {
		if (from != to) {
			mContent = to;
			FragmentTransaction transaction = getFragmentManager()
					.beginTransaction();
			if (!to.isAdded()) { // 先判断是否被add过
				transaction.hide(from).add(R.id.content_view, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
			} else {
				transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
			}
		}
	}

}
