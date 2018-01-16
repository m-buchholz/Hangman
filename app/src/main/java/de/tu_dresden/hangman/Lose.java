package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Lose extends AppCompatActivity {

    String playerName;
    TextView notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        playerName = getIntent().getExtras().getString("name");
        notice = (TextView) findViewById(R.id.lose_notice);
        notice.setText("Du hast leider verloren, "+playerName+"!");
    }
}
