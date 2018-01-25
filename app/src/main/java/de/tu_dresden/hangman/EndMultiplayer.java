package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndMultiplayer extends AppCompatActivity {

    public static final String PLAYER_NAME = "playerName";
    public static final String UNENTSCHIEDEN = "Unentschieden!";
    public static final String FEHLVERSUCHEN = " Fehlversuchen!";
    public static final String ZU = " zu ";
    public static final String GEWONNEN_MIT = " gewonnen, mit ";
    public static final String HAT_GEGEN = " hat gegen ";
    public static final String TRIES_PLAYER = "triesPlayer";
    public static final String TRIES_ENEMY = "triesEnemy";
    public static final String ENEMY_WORD = "enemyWord";
    public static final String PLAYER_WORD = "playerWord";
    public static final String ENEMY_NAME = "enemyName";
    TextView whoWins;

    String playerName, enemyName, playerWord, enemyWord;
    int triesEnemy, triesPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_multiplayer);

        whoWins = findViewById(R.id.textViewWinner);

        //Alle Infos von zuvor holen
        playerName = getIntent().getExtras().getString(PLAYER_NAME);
        enemyName = getIntent().getExtras().getString(ENEMY_NAME);
        playerWord = getIntent().getExtras().getString(PLAYER_WORD);
        enemyWord = getIntent().getExtras().getString(ENEMY_WORD);
        triesEnemy = getIntent().getExtras().getInt(TRIES_ENEMY);
        triesPlayer = getIntent().getExtras().getInt(TRIES_PLAYER);

        if(triesEnemy < triesPlayer){
            whoWins.setText(enemyName + HAT_GEGEN + playerName + GEWONNEN_MIT + triesEnemy + ZU + triesPlayer + FEHLVERSUCHEN);
        }
        else if (triesPlayer < triesEnemy){
            whoWins.setText(playerName + HAT_GEGEN + enemyName + GEWONNEN_MIT + triesPlayer + ZU + triesEnemy + FEHLVERSUCHEN);
        }
        else if (triesPlayer == triesEnemy){
            whoWins.setText(UNENTSCHIEDEN);
        }
    }

    public void endGame(View view){
        finish();
    }

    public void playAgain(View view){
        Intent MPGame = new Intent(this, Multiplayer.class);
        MPGame.putExtra(PLAYER_NAME, playerName);
        MPGame.putExtra(ENEMY_NAME, enemyName);
        startActivity(MPGame);
        finish();
    }
}
