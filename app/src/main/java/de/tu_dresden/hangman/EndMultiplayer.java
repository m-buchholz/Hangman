package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndMultiplayer extends AppCompatActivity {

    TextView whoWins;

    String playerName, enemyName, playerWord, enemyWord;
    int triesEnemy, triesPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_multiplayer);

        whoWins = (TextView) findViewById(R.id.textViewWinner);

        //Alle Infos von zuvor holen
        playerName = getIntent().getExtras().getString("playerName");
        enemyName = getIntent().getExtras().getString("enemyName");
        playerWord = getIntent().getExtras().getString("playerWord");
        enemyWord = getIntent().getExtras().getString("enemyWord");
        triesEnemy = getIntent().getExtras().getInt("triesEnemy");
        triesPlayer = getIntent().getExtras().getInt("triesPlayer");

        if(triesEnemy < triesPlayer){
            whoWins.setText(enemyName + " hat gegen " + playerName + " gewonnen!" );
        }
        else if (triesPlayer < triesEnemy){
            whoWins.setText(playerName + " hat gegen " + enemyName + " gewonnen!");
        }
        else if (triesPlayer == triesEnemy){
            whoWins.setText("Unentschieden!");
        }
    }

    public void endGame(View view){
        finish();
    }

    public void playAgain(View view){
        Intent MPGame = new Intent(this, Multiplayer.class);
        startActivity(MPGame);
        finish();
    }
}
