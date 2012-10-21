package csce315.team6.reversi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.os.Environment;


public class HighScores extends Activity implements OnClickListener{
	TextView easy_diff_wins;
	TextView medium_diff_wins;
	TextView hard_diff_wins;
	TextView random_diff_wins;
	TextView easy_diff_losses;
	TextView medium_diff_losses;
	TextView hard_diff_losses;
	TextView random_diff_losses;
	@Override
	public void onCreate(Bundle gameChoice) {
        super.onCreate(gameChoice);
        setContentView(R.layout.highscores);

        easy_diff_wins = (TextView) findViewById(R.id.wins1);
        medium_diff_wins = (TextView) findViewById(R.id.wins2);
        hard_diff_wins = (TextView) findViewById(R.id.wins3);
        random_diff_wins = (TextView) findViewById(R.id.wins4);
        easy_diff_losses = (TextView) findViewById(R.id.losses1);
        medium_diff_losses = (TextView) findViewById(R.id.losses2);
        hard_diff_losses = (TextView) findViewById(R.id.losses3);
        random_diff_losses = (TextView) findViewById(R.id.losses4);
        /*Load scores from SD card*/
        try {
			File myFile = new File("/sdcard/thescores.xml");
			if(!myFile.exists()){
				easy_diff_wins.setText("0");
				medium_diff_wins.setText("0");
				hard_diff_wins.setText("0");
				random_diff_wins.setText("0");
				easy_diff_losses.setText("0");
				medium_diff_losses.setText("0");
				hard_diff_losses.setText("0");
				random_diff_losses.setText("0");
				return;
			}
			FileInputStream fIn = new FileInputStream(myFile);
			BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
			String aDataRow = "";
			String aBuffer = "";
			while((aDataRow = myReader.readLine()) != null) {
					aBuffer += aDataRow;
			}
			char[] cArray = aBuffer.toCharArray();
			int i = 0;
			String easyWins = "", mediumWins = "", hardWins = "", randomWins = "";
			String easyLosses = "", mediumLosses = "", hardLosses = "", randomLosses = ""; // These don't get set yet
			while (Character.isDigit(cArray[i])) {
				easyWins += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				mediumWins += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				hardWins += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				randomWins += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				easyLosses += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				mediumLosses += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				hardLosses += cArray[i];
				i++;
			}
			i++;
			while (Character.isDigit(cArray[i])) {
				randomLosses += cArray[i];
				i++;
			}
			
			easy_diff_wins.setText(easyWins);
			medium_diff_wins.setText(mediumWins);
			hard_diff_wins.setText(hardWins);
			random_diff_wins.setText(randomWins);
			easy_diff_losses.setText(easyLosses);
			medium_diff_losses.setText(mediumLosses);
			hard_diff_losses.setText(hardLosses);
			random_diff_losses.setText(randomLosses);

			myReader.close();
			//Toast.makeText(getBaseContext(), "Done reading SD 'thescores.xml'", Toast.LENGTH_SHORT).show();
		}
		catch(Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
		}
        /**************************/

       // Button saveButton = (Button)findViewById(R.id.save_button);
        Button loadButton = (Button)findViewById(R.id.load_button);
      //  saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);

    }
	public void onClick(View v) {
		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();
		if(Environment.MEDIA_MOUNTED.equals(state)) {
			mExternalStorageAvailable = mExternalStorageWriteable = true;
			switch(v.getId()) {
				/*case R.id.save_button: {
					try {
						File myFile = new File("/sdcard/thescores.xml");
						myFile.createNewFile();
						FileOutputStream fOut = new FileOutputStream(myFile);
						OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
						// For file format, I was thinking somewhere along the lines of:
						// easy wins = 4
						// easy games played = 5
						// medium wins = 2
						// medium games played wins = 6
						// so the file would look like:
						// 4.5.2.6.etc..
						// so we parse until every period and we already know the order so we shouldn't have any errors
						myOutWriter.append(score_text.getText()+"."+score_text1.getText()+"."+score_text2.getText()+"."+score_text3.getText()+".");
						myOutWriter.close();
						fOut.close();
						Toast.makeText(getBaseContext(), "Done writing SD 'thescores.xml'", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e) {
						Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
					}
					break;
				}*/
				/*case R.id.load_button: {
					try {
						File myFile = new File("/sdcard/thescores.xml");
						FileInputStream fIn = new FileInputStream(myFile);
						BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
						String aDataRow = "";
						String aBuffer = "";
						while((aDataRow = myReader.readLine()) != null) {
								aBuffer += aDataRow;
						}
						char[] cArray = aBuffer.toCharArray();
						int i = 0;
						String easyWins = "", mediumWins = "", hardWins = "", randomWins = "";
						String easyGamesPlayed = "", mediumGamesPlayed = "", hardGamesPlayed = "", randomGamesPlayed = ""; // These don't get set yet
						while (Character.isDigit(cArray[i])) {
							easyWins += cArray[i];
							i++;
						}
						i++;
						while (Character.isDigit(cArray[i])) {
							mediumWins += cArray[i];
							i++;
						}
						i++;
						while (Character.isDigit(cArray[i])) {
							hardWins += cArray[i];
							i++;
						}
						i++;
						while (Character.isDigit(cArray[i])) {
							randomWins += cArray[i];
							i++;
						}
						easy_diff_wins.setText(easyWins);
						medium_diff_wins.setText(mediumWins);
						hard_diff_wins.setText(hardWins);
						random_diff_wins.setText(randomWins);

						myReader.close();
						Toast.makeText(getBaseContext(), "Done reading SD 'thescores.xml'", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e) {
						Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
					}
					break;
				}*/
				default:
					break;
			}
			
		}
		
		else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			mExternalStorageAvailable = true;
			mExternalStorageWriteable = false;
		}
		else {
			mExternalStorageAvailable = mExternalStorageWriteable = false;
		}
	}

}