package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    public String[] scoreentry = { //Spielername, Score
            "-", //Platz 1
            "-", //Platz 2
            "-", //Platz 3
            "-", //Platz 4
            "-", //Platz 5
            "-", //Platz 6
            "-", //Platz 7
            "-", //Platz 8
            "-", //Platz 9
            "-", //Platz 10
    };

    String[] scorearray = {
            PLATZ_1 +scoreentry[0],
            PLATZ_2 +scoreentry[1],
            PLATZ_3 +scoreentry[2],
            PLATZ_4 +scoreentry[3],
            PLATZ_5 +scoreentry[4],
            PLATZ_6 +scoreentry[5],
            PLATZ_7 +scoreentry[6],
            PLATZ_8 +scoreentry[7],
            PLATZ_9 +scoreentry[8],
            PLATZ_10 +scoreentry[9],
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Scoreboard = (ListView) findViewById(R.id.Scoreboard);
        Scoreboard.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scorearray));
    }
}
