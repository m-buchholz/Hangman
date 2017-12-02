package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Singleplayer_Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer__game);

        Intent intent = getIntent();
        //get the single player name, save in playerName
        String playerName = intent.getStringExtra(Singleplayer.EXTRA_PLAYERNAME);
    }
}
