package csce315.team6.reversi;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.os.Bundle;

public class MainMenu extends Activity implements OnClickListener{
	private static MainMenu instance;
    
	@Override
    protected void onCreate(Bundle mainMenu) {
        super.onCreate(mainMenu);
        setContentView(R.layout.main);
        
        ImageButton playGame = (ImageButton)findViewById(R.id.play_game);
        ImageButton highScores = (ImageButton)findViewById(R.id.high_scores_button);
        ImageButton aboutButton = (ImageButton)findViewById(R.id.about_button);
		playGame.setOnClickListener(this);
		highScores.setOnClickListener(this);
		aboutButton.setOnClickListener(this);
    }

    public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
			case R.id.play_game: 
				Intent playGame = new Intent(this, GameChoice.class);
				startActivity(playGame);
				break;
			
			case R.id.high_scores_button: 
				Intent highScores = new Intent(this, HighScores.class);
				startActivity(highScores);
				break;
			case R.id.about_button:
				Intent aboutReversi = new Intent(this, AboutPage.class);
				startActivity(aboutReversi);
				break;
			default:
				break; 
		
		}
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}
	
	public static MainMenu getMainInstance(){
		return instance;
	}
}