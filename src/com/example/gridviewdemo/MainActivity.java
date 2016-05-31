package com.example.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	private GridView gridView;
	private SimpleAdapter adapter;
	private List<Map<String, Object>> datalist;
	private int[] icon = { R.drawable.address_book, R.drawable.calendar,
			R.drawable.camera, R.drawable.clock, R.drawable.games_control,
			R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
			R.drawable.speech_balloon, R.drawable.weather, R.drawable.world,
			R.drawable.youtube };
	private String[] iconName = { "通讯里", "日历", "相机", "闹钟", "游戏", "信息", "彩铃",
			"设置", "语音", "天气", "世界", "优酷" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		gridView = (GridView) findViewById(R.id.gridView);
		datalist = new ArrayList<Map<String, Object>>();
		adapter = new SimpleAdapter(this, getData(), R.layout.item,
				new String[] { "image", "text" }, new int[] { R.id.image,
						R.id.text });
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}

	private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			datalist.add(map);
		}
		return datalist;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "点击了：" + iconName[position], Toast.LENGTH_SHORT)
				.show();
	}

}
