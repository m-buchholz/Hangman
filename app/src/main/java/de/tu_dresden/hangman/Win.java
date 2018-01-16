package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    String playerName;
    TextView notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        playerName = getIntent().getExtras().getString("playerName"); //Spielernamen importieren
        notice = (TextView) findViewById(R.id.win_notice);
        notice.setText("Herzlichen Glückwunsch "+playerName+", du hast gewonnen!");
    }
}
