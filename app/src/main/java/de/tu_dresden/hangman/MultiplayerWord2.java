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
        playerName = getIntent().getExtras().getString("playerName");
        enemyName = getIntent().getExtras().getString("enemyName");
        enemyWord = getIntent().getExtras().getString("enemyWord");

        showActingPlayer.setText(enemyName + ", gib ein Wort für " + playerName + " ein!");
    }

    public void startMPGame(View view) {
        playerWord = editMultiWord.getText().toString().toUpperCase();

        if (playerWord.equalsIgnoreCase("") || enemyWord.equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "Gib ein Wort ein!", Toast.LENGTH_LONG).show();
        }
        else if (playerWord.length() < 5) {
            Toast.makeText(getApplicationContext(), "Gib ein Wort mit mehr als 4 Buchstaben ein!", Toast.LENGTH_LONG).show();
        }
        else if (playerWord.length() > 9) {
           Toast.makeText(getApplicationContext(), "Gib ein Wort mit weniger als 9 Buchstaben ein!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent startGame = new Intent(this, MultiplayerGame.class);
            startGame.putExtra("enemyWord", enemyWord);
            startGame.putExtra("playerWord", playerWord);
            startGame.putExtra("enemyName", enemyName);
            startGame.putExtra("playerName", playerName);
            startActivity(startGame);
            finish();
        }


    }
}
