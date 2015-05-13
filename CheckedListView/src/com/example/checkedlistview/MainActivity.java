package com.example.checkedlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private Context context=this;
	private CheckedAdapter checkedAdapter=new CheckedAdapter(context, null);
	
	private ListView checkedLv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		checkedLv=(ListView)findViewById(R.id.lv_checked);
		
		ArrayList<ListInfo> checkedList=new ArrayList<ListInfo>();
		for(int idx=0; idx<50; idx++){
			ListInfo listInfo=new ListInfo();
			listInfo.setValue("Value no."+(idx+1));
			listInfo.setChecked(false);
			checkedList.add(listInfo);
		}
		checkedAdapter.setInfoList(checkedList);
		checkedLv.setAdapter(checkedAdapter);
	}
}
