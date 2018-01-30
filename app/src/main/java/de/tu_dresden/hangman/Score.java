package de.tu_dresden.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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

    public static final String PLATZ_10 ="PLATZ 10: ";
    public static final String PLATZ_9 = "PLATZ 9: ";
    public static final String PLATZ_8 = "PLATZ 8: ";
    public static final String PLATZ_7 = "PLATZ 7: ";
    public static final String PLATZ_6 = "PLATZ 6: ";
    public static final String PLATZ_5 = "PLATZ 5: ";
    public static final String PLATZ_4 = "PLATZ 4: ";
    public static final String PLATZ_3 = "PLATZ 3: ";
    public static final String PLATZ_2 = "PLATZ 2: ";
    public static final String PLATZ_1 = "PLATZ 1: ";
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
                PLATZ_1 + scorePlayer[0] + " - " + scoreWords[0] + " Richtige und " + scoreFalseWords[0] + " Falsche",
                PLATZ_2 + scorePlayer[1] + " - " + scoreWords[1] + " Richtige und " + scoreFalseWords[1] + " Falsche",
                PLATZ_3 + scorePlayer[2] + " - " + scoreWords[2] + " Richtige und " + scoreFalseWords[2] + " Falsche",
                PLATZ_4 + scorePlayer[3] + " - " + scoreWords[3] + " Richtige und " + scoreFalseWords[3] + " Falsche",
                PLATZ_5 + scorePlayer[4] + " - " + scoreWords[4] + " Richtige und " + scoreFalseWords[4] + " Falsche",
                PLATZ_6 + scorePlayer[5] + " - " + scoreWords[5] + " Richtige und " + scoreFalseWords[5] + " Falsche",
                PLATZ_7 + scorePlayer[6] + " - " + scoreWords[6] + " Richtige und " + scoreFalseWords[6] + " Falsche",
                PLATZ_8 + scorePlayer[7] + " - " + scoreWords[7] + " Richtige und " + scoreFalseWords[7] + " Falsche",
                PLATZ_9 + scorePlayer[8] + " - " + scoreWords[8] + " Richtige und " + scoreFalseWords[8] + " Falsche",
                PLATZ_10 + scorePlayer[9] + " - " + scoreWords[9] + " Richtige und " + scoreFalseWords[9] + " Falsche",
        };

        Scoreboard = findViewById(R.id.Scoreboard);
        Scoreboard.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scorearray));
    }
}
