package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Singleplayer extends AppCompatActivity {

    Button start;
    EditText playerName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        start = (Button)findViewById(R.id.buttonStartSP);
        playerName = (EditText)findViewById(R.id.editPlayerNameSP);
    }

    public void startSPGame(View view){
        name = playerName.getText().toString();
        Intent startSPGame = new Intent(this, SingleplayerGame.class);
        startSPGame.putExtra("name", name);
        startActivity(startSPGame);
        finish(); //Activity schließen (wenn Spiel gestartet wird)
    }
}
