package com.weka;
import com.weka.R;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTabMine extends BaseFragment {
	private View rootView;
	private Context context;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (rootView == null) {
			rootView = super.onCreateView(inflater, R.layout.fragment_tab_mine, container, false);
			context = getActivity();
			init();
			initOnClick();
		}
		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}
		return rootView;
	}
	
	private void init(){
	}
	private void initOnClick(){
	}
}
