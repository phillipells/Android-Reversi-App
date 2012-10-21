package csce315.team6.reversi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {//implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle splashScreen) {
        super.onCreate(splashScreen);
        setContentView(R.layout.splash);
        Thread timer = new Thread() {
        	public void run(){
	        	try{
	        		sleep(5000);	        		
	        	}catch(InterruptedException e){
	        		e.printStackTrace();
	        	}finally{
	        		Intent mainMenu = new Intent("csce315.team6.reversi.MAINMENU");
	        		startActivity(mainMenu);
	        	}
        	}
        };
        timer.start();
    }
    protected void onPause() {
    	super.onPause();
    	finish();
    }
}