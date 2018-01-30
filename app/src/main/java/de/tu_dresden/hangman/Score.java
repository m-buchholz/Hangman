package de.tu_dresden.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
* zuerst Objekt der Klasse Gobals erzeugen, keine Ahnung was genua bei getInstance() vorgeht, es funktioniert;):
*
* Globals g = Globals.getInstance();
*
* dann, um Score zu bekommen:
*
* int VarName = g.getScore(123);
*
* um ihn zu setzen
*
* g.setScore();
*
* Analog mit falschen Wörtern (hab ich auch schon mit bei SingleplayeeGame rein, sollte funktionieren):
*
* int VarName = g.getFalseWords();
*
* g.setFalseWords(123);
*
* Um Name zu setzen (muss noch in Singleplayer gemacht werden)
*
* g.setPlayerName("Hans");
*
* und um ihn zu bekommen
*
* String VaribaleName = g.getPlayerName();
*
* ScoreArray global setzen:
*
* g.setScorePlayer(yourArray);
*
* und bekommen
*
* String[] arrayName = g.getScorePlayer();
*
* analog mit allen anderen: setScoreWords, getScoreWords, setScoreFalseWords, getScoreFalseWords
* */

public class Score extends AppCompatActivity {

    public static final String PLATZ_10 = "Platz 10: ";
    public static final String PLATZ_9 = "Platz 9: ";
    public static final String PLATZ_8 = "Platz 8: ";
    public static final String PLATZ_7 = "Platz 7: ";
    public static final String PLATZ_6 = "Platz 6: ";
    public static final String PLATZ_5 = "Platz 5: ";
    public static final String PLATZ_4 = "Platz 4: ";
    public static final String PLATZ_3 = "Platz 3: ";
    public static final String PLATZ_2 = "Platz 2: ";
    public static final String PLATZ_1 = "Platz 1: ";
    ListView Scoreboard;

    String scorePlayerString, scoreWordsString, scoreFalseWordsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences sharedPreferences = this.getSharedPreferences("de.tu_dresden.hangman", Context.MODE_PRIVATE);
        scorePlayerString = sharedPreferences.getString("scorePlayer", "-:-:-:-:-:-:-:-:-:-");
        scoreWordsString = sharedPreferences.getString("scoreWords","-:-:-:-:-:-:-:-:-:-");
        scoreFalseWordsString = sharedPreferences.getString("scoreFalseWords","-:-:-:-:-:-:-:-:-:-");

        String[] scorePlayer = scorePlayerString.split(":");
        //scorePlayer[0]; // this will contain "1":2:3:4:5
        //scorePlayer[1]; // this will contain 1:"2":3:4:5
        //scorePlayer[2]; // this will contain 1:2:"3":4:5
        String[] scoreWords = scoreWordsString.split(":");
        String[] scoreFalseWords = scoreFalseWordsString.split(":");

        String[] scorearray = {
                PLATZ_1 + scorePlayer[0] + " mit " + scoreWords[0] + " Richtigen und " + scoreFalseWords[0] + " Falschen",
                PLATZ_2 + scorePlayer[1] + " mit " + scoreWords[1] + " Richtigen und " + scoreFalseWords[1] + " Falschen",
                PLATZ_3 + scorePlayer[2] + " mit " + scoreWords[2] + " Richtigen und " + scoreFalseWords[2] + " Falschen",
                PLATZ_4 + scorePlayer[3] + " mit " + scoreWords[3] + " Richtigen und " + scoreFalseWords[3] + " Falschen",
                PLATZ_5 + scorePlayer[4] + " mit " + scoreWords[4] + " Richtigen und " + scoreFalseWords[4] + " Falschen",
                PLATZ_6 + scorePlayer[5] + " mit " + scoreWords[5] + " Richtigen und " + scoreFalseWords[5] + " Falschen",
                PLATZ_7 + scorePlayer[6] + " mit " + scoreWords[6] + " Richtigen und " + scoreFalseWords[6] + " Falschen",
                PLATZ_8 + scorePlayer[7] + " mit " + scoreWords[7] + " Richtigen und " + scoreFalseWords[7] + " Falschen",
                PLATZ_9 + scorePlayer[8] + " mit " + scoreWords[8] + " Richtigen und " + scoreFalseWords[8] + " Falschen",
                PLATZ_10 + scorePlayer[9] + " mit " + scoreWords[9] + " Richtigen und " + scoreFalseWords[9] + " Falschen",
        };

        Scoreboard = findViewById(R.id.Scoreboard);
        Scoreboard.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scorearray));
    }
}
