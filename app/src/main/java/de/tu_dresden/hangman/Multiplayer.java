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

        start = (Button)findViewById(R.id.buttonStartMP);
        playerName = (EditText)findViewById(R.id.editPlayerNameMP);
        enemyName = (EditText)findViewById(R.id.editEnemyName);
    }

    public void startMPWord(View view){
        StringplayerName = playerName.getText().toString();
        StringenemyName = enemyName.getText().toString();
        if(StringplayerName.equalsIgnoreCase("") || StringenemyName.equalsIgnoreCase("")){
            Toast.makeText(getApplicationContext(),"Gib Gamertags ein!",Toast.LENGTH_LONG).show(); //Fehlermeldung wenn kein Name eingegeben
        }
        else{
            Intent multiplayer_word = new Intent(this, MultiplayerWord.class);
            multiplayer_word.putExtra("playerName", StringplayerName);
            multiplayer_word.putExtra("enemyName", StringenemyName);
            startActivity(multiplayer_word);
            finish();
        }



    }
}
