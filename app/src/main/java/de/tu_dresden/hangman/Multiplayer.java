package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Multiplayer extends AppCompatActivity {

    public static final String ENEMY_NAME = "enemyName";
    public static final String PLAYER_NAME = "playerName";
    public static final String GIB_ZWEI_GAMERTAGS_EIN = "Gib zwei Gamertags ein!";
    Button start;
    EditText playerName,enemyName;
    String StringplayerName, StringenemyName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        start = findViewById(R.id.buttonStartMP);
        playerName = findViewById(R.id.editPlayerNameMP);
        enemyName = findViewById(R.id.editEnemyName);

        if (getIntent().hasExtra(PLAYER_NAME) && getIntent().hasExtra(ENEMY_NAME)){ //wenn bereits gespielt -> trage letzte Namen in EditText ein
            StringplayerName = getIntent().getExtras().getString(PLAYER_NAME);
            playerName.setText(StringplayerName);
            StringenemyName = getIntent().getExtras().getString(ENEMY_NAME);
            enemyName.setText(StringenemyName);
        }
    }

    public void startMPWord(View view){
        if(playerName.getText().toString().isEmpty() == true || enemyName.getText().toString().isEmpty() == true){
            Toast.makeText(getApplicationContext(), GIB_ZWEI_GAMERTAGS_EIN,Toast.LENGTH_LONG).show(); //Fehlermeldung wenn kein Name eingegeben
        }
        else{
            StringplayerName = playerName.getText().toString();
            StringenemyName = enemyName.getText().toString();
            Intent multiplayer_word = new Intent(this, MultiplayerWord.class);
            multiplayer_word.putExtra(PLAYER_NAME, StringplayerName);
            multiplayer_word.putExtra(ENEMY_NAME, StringenemyName);
            startActivity(multiplayer_word);
            finish();
        }



    }
}
