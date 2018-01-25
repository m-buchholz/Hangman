package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplayerWord2 extends AppCompatActivity {

    public static final String PLAYER_NAME = "playerName";
    public static final String ENEMY_NAME = "enemyName";
    public static final String PLAYER_WORD = "playerWord";
    public static final String ENEMY_WORD = "enemyWord";
    public static final String GIB_EIN_WORT_MIT_WENIGER_ALS_9_BUCHSTABEN_EIN = "Gib ein Wort mit weniger als 9 Buchstaben ein!";
    public static final String GIB_EIN_WORT_MIT_MEHR_ALS_4_BUCHSTABEN_EIN = "Gib ein Wort mit mehr als 4 Buchstaben ein!";
    public static final String GIB_EIN_WORT_EIN = "Gib ein Wort ein!";
    public static final String EIN = " ein!";
    public static final String GIB_EIN_WORT_FÜR = ", gib ein Wort für ";
    Button startGame;
    EditText editMultiWord;
    TextView showActingPlayer;
    String playerName, enemyName, enemyWord, playerWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_word2);

        startGame = findViewById(R.id.buttonStartMPGame);
        editMultiWord = findViewById(R.id.editMultiWord);
        showActingPlayer = findViewById(R.id.showActingPlayer);

        //Namen und Wort abrufen
        playerName = getIntent().getExtras().getString(PLAYER_NAME);
        enemyName = getIntent().getExtras().getString(ENEMY_NAME);
        enemyWord = getIntent().getExtras().getString(ENEMY_WORD);

        showActingPlayer.setText(enemyName + GIB_EIN_WORT_FÜR + playerName + EIN);
    }

    public void startMPGame(View view) {
        playerWord = editMultiWord.getText().toString().toUpperCase();

        if (playerWord.equalsIgnoreCase("") || enemyWord.equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), GIB_EIN_WORT_EIN, Toast.LENGTH_LONG).show();
        }
        else if (playerWord.length() < 5) {
            Toast.makeText(getApplicationContext(), GIB_EIN_WORT_MIT_MEHR_ALS_4_BUCHSTABEN_EIN, Toast.LENGTH_LONG).show();
        }
        else if (playerWord.length() > 9) {
           Toast.makeText(getApplicationContext(), GIB_EIN_WORT_MIT_WENIGER_ALS_9_BUCHSTABEN_EIN, Toast.LENGTH_LONG).show();
        }
        else {
            Intent startGame = new Intent(this, MultiplayerGame.class);
            startGame.putExtra(ENEMY_WORD, enemyWord);
            startGame.putExtra(PLAYER_WORD, playerWord);
            startGame.putExtra(ENEMY_NAME, enemyName);
            startGame.putExtra(PLAYER_NAME, playerName);
            startActivity(startGame);
            finish();
        }


    }
}
