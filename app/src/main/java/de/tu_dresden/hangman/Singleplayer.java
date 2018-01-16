package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Singleplayer extends AppCompatActivity {

    Button start;
    EditText gamertag;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        start = (Button)findViewById(R.id.buttonStartSP);
        gamertag = (EditText)findViewById(R.id.editPlayerNameSP);
    }

    public void startSPGame(View view){
        if (gamertag.getText().toString().isEmpty() == false) { //Wenn ein Name eingegeben wird, gehts weiter
            playerName = gamertag.getText().toString();
            Intent startSPGame = new Intent(this, SingleplayerGame.class);
            startSPGame.putExtra("playerName", playerName);
            startActivity(startSPGame);
            finish(); //Activity schließen (wenn Spiel gestartet wird)
        }
        else { //sonst Fehlermeldung
            Toast.makeText(getApplicationContext(), "Gib einen Gamertag ein!", Toast.LENGTH_LONG).show();
        }
    }
}
