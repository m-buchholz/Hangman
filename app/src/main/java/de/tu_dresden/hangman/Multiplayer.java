package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Multiplayer extends AppCompatActivity {

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

        if (getIntent().hasExtra("playerName") && getIntent().hasExtra("enemyName")){ //wenn bereits gespielt -> trage letzte Namen in EditText ein
            StringplayerName = getIntent().getExtras().getString("playerName");
            playerName.setText(StringplayerName);
            StringenemyName = getIntent().getExtras().getString("enemyName");
            enemyName.setText(StringenemyName);
        }
    }

    public void startMPWord(View view){
        if(playerName.getText().toString().isEmpty() == true || enemyName.getText().toString().isEmpty() == true){
            Toast.makeText(getApplicationContext(),"Gib zwei Gamertags ein!",Toast.LENGTH_LONG).show(); //Fehlermeldung wenn kein Name eingegeben
        }
        else{
            StringplayerName = playerName.getText().toString();
            StringenemyName = enemyName.getText().toString();
            Intent multiplayer_word = new Intent(this, MultiplayerWord.class);
            multiplayer_word.putExtra("playerName", StringplayerName);
            multiplayer_word.putExtra("enemyName", StringenemyName);
            startActivity(multiplayer_word);
            finish();
        }



    }
}
