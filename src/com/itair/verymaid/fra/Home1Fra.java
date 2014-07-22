package com.itair.verymaid.fra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itair.verymaid.MainActivity;
import com.itair.verymaid.R;

/**
 * 首页
 */
public class Home1Fra extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.index_1, null);
		init(v);

		return v;
	}

	private void init(View v) {

		 TextView tv = (TextView) v.findViewById(R.id.tv_test);
		 tv.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		 case R.id.tv_test: // 
//			 MainActivity.change(getActivity(), new Home1_1Fra());
		 break;

		default:
			break;
		}
	}
	
}
