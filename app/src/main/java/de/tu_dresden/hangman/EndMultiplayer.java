package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EndMultiplayer extends AppCompatActivity {

    String playerName, enemyName, playerWord, enemyWord;
    int triesEnemy, triesPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_multiplayer);

        //Alle Infos von zuvor holen
        playerName = getIntent().getExtras().getString("playerName");
        enemyName = getIntent().getExtras().getString("enemyName");
        playerWord = getIntent().getExtras().getString("playerWord");
        enemyWord = getIntent().getExtras().getString("enemyWord");
        triesEnemy = getIntent().getExtras().getInt("triesEnemy");
        triesPlayer = getIntent().getExtras().getInt("triesPlayer");
    }
}
