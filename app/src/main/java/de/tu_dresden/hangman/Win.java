package de.tu_dresden.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;

public class Win extends AppCompatActivity {

    public static final String ZEIGE_ES_DEINEN_FREUNDEN = "Zeige es deinen Freunden";

    String playerName,scorePlayerString, scoreWordsString, scoreFalseWordsString;

    int passedWords, falseWords;

    TextView notice;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Globals g = Globals.getInstance();
        playerName = g.getPlayerName(); //Spielernamen importieren
        passedWords = g.getScore();  //hier ist die Anzahl der richtigen Worte drin bzw steckt in Globals und kann so aufgerufen werden (= Score)
        falseWords = g.getFalseWords();

        notice = findViewById(R.id.win_notice);
        shareButton = findViewById(R.id.share);

        notice.setText(playerName + ", du hast " + passedWords + " Wörter erraten. " + falseWords + " Wörter wurden falsch geraten.");

        SharedPreferences sharedPreferences = this.getSharedPreferences("de.tu_dresden.hangman", Context.MODE_PRIVATE);
        scorePlayerString = sharedPreferences.getString("scorePlayer", "/:/:/:/:/:/:/:/:/:/");
        scoreWordsString = sharedPreferences.getString("scoreWords","0:0:0:0:0:0:0:0:0:0");
        scoreFalseWordsString = sharedPreferences.getString("scoreFalseWords","0:0:0:0:0:0:0:0:0:0");

        String[] scorePlayer = scorePlayerString.split(":");
        //scorePlayer[0]; // this will contain "1":2:3:4:5
        //scorePlayer[1]; // this will contain 1:"2":3:4:5
        //scorePlayer[2]; // this will contain 1:2:"3":4:5
        String[] scoreWords = scoreWordsString.split(":");
        String[] scoreFalseWords = scoreFalseWordsString.split(":");

        //////////////////SCORESCHLEIFE//////////////////

        for (int i=0; i<=9; i++) { // Schleife um Score auf entsprechenden Platz zu setzen, bzw. Elemente auch nachzuruecken
            if (Integer.parseInt(scoreWords[i])<passedWords) {
                for (int r=9; r>0; r--){ //Elemente ruecken
                    scorePlayer[r]=scorePlayer[r-1];
                    scoreWords[r]=scoreWords[r-1];
                    scoreFalseWords[r]=scoreFalseWords[r-1];
                }

                scorePlayer[i] = playerName;
                scoreWords[i] = Integer.toString(passedWords);
                scoreFalseWords[i] = Integer.toString(falseWords);
                break;

            } else if (Integer.parseInt(scoreWords[i])==passedWords){
                if (Integer.parseInt(scoreFalseWords[i])>falseWords) {

                    for (int r=9; r>0; r--){ //Elemente ruecken
                        scorePlayer[r]=scorePlayer[r-1];
                        scoreWords[r]=scoreWords[r-1];
                        scoreFalseWords[r]=scoreFalseWords[r-1];
                    }

                    scorePlayer[i] = playerName;
                    scoreWords[i] = Integer.toString(passedWords);
                    scoreFalseWords[i] = Integer.toString(falseWords);
                    break;
                }
            }
        }

        //////////////////SCORESCHLEIFE//////////////////

        ///SAVE DATA///

        scorePlayerString = scorePlayer[0]+ ":" + scorePlayer[1] + ":" + scorePlayer[2] + ":" + scorePlayer[3] + ":" + scorePlayer[4] + ":" + scorePlayer[5] + ":" + scorePlayer[6] + ":" + scorePlayer[7] + ":" + scorePlayer[8] + ":" + scorePlayer[9];
        scoreWordsString = scoreWords[0]+ ":" + scoreWords[1] + ":" + scoreWords[2] + ":" + scoreWords[3] + ":" + scoreWords[4] + ":" + scoreWords[5] + ":" + scoreWords[6] + ":" + scoreWords[7] + ":" + scoreWords[8] + ":" + scoreWords[9];
        scoreFalseWordsString = scoreFalseWords[0]+ ":" + scoreFalseWords[1] + ":" + scoreFalseWords[2] + ":" + scoreFalseWords[3] + ":" + scoreFalseWords[4] + ":" + scoreFalseWords[5] + ":" + scoreFalseWords[6] + ":" + scoreFalseWords[7] + ":" + scoreFalseWords[8] + ":" + scoreFalseWords[9];

        sharedPreferences.edit().putString("scorePlayer", scorePlayerString).apply();
        sharedPreferences.edit().putString("scoreWords", scoreWordsString).apply();
        sharedPreferences.edit().putString("scoreFalseWords", scoreFalseWordsString).apply();

        /////////////////////////////////////////////////////

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Hangman");
                share.putExtra(Intent.EXTRA_TEXT,playerName + " hat " + passedWords + " Wörter erraten. " + falseWords + " Wörter wurden falsch geraten.");
                startActivity(Intent.createChooser(share, ZEIGE_ES_DEINEN_FREUNDEN));
            }
        });
    }

    public void openSingleplayer(View view){
        Intent singleplayer = new Intent(this, Singleplayer.class);
        startActivity(singleplayer);
        finish();
    }

    public void finish(View view){
        finish();
    }
}