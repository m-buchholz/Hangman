package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Multiplayer_Word_Player2 extends AppCompatActivity {
    public static final String EXTRA_PLAYERN = "de.tu-dresden.hangman.PLAYERN";
    public static final String EXTRA_ENEMYN= "de.tu-dresden.hangman.ENEMYN";
    public static final String EXTRA_WORDENEMY= "de.tu-dresden.hangman.WORDENEMY";
    public static final String EXTRA_WORDPLAYER= "de.tu-dresden.hangman.WORDPLAYER";

    String playerName, enemyName, wordenemy, wordplayer;

    Button Button_start;
    TextView tv_playerName;
    EditText et_playerWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer__word__player2);

        Button_start = (Button)findViewById(R.id.button_startGame);
        tv_playerName = (TextView)findViewById(R.id.textView_Player);
        et_playerWord = (EditText)findViewById(R.id.editText_wordplayer);

        Intent intent = getIntent();
        //get the player names and the word for enemy, display name of player
        playerName = intent.getStringExtra(Multiplayer_Word_Player1.EXTRA_PLAYERN);
        enemyName = intent.getStringExtra(Multiplayer_Word_Player1.EXTRA_ENEMYN);
        wordenemy = intent.getStringExtra(Multiplayer_Word_Player1.EXTRA_WORDENEMY);

        tv_playerName.setText(playerName);
    }

    //start the game, pass the names of the players and their words
    public void startGame(View view){
        Intent startMPGame = new Intent(this, Multiplayer_Game.class);

        wordplayer = et_playerWord.getText().toString();

        startMPGame.putExtra(EXTRA_PLAYERN, playerName);
        startMPGame.putExtra(EXTRA_WORDPLAYER,wordplayer);
        startMPGame.putExtra(EXTRA_ENEMYN, enemyName);
        startMPGame.putExtra(EXTRA_WORDENEMY, wordenemy);

        startActivity(startMPGame);
    }
}
