package com.example.words;

import android.os.Bundle;

import com.example.words.DifficultyActivity;
import com.example.words.PlayMusic;
import com.example.words.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText et;
	SharedPreferences sf;
	SQLiteDatabase db;
	Editor ed;
	Intent s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);et = (EditText) findViewById(R.id.editText1);
		sf = getSharedPreferences("name", MODE_PRIVATE);
		et.setText(sf.getString("name", ""));
		Thread t = new Thread(){
			public void run(){
				try{
					db = openOrCreateDatabase("jumble!", MODE_PRIVATE, null);
				}
				catch(Exception e){}
				try{
					db.execSQL("CREATE TABLE WORDS(WORD varchar(7) UNIQUE, DIFFICULTY number(1))");
				}
				catch(Exception e){}
				addWords();
			}
		};
		t.start();
		s = new Intent(this,PlayMusic.class);
		startService(s);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		stopService(s);
	}
	
	public void saveName(View v){
		String name = et.getText().toString().trim();
		if(name.length()==0){
			Toast.makeText(this, "Enter Your Name First!!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			ed = sf.edit();
			ed.putString("name", name);
			ed.commit();
			Intent intent = new Intent(this,DifficultyActivity.class);
			intent.putExtra("name", name);
			startActivity(intent);
		}
	}
	
	public void addWords(){
		try{
			
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('about',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('again',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('heart',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('pizza',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('water',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('happy',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('bored',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('month',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('angel',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('death',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('green',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('music',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('party',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('mouth',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('woman',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('sugar',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('dream',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('laugh',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('apple',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('tiger',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('faith',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('money',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('river',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('peace',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('smile',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('watch',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('alone',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('house',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('lemon',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('thing',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('stone',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('light',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('power',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('story',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('point',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('today',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('anger',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('night',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('candy',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('mango',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('zebra',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('brain',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('train',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('under',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('dirty',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('field',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('cycle',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('truth',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('honor',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('smart',0)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('orange',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('family',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('donate',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('people',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('future',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('heaven',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('banana',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('office',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('animal',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('nature',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('father',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('yellow',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('poetry',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('broken',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('school',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('circle',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('potato',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('moment',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('breath',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('dragon',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('person',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('spring',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('energy',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('change',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('system',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('pirate',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('monkey',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('secret',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('mother',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('winter',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('strong',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('bucket',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('forest',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('joyful',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('doctor',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('season',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('friend',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('memory',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('cookie',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('silent',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('talent',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('bottle',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('wonder',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('happen',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('better',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('number',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('little',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('melody',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('couple',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('cousin',1)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('perfect',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('country',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('special',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('freedom',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('nothing',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('picture',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('husband',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('monster',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('morning',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('journey',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('history',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('amazing',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('teacher',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('forever',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('kitchen',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('holiday',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('welcome',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('courage',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('silence',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('someone',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('revenge',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('science',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('harmony',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('awesome',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('problem',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('blanket',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('imagine',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('student',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('mistery',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('captian',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('natural',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('healthy',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('kingdom',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('message',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('library',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('forward',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('magical',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('honesty',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('nuclear',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('fitness',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('popcorn',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('stomach',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('friends',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('fortune',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('chicken',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('liberty',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('company',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('strange',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('garbage',2)");
			db.execSQL("INSERT INTO WORDS (WORD,DIFFICULTY) VALUES('alcohol',2)");
		}
		catch(Exception e){}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
