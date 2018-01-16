package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplayerWord extends AppCompatActivity {

    Button startGame;
    EditText editMultiWord;
    TextView showActingPlayer;
    String playerName, enemyName, enemyWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_word);

        startGame = (Button)findViewById(R.id.buttonStartMPGame);
        editMultiWord = (EditText)findViewById(R.id.editMultiWord);
        showActingPlayer = (TextView)findViewById(R.id.showActingPlayer);

        playerName = getIntent().getExtras().getString("playerName");
        enemyName = getIntent().getExtras().getString("enemyName");
        showActingPlayer.setText(playerName + ", gib ein Wort für " + enemyName + " ein!");
    }

    public void startMPGame(View view){
        enemyWord = editMultiWord.getText().toString();

        if(enemyWord.equalsIgnoreCase("") || enemyWord.equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "Gib ein Wort ein!", Toast.LENGTH_LONG).show();
        }
        else if(enemyWord.length() < 5){
            Toast.makeText(getApplicationContext(),"Gib ein Wort mit mehr als 4 Buchstaben ein!",Toast.LENGTH_LONG).show();
        }
        else if(enemyWord.length() > 9){
            Toast.makeText(getApplicationContext(),"Gib ein Wort mit weniger als 9 Buchstaben ein!",Toast.LENGTH_LONG).show();
        }
        else {
            Intent startMPWord2 = new Intent(this, MultiplayerWord2.class);
            startMPWord2.putExtra("enemyWord", enemyWord);
            startMPWord2.putExtra("playerName", playerName);
            startMPWord2.putExtra("enemyName", enemyName);
            startActivity(startMPWord2);
            finish();
        }
    }
}
