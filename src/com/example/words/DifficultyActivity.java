package com.example.words;

import android.os.Bundle;

import com.example.words.DifficultyActivity;
import com.example.words.GameActivity;
import com.example.words.R;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DifficultyActivity extends Activity {
	AudioManager am;
	RadioGroup rg;
	TextView tv;
	String name;
	SeekBar sb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty);
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
		tv = (TextView) findViewById(R.id.textView2);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		am = (AudioManager) getSystemService(AUDIO_SERVICE);
		int max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		sb.setMax(max);
		int current = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		sb.setProgress(current);
		rg.clearCheck();
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		tv.setText("Hello, "+name);
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Intent intent = new Intent(DifficultyActivity.this,GameActivity.class);
				intent.putExtra("name", name);
				if(checkedId == R.id.radio0){
					intent.putExtra("level", 0);
				}
				else if(checkedId == R.id.radio1){
					intent.putExtra("level", 1);
				}
				else if(checkedId == R.id.radio2) {
					intent.putExtra("level", 2);
				}
				startActivity(intent);
			}
		});
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.difficulty, menu);
		return true;
	}

}
