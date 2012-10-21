package csce315.team6.reversi;

import csce315.team6.animation.DisplayNextView;
import csce315.team6.animation.Rotate3dAnimation;
import csce315.team6.reversi.R.layout;
import csce315.team6.reversi.ReversiRules.Tuple;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Gameboard extends Activity implements OnClickListener{
	//array of clickable image buttons
	private static int buttonId[] = {
			R.id.Button01, R.id.Button02, R.id.Button03, R.id.Button04, R.id.Button05,
			R.id.Button06, R.id.Button07, R.id.Button08, R.id.Button09, R.id.Button10,
			R.id.Button11, R.id.Button12, R.id.Button13, R.id.Button14, R.id.Button15,
			R.id.Button16, R.id.Button17, R.id.Button18, R.id.Button19, R.id.Button20,
			R.id.Button21, R.id.Button22, R.id.Button23, R.id.Button24, R.id.Button25,
			R.id.Button26, R.id.Button27, R.id.Button28, R.id.Button29, R.id.Button30,
			R.id.Button31, R.id.Button32, R.id.Button33, R.id.Button34, R.id.Button35,
			R.id.Button36, R.id.Button37, R.id.Button38, R.id.Button39, R.id.Button40,
			R.id.Button41, R.id.Button42, R.id.Button43, R.id.Button44, R.id.Button45,
			R.id.Button46, R.id.Button47, R.id.Button48, R.id.Button49, R.id.Button50, 
			R.id.Button51, R.id.Button52, R.id.Button53, R.id.Button54, R.id.Button55,
			R.id.Button56, R.id.Button57, R.id.Button58, R.id.Button59, R.id.Button60,
			R.id.Button61, R.id.Button62, R.id.Button63, R.id.Button64,
			};
	//array of white piece xml views
	private static int noteListIdw[] = {
			R.id.notelist01w,R.id.notelist02w,R.id.notelist03w,R.id.notelist04w,R.id.notelist05w,
			R.id.notelist06w,R.id.notelist07w,R.id.notelist08w,R.id.notelist09w,R.id.notelist10w,
			R.id.notelist11w,R.id.notelist12w,R.id.notelist13w,R.id.notelist14w,R.id.notelist15w,
			R.id.notelist16w,R.id.notelist17w,R.id.notelist18w,R.id.notelist19w,R.id.notelist20w,
			R.id.notelist21w,R.id.notelist22w,R.id.notelist23w,R.id.notelist24w,R.id.notelist25w,
			R.id.notelist26w,R.id.notelist27w,R.id.notelist28w,R.id.notelist29w,R.id.notelist30w,
			R.id.notelist31w,R.id.notelist32w,R.id.notelist33w,R.id.notelist34w,R.id.notelist35w,
			R.id.notelist36w,R.id.notelist37w,R.id.notelist38w,R.id.notelist39w,R.id.notelist40w,
			R.id.notelist41w,R.id.notelist42w,R.id.notelist43w,R.id.notelist44w,R.id.notelist45w,
			R.id.notelist46w,R.id.notelist47w,R.id.notelist48w,R.id.notelist49w,R.id.notelist50w,
			R.id.notelist51w,R.id.notelist52w,R.id.notelist53w,R.id.notelist54w,R.id.notelist55w,
			R.id.notelist56w,R.id.notelist57w,R.id.notelist58w,R.id.notelist59w,R.id.notelist60w,
			R.id.notelist61w,R.id.notelist62w,R.id.notelist63w,R.id.notelist64w
			};
	//array of black piece xml views
	private static int noteListIdb[] = {
			R.id.notelist01b,R.id.notelist02b,R.id.notelist03b,R.id.notelist04b,R.id.notelist05b,
			R.id.notelist06b,R.id.notelist07b,R.id.notelist08b,R.id.notelist09b,R.id.notelist10b,
			R.id.notelist11b,R.id.notelist12b,R.id.notelist13b,R.id.notelist14b,R.id.notelist15b,
			R.id.notelist16b,R.id.notelist17b,R.id.notelist18b,R.id.notelist19b,R.id.notelist20b,
			R.id.notelist21b,R.id.notelist22b,R.id.notelist23b,R.id.notelist24b,R.id.notelist25b,
			R.id.notelist26b,R.id.notelist27b,R.id.notelist28b,R.id.notelist29b,R.id.notelist30b,
			R.id.notelist31b,R.id.notelist32b,R.id.notelist33b,R.id.notelist34b,R.id.notelist35b,
			R.id.notelist36b,R.id.notelist37b,R.id.notelist38b,R.id.notelist39b,R.id.notelist40b,
			R.id.notelist41b,R.id.notelist42b,R.id.notelist43b,R.id.notelist44b,R.id.notelist45b,
			R.id.notelist46b,R.id.notelist47b,R.id.notelist48b,R.id.notelist49b,R.id.notelist50b,
			R.id.notelist51b,R.id.notelist52b,R.id.notelist53b,R.id.notelist54b,R.id.notelist55b,
			R.id.notelist56b,R.id.notelist57b,R.id.notelist58b,R.id.notelist59b,R.id.notelist60b,
			R.id.notelist61b,R.id.notelist62b,R.id.notelist63b,R.id.notelist64b
			};

	private static Gameboard instance; // used for accessing Gameboard functions outside of Gameboard.java
	private static ReversiRules.reversi newBoard = new ReversiRules.reversi();
	
	//buttons and views
	private static ImageButton btn[] = new ImageButton[64];
	private static ImageButton undo;
	private static ImageButton redo;
	private static ImageButton newGameButton;
	private static ImageButton mainMenu;
	private static View whiteViews[] = new View[64];
	private static View blackViews[] = new View[64];
	private static ImageView whiteImageViews[] = new ImageView[64];
	private static ImageView blackImageViews[] = new ImageView[64];
	private static TextView whiteScore;
	private static TextView blackScore;
	private static TextView infoText;
	private static ProgressBar aiThinking;
	
	private static int currentColumn;
	private static int currentRow;
	private static boolean isWhite = false; // tracks current player (initialized as black)
	private static boolean humanMadeValidMove = false;
	
	//AI related booleans
	private static boolean playWithHuman = false;
	private static boolean playWithEasy = false;
	private static boolean playWithMedium = false;
	private static boolean playWithHard = false;
	private static boolean playWithRandom = false;
	private static boolean trueWhenHumanIsBlack = true;
	private static int delayAfterMove = 0;
	    
    @Override
    public void onCreate(Bundle gameBoard) {
        super.onCreate(gameBoard);
        setContentView(R.layout.gameboard);
        
        //reset all booleans
        System.out.println("resetting...");
        isWhite = false; // tracks current player (initialized as black)
    	setGameState();
        
        instance = this;
        whiteScore = (TextView) findViewById(R.id.whiteScore);
        blackScore = (TextView) findViewById(R.id.blackScore);
        infoText = (TextView) findViewById(R.id.statusText);
        aiThinking = (ProgressBar) findViewById(R.id.aiThinking);
        
        undo = (ImageButton) findViewById(R.id.undo);
        undo.setOnClickListener(this);
        redo = (ImageButton) findViewById(R.id.redo);
        redo.setOnClickListener(this);
        newGameButton = (ImageButton) findViewById(R.id.newGame);
        newGameButton.setOnClickListener(this);
        mainMenu = (ImageButton) findViewById(R.id.menu);
        mainMenu.setOnClickListener(this);
        
        //initialize all the Image Buttons
        for (int i=0; i<64; i++){
        	btn[i] = (ImageButton) findViewById(buttonId[i]);
        	btn[i].setOnClickListener(this);
        }
        //initialize all the piece animations
        for (int i=0; i<64; i++){
        	whiteViews[i] = findViewById(noteListIdw[i]);
        	whiteImageViews[i] = (ImageView) whiteViews[i].findViewById(R.id.white01);
        	blackViews[i] = findViewById(noteListIdb[i]);
        	blackImageViews[i] = (ImageView) blackViews[i].findViewById(R.id.black01);
        }
        
        //initialize the score & info text
        whiteScore.setText("2");
		blackScore.setText("2");
		infoText.setText("> WELCOME TO REVERSI");
		aiThinking.setVisibility(View.GONE);
        
		//1 player game
		newBoard.localGame = playWithHuman;
        
		//display starting board
        newBoard.initializeBoard();
        initializeGameboard(newBoard);
        newBoard.printValidMoves(newBoard.black);
        
        //pause game then start
        pauseFor(3000);
    }

	public void onClick(View v) {
		humanMadeValidMove = false;
		currentRow=0;
		currentColumn=0;
		if (v.getId() == undo.getId()){
			newBoard.undo();
			return;
		}
		if (v.getId() == redo.getId()){
			newBoard.redo();
			return;
		}
		if (v.getId() == newGameButton.getId()){
			newGameDialog();
			return;
		}
		if (v.getId() == mainMenu.getId()){
			areYouSureDialog();
			return;
		}
		for (int i=0; i<64; i++) {
			if (v.getId() == btn[i].getId()) {
				if (0<=i && i<=7){ currentRow=7;}
				if (8<=i && i<=15){ currentRow=6;}
				if (16<=i && i<=23){ currentRow=5;}
				if (24<=i && i<=31){ currentRow=4;}
				if (32<=i && i<=39){ currentRow=3;}
				if (40<=i && i<=47){ currentRow=2;}
				if (48<=i && i<=55){ currentRow=1;}
				if (56<=i && i<=63){ currentRow=0;}
				currentColumn=(64-i)-(currentRow*8)-1;
				if (isWhite == true){
					newBoard.performMove(currentColumn, currentRow, newBoard.white);
					newBoard.checkGameStatus(newBoard.black);
					if (humanMadeValidMove == true){
						aiTurn();
					}
					humanMadeValidMove = false;
					break;
				} else {
					newBoard.performMove(currentColumn, currentRow, newBoard.black);
					newBoard.checkGameStatus(newBoard.white);
					if (humanMadeValidMove == true){
						aiTurn();
					}
					humanMadeValidMove = false;
					break;
				}
			}
		}
	}
		
	// Variable Access Functions/Utility *********************************
	public static Gameboard getInstance(){
    	return instance;
    }
	
	public void madeValidMove(boolean trueWhenMoved){
		humanMadeValidMove = trueWhenMoved;
	}
	
	public void setGameState(){
		playWithHuman = GameChoice.getChoiceInstance().playHuman;
		playWithEasy = GameChoice.getChoiceInstance().playEasy;
		playWithMedium = GameChoice.getChoiceInstance().playMedium;
		playWithHard = GameChoice.getChoiceInstance().playHard;
		playWithRandom = GameChoice.getChoiceInstance().playRandom;
		trueWhenHumanIsBlack = GameChoice.getChoiceInstance().humanIsFirstPlayer;
	}

	public void switchPlayer(){
		isWhite = !isWhite;
		if (isWhite = true){
			System.out.println("Switched to White's turn");
		} else {
			System.out.println("Switched to Black's turn");
		}
	}
	
	public boolean getHumanPlayer(){
		return trueWhenHumanIsBlack;
	}
	
	public void setPlayer(boolean color){
		isWhite = color; // true if white; false if black
	}
	
	public void pauseFor(final int pauseLength){
		turnOffButtons();
		delayAfterMove = pauseLength;
		new Handler().postDelayed(new Runnable()
	    {
	        public void run()
	        {
	        	//AI moves if human is white:
                if (trueWhenHumanIsBlack == false && playWithHuman == false){
                	aiTurn();
                } else {
                	infoText.setText("> BLACK'S TURN...");
                	turnOnButtons();
                }
	        }
	    }, delayAfterMove);
	}
	// *******************************************************************
	
	// Dialog Buttons: Menu/New Game *************************************
	public void areYouSureDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to exit the game? You will lose your progress. ")
		       .setCancelable(false)
		       .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   newBoard.gameOver = false;
		        	   Intent mainMenu = new Intent("csce315.team6.reversi.MAINMENU");
		        	   startActivity(mainMenu);
		        	   finish();
		           }
		       })
		       .setNegativeButton("Keep Playing", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public void newGameDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to start a new game? You will lose your progress. ")
		       .setCancelable(false)
		       .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   newBoard.gameOver = false;
		        	   Gameboard.this.recreate();
		           }
		       })
		       .setNegativeButton("Keep Playing", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	// *******************************************************************
	
	// Gameboard UI manipulation *****************************************
	public void turnOffButtons(){
		for (int i=0; i<64; i++){
        	btn[i].setClickable(false);
        }
		undo.setClickable(false);
		redo.setClickable(false);
	}

	public void turnOnButtons(){
		for (int i=0; i<64; i++){
        	btn[i].setClickable(true);
        }
		undo.setClickable(true);
		redo.setClickable(true);
	}
	
	public void addWhitePiece(int col, int row){
		int pieceNumber = 63-(row*8+col);
		blackImageViews[pieceNumber].setVisibility(View.VISIBLE);
		blackImageViews[pieceNumber].setImageResource(R.drawable.white);
		blackImageViews[pieceNumber].setTag("white");
	}
	
	public void addBlackPiece(int col, int row){
		int pieceNumber = 63-(row*8+col);
		blackImageViews[pieceNumber].setVisibility(View.VISIBLE);
		blackImageViews[pieceNumber].setImageResource(R.drawable.black);
		blackImageViews[pieceNumber].setTag("black");
	}
	
	public void addValidPiece(int col, int row){
		int pieceNumber = 63-(row*8+col);
		blackImageViews[pieceNumber].setVisibility(View.VISIBLE);
		blackImageViews[pieceNumber].setImageResource(R.drawable.valid);
		blackImageViews[pieceNumber].setTag("valid");
	}
	
	public void clearValidPieces(){
		int row=0;
		int col=0;
        for (int i=0; i<64; i++){
			if (0<=i && i<=7){ row=7;}
			if (8<=i && i<=15){ row=6;}
			if (16<=i && i<=23){ row=5;}
			if (24<=i && i<=31){ row=4;}
			if (32<=i && i<=39){ row=3;}
			if (40<=i && i<=47){ row=2;}
			if (48<=i && i<=55){ row=1;}
			if (56<=i && i<=63){ row=0;}
			col=(64-i)-(row*8)-1;
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.empty){
				blackImageViews[i].setImageResource(R.drawable.invisible);
				blackImageViews[i].setTag("invisible");
				blackImageViews[i].setVisibility(View.GONE);
			}
		}	
	}

	public void flipPieceAnimation(int col, int row){
		//rows 0-7; col 0-7
		int pieceNumber = 63-(row*8+col);
		System.out.println("flipping piece # "+pieceNumber);
		ImageView blackPiece = blackImageViews[pieceNumber];
		if (blackPiece.getTag().toString().equals("white")){
			System.out.println("piece to be flipped is white");
			applyRotation(0, 90, blackPiece, blackPiece, true);
		} else if (blackPiece.getTag().toString().equals("black")){
			System.out.println("piece to be flipped is black");
			applyRotation(0, -90, blackPiece, blackPiece, false);
		}
	}
	
	private void applyRotation(float start, float end, ImageView image1, ImageView image2, boolean isFirstImage) {
		// Find the center of image
		final float centerX = image1.getWidth() / 2.0f;
		final float centerY = image1.getHeight() / 2.0f;
		
		// Create a new 3D rotation with the supplied parameter
		// The animation listener is used to trigger the next animation
		final Rotate3dAnimation rotation =
				new Rotate3dAnimation(start, end, centerX, centerY, 0, false);
		rotation.setDuration(150);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new AccelerateInterpolator());
		rotation.setAnimationListener(new DisplayNextView(isFirstImage, image1, image2));
		
		if (isFirstImage) {
			image1.startAnimation(rotation);
		} else {
			image2.startAnimation(rotation);
		}
	}
	
	public void initializeGameboard(ReversiRules.reversi newBoard){
		int row=0;
		int col=0;
        for (int i=0; i<64; i++){
			if (0<=i && i<=7){ row=7;}
			if (8<=i && i<=15){ row=6;}
			if (16<=i && i<=23){ row=5;}
			if (24<=i && i<=31){ row=4;}
			if (32<=i && i<=39){ row=3;}
			if (40<=i && i<=47){ row=2;}
			if (48<=i && i<=55){ row=1;}
			if (56<=i && i<=63){ row=0;}
			col=(64-i)-(row*8)-1;
			btn[i].setBackgroundColor(Color.TRANSPARENT);
			whiteImageViews[i].setVisibility(View.GONE);
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.empty){
				blackImageViews[i].setImageResource(R.drawable.invisible);
				blackImageViews[i].setTag("invisible");
			}
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.black){
				blackImageViews[i].setVisibility(View.VISIBLE);
				blackImageViews[i].setImageResource(R.drawable.black);
				blackImageViews[i].setTag("black");
			}
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.white){
				blackImageViews[i].setVisibility(View.VISIBLE);
				blackImageViews[i].setImageResource(R.drawable.white);
				blackImageViews[i].setTag("white");
			}
		}
	}
	
	public void updateGameboard(){
		clearValidPieces();
		int row=0;
		int col=0;
		for (int i=0; i<64; i++){
			if (0<=i && i<=7){ row=7;}
			if (8<=i && i<=15){ row=6;}
			if (16<=i && i<=23){ row=5;}
			if (24<=i && i<=31){ row=4;}
			if (32<=i && i<=39){ row=3;}
			if (40<=i && i<=47){ row=2;}
			if (48<=i && i<=55){ row=1;}
			if (56<=i && i<=63){ row=0;}
			col=(64-i)-(row*8)-1;
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.empty){
				blackImageViews[i].setImageResource(R.drawable.invisible);
				blackImageViews[i].setTag("invisible");
			}
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.black){
				blackImageViews[i].setVisibility(View.VISIBLE);
				blackImageViews[i].setImageResource(R.drawable.black);
				blackImageViews[i].setTag("black");
			}
			if (newBoard.board[col][row][newBoard.currentMove] == newBoard.white){
				blackImageViews[i].setVisibility(View.VISIBLE);
				blackImageViews[i].setImageResource(R.drawable.white);
				blackImageViews[i].setTag("white");
			}
		}
	}
	
	public void updateCurrentScore(int white, int black){
		String whiteCount="";
		String blackCount="";
		whiteCount+=white;
		blackCount+=black;
		whiteScore.setText(whiteCount);
		blackScore.setText(blackCount);
	}

	public void updateStatusText(String statusText){
		infoText.setText(statusText);
	}
	
	public void gameOver(String endStatus){
		turnOffButtons();
		aiThinking.setVisibility(View.GONE);
		infoText.setText(endStatus);
	}
	// *******************************************************************
	
	// AI related functions **********************************************
	public void aiTurn(){
		clearValidPieces();
		turnOffButtons();
		aiThinking.setVisibility(View.VISIBLE);
		if (newBoard.gameOver == true) {
			newBoard.checkWinner();
		} else {
			if (playWithEasy == true){
				infoText.setText("> AI'S TURN...");
				easyMoveAi();
			} else if (playWithMedium == true){
				infoText.setText("> AI'S TURN...");
				mediumMoveAi();
			} else if (playWithHard == true){
				infoText.setText("> AI'S TURN...");
				hardMoveAi();
			} else if (playWithRandom == true){
				infoText.setText("> AI'S TURN...");
				randomMoveAi();
			} else if (playWithHuman == true){
				aiThinking.setVisibility(View.GONE);
				if (isWhite == true){
					//infoText.setText("> WHITE'S TURN...");
					turnOnButtons();
				} else {
					//infoText.setText("> BLACK'S TURN...");
					turnOnButtons();
				}
			}
		}
	}
	
	public void randomMoveAi(){
		delayAfterMove = 1500;
		if (trueWhenHumanIsBlack == true) {
			newBoard.player2 = newBoard.white;
		} else {
			newBoard.player2 = newBoard.black;
		}
		new Handler().postDelayed(new Runnable()
	    {
	        public void run()
	        {
	        	newBoard.aiRandomMove();
	        	aiThinking.setVisibility(View.GONE);
	        	if (newBoard.gameOver == true) {
	    			newBoard.checkWinner();
	    		} else {
	    			turnOnButtons();
	    		}
	        }
	    }, delayAfterMove);
	}
	
	public void easyMoveAi(){
		delayAfterMove = 1500;
		if (trueWhenHumanIsBlack == true) {
			newBoard.player2 = newBoard.white;
		} else {
			newBoard.player2 = newBoard.black;
		}
		new Handler().postDelayed(new Runnable()
	    {
	        public void run()
	        {
	        	newBoard.aiWorstMove();
	        	if (trueWhenHumanIsBlack == true) {
	    			newBoard.printValidMoves(newBoard.black);
	    			infoText.setText("> BLACK'S TURN...");
	    		} else {
	    			newBoard.printValidMoves(newBoard.white);
	    			infoText.setText("> WHITE'S TURN...");
	    		}
	        	aiThinking.setVisibility(View.GONE);
	        	if (newBoard.gameOver == true) {
	    			newBoard.checkWinner();
	        	} else {
	    			turnOnButtons();
	    		}
	        }
	    }, delayAfterMove);
	}
	
	public void mediumMoveAi(){
		delayAfterMove = 1500;
		if (trueWhenHumanIsBlack == true) {
			newBoard.player2 = newBoard.white;
		} else {
			newBoard.player2 = newBoard.black;
		}
		new Handler().postDelayed(new Runnable()
	    {
	        public void run()
	        {
	        	newBoard.aiMostFlips();
	        	if (trueWhenHumanIsBlack == true) {
	    			newBoard.printValidMoves(newBoard.black);
	    			infoText.setText("> BLACK'S TURN...");
	    		} else {
	    			newBoard.printValidMoves(newBoard.white);
	    			infoText.setText("> WHITE'S TURN...");
	    		}
	        	aiThinking.setVisibility(View.GONE);
	        	if (newBoard.gameOver == true) {
	    			newBoard.checkWinner();
	        	} else {
	    			turnOnButtons();
	    		}
	        }
	    }, delayAfterMove);
	}
	
	public void hardMoveAi(){
		delayAfterMove = 0;
		if (trueWhenHumanIsBlack == true) {
			newBoard.player2 = newBoard.white;
		} else {
			newBoard.player2 = newBoard.black;
		}
		new Handler().postDelayed(new Runnable()
	    {
	        public void run()
	        {
	        	newBoard.aiHardMove(newBoard.player2);
	        	if (trueWhenHumanIsBlack == true) {
	    			newBoard.printValidMoves(newBoard.black);
	    			infoText.setText("> BLACK'S TURN...");
	    		} else {
	    			newBoard.printValidMoves(newBoard.white);
	    			infoText.setText("> WHITE'S TURN...");
	    		}
	        	aiThinking.setVisibility(View.GONE);
	        	if (newBoard.gameOver == true) {
	    			newBoard.checkWinner();
	        	} else {
	    			turnOnButtons();
	    		}
	        }
	    }, delayAfterMove);
	}
	// *******************************************************************
}