package de.tu_dresden.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
Zuerst Objekte der Klasse Globals erzeugen:
Globals g = Globals.getInstance();

Score lesen:
int VarName = g.getScore(123);
Score Setzen:
g.setScore();

Analog mit falschen Woertern:
int VarName = g.getFalseWords();
g.setFalseWords(123);

Namen setzen:
g.setPlayerName("Hans");
Namen lesen:*
String VaribaleName = g.getPlayerName();
*/


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

        Scoreboard = findViewById(R.id.Scoreboard);

        //gespeicherte Werte-Verkettung auslesen
        SharedPreferences sharedPreferences = this.getSharedPreferences("de.tu_dresden.hangman", Context.MODE_PRIVATE);
        scorePlayerString = sharedPreferences.getString("scorePlayer", "/:/:/:/:/:/:/:/:/:/");
        scoreWordsString = sharedPreferences.getString("scoreWords","-:-:-:-:-:-:-:-:-:-");
        scoreFalseWordsString = sharedPreferences.getString("scoreFalseWords","-:-:-:-:-:-:-:-:-:-");

        //verkettete Werte in die unterschiedlichen Arrays zerlegen
        String[] scorePlayer = scorePlayerString.split(":");
        //scorePlayer[0]; // this will contain "1":2:3:4:5
        //scorePlayer[1]; // this will contain 1:"2":3:4:5
        //scorePlayer[2]; // this will contain 1:2:"3":4:5
        String[] scoreWords = scoreWordsString.split(":");
        String[] scoreFalseWords = scoreFalseWordsString.split(":");

        //Werte geordnet nach Plaetzen in ein Score-Array zusammenfassen zur Ausgabe
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

        //Score-Array in der ListView ausgeben
        Scoreboard.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scorearray));
    }
}
