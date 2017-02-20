package com.weka;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.weka.R;
import com.weka.utils.listview.XListView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentTabHome extends BaseFragment {
	private View rootView;
	private Context context;
	private XListView listView;
	private Button addCard;
	private CardListAdater adapter;
	private List<Map<String, Object>> cardList = new ArrayList<Map<String,Object>> ();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (rootView == null) {
			rootView = super.onCreateView(inflater, R.layout.fragment_tab_home, container, false);
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

	private void init() {
		adapter = new CardListAdater();
		listView = (XListView) rootView.findViewById(R.id.home_card_list);
		listView.setAdapter(adapter);
		addCard = (Button) rootView.findViewById(R.id.home_card_add);
	}

	private void initOnClick() {
		addCard.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				toLoginActivity();
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				toCardDetailActivity();
			}
		});
	}

	class CardListAdater extends BaseAdapter {
		private LayoutInflater inflater = LayoutInflater.from(context);

		// TODO Auto-generated constructor stub
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return cardList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return cardList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.item_list_card, null);
				holder.cardLogo = (ImageView) convertView.findViewById(R.id.item_card_logo);
				holder.cardTitle = (TextView) convertView.findViewById(R.id.item_card_title);
				holder.cardBalance = (TextView) convertView.findViewById(R.id.item_card_balance);
				holder.buy = (Button) convertView.findViewById(R.id.item_card_buy);
				holder.cardTitle.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						toBalanceActivity();
					}
				});
				holder.buy.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						toBuyActivity();
					}
				});
				convertView.setTag(holder);
			} else if (convertView != null) {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}

		public final class ViewHolder {
			public ImageView cardLogo;
			public TextView cardTitle;
			public TextView cardBalance;
			public Button buy;
		}

		private void toBuyActivity() {

		}

		private void toBalanceActivity() {

		}
	}
	private void toCardDetailActivity(){
		
	}
	private void toLoginActivity(){
		Intent intent = new Intent(getActivity(), WekaLoginActivity.class);
		startActivity(intent);
	}
}
