package csce315.team6.reversi;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import android.os.Bundle;

public class GameChoice extends Activity implements OnClickListener{
	private static GameChoice instance; 
	private ToggleButton colorButton;
	
	// booleans for gameState
	public static boolean playHuman = false;
	public static boolean playEasy = false;
	public static boolean playMedium = false;
	public static boolean playHard = false;
	public static boolean playRandom = false;
	public static boolean humanIsFirstPlayer = true;
	
	@Override
	public void onCreate(Bundle gameChoice) {
        super.onCreate(gameChoice);
        setContentView(R.layout.gamechoice);
        ImageButton playGame = (ImageButton)findViewById(R.id.start_press);
    	colorButton = (ToggleButton) findViewById(R.id.choose_color);
        colorButton.setOnClickListener(this);
		playGame.setOnClickListener(this);
		
		RadioButton twoPlayer = (RadioButton) findViewById(R.id.two_player);
		RadioButton easyMode = (RadioButton) findViewById(R.id.easy_mode);
		RadioButton mediumMode = (RadioButton) findViewById(R.id.medium_mode);
		RadioButton hardMode = (RadioButton) findViewById(R.id.hard_mode);
		RadioButton randomMode = (RadioButton) findViewById(R.id.random_mode);
		twoPlayer.setOnClickListener(this);
		easyMode.setOnClickListener(this);
		mediumMode.setOnClickListener(this);
		hardMode.setOnClickListener(this);
		randomMode.setOnClickListener(this);
		
		//initialize to 2 player
		playHuman = false;
		playEasy = false;
		playMedium = false;
		playHard = false;
		playRandom = false;
		playHuman = true;
		humanIsFirstPlayer = false;
    }
	
	public static GameChoice getChoiceInstance(){
    	return instance;
    }
	
	public void onClick(View v) {
		if(colorButton.isChecked()) {
			colorButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.blackselect));
			humanIsFirstPlayer = true;
		}
		else {
			colorButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.whiteselect));
			humanIsFirstPlayer = false;
		}
		switch(v.getId()) {
			case R.id.start_press:
				Intent startGame = new Intent(this, Gameboard.class);
				startActivity(startGame);
				break;
			case R.id.two_player:
				playHuman = false;
				playEasy = false;
				playMedium = false;
				playHard = false;
				playRandom = false;
				
				playHuman = true;
				break;
			case R.id.easy_mode:
				playHuman = false;
				playEasy = false;
				playMedium = false;
				playHard = false;
				playRandom = false;
				
				playEasy = true;
				break;
			case R.id.medium_mode:
				playHuman = false;
				playEasy = false;
				playMedium = false;
				playHard = false;
				playRandom = false;
				
				playMedium = true;
				break;
			case R.id.hard_mode:
				playHuman = false;
				playEasy = false;
				playMedium = false;
				playHard = false;
				playRandom = false;
				
				playHard = true;
				break;
			case R.id.random_mode:
				playHuman = false;
				playEasy = false;
				playMedium = false;
				playHard = false;
				playRandom = false;
				
				playRandom = true;
				break;
		}
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}
}