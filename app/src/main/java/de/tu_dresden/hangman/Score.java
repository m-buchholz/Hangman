package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Score extends AppCompatActivity {

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
            "Platz 1: "+scoreentry[0],
            "Platz 2: "+scoreentry[1],
            "Platz 3: "+scoreentry[2],
            "Platz 4: "+scoreentry[3],
            "Platz 5: "+scoreentry[4],
            "Platz 6: "+scoreentry[5],
            "Platz 7: "+scoreentry[6],
            "Platz 8: "+scoreentry[7],
            "Platz 9: "+scoreentry[8],
            "Platz 10: "+scoreentry[9],
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Scoreboard = (ListView) findViewById(R.id.Scoreboard);
        Scoreboard.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scorearray));
    }
}
