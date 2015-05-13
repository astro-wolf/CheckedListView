package com.example.checkedlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckedAdapter extends BaseAdapter {

	private Context context;
	
	private ArrayList<ListInfo> infoList=new ArrayList<ListInfo>();
	
	public CheckedAdapter(Context ctx, ArrayList<ListInfo> cList) {
		this.context=ctx;
		this.infoList=cList;
	}
	
	@Override
	public int getCount() {
		return infoList.size();
	}

	@Override
	public Object getItem(int position) {
		return infoList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return infoList.indexOf(infoList.get(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if(convertView==null){
			viewHolder=new ViewHolder();
			LayoutInflater mInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView=mInflater.inflate(R.layout.layout_checked, parent, false);
			viewHolder.valueTv=(TextView)convertView.findViewById(R.id.tv_checked);
			viewHolder.valueCb=(CheckBox)convertView.findViewById(R.id.cb_checked);
			convertView.setTag(viewHolder);
		}
		else{
			viewHolder=(ViewHolder)convertView.getTag();
		}
		
		final ListInfo menuInfo=(ListInfo)getItem(position);
		
		viewHolder.valueTv.setText(menuInfo.getValue());
		viewHolder.valueCb.setChecked(menuInfo.isChecked());
		
		viewHolder.valueCb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(menuInfo.isChecked()){
					menuInfo.setChecked(false);
				}
				else{
					menuInfo.setChecked(true);
				}
				viewHolder.valueCb.setChecked(menuInfo.isChecked());
			}
		});
		
		return convertView;
	}
	
	private class ViewHolder{
		private TextView valueTv;
		private CheckBox valueCb;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public ArrayList<ListInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(ArrayList<ListInfo> infoList) {
		this.infoList = infoList;
	}

}
