package com.example.words;

import android.os.Bundle;

import java.util.Random;

import com.example.words.DifficultyActivity;
import com.example.words.GameActivity;
import com.example.words.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
	TextView tv,tv1,tv2;
	EditText et;
	Button b;
	int i, attempt=6;
	String name,words[];
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		tv = (TextView) findViewById(R.id.textView2);
		et = (EditText) findViewById(R.id.editText1);
		tv1 = (TextView) findViewById(R.id.textView6);
		tv2 = (TextView) findViewById(R.id.textView7);
		b = (Button) findViewById(R.id.button1);
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		int level = intent.getIntExtra("level", 0);
		
		try{
			db = openOrCreateDatabase("jumble!", MODE_PRIVATE, null);
		}
		catch(Exception e){}
		try{
			Cursor c = db.rawQuery("SELECT * FROM WORDS WHERE DIFFICULTY='"+level+"'", null);
			words = new String[c.getCount()];
			for(int i=0; i<c.getCount(); i++){
				c.moveToNext();
				words[i] = c.getString(0);
			}

		}
		catch(Exception e){}
		
		shuffleArray();
		showNextWord();
	}

	public String scramble(String word) {
		char a[] = word.toCharArray();
		Random random = new Random();
	    for( int i=0 ; i<a.length-1 ; i++ ){
	        int j = random.nextInt(a.length-1);
	        char temp = a[i]; a[i] = a[j];  a[j] = temp;
	    }       
	    return new String(a);
	}
	
	public void shuffleArray(){
		Random random = new Random();
	    for (int i=words.length-1; i>0; i--){
	      int index = random.nextInt(i+1);
	      String a = words[index];
	      words[index] = words[i];
	      words[i] = a;
	    }
	}

	public void showNextWord(){
		i++;
		tv.setText(scramble((words[i-1]).toUpperCase()));
		if(i<=20){
			tv1.setText(""+i+"/20");
		}
		if(i==20){
			b.setText("Finish");
		}
		else if(i>20){
			et.setVisibility(EditText.INVISIBLE);
			b.setText("Menu");
			tv.setText("YOU WON !!");
		}
	}
	
	public void nextWord(View v){
		if((b.getText().toString()).equals("Menu")){
			Intent intent = new Intent(GameActivity.this,DifficultyActivity.class);
			intent.putExtra("name",name);
			startActivity(intent);
		}
		else if((et.getText().toString().toLowerCase()).equals(words[i-1])){
			showNextWord();
			et.setText("");
		}
		else{
			if(attempt !=0)
				attempt--;
			else{
				et.setVisibility(EditText.INVISIBLE);
				b.setText("Menu");
				tv.setText("GAME OVER !!");
			}
			tv2.setText(""+attempt);
			Toast.makeText(this, "Wrong Attempt !!", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
