package de.tu_dresden.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Singleplayer extends AppCompatActivity {

    public static final String GIB_DEINEN_GAMERTAG_EIN = "Gib deinen Gamertag ein!";
    public static final String PLAYER_NAME = "playerName";
    Button start;
    EditText name;
    String playerName;
    MediaPlayer hintergr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        start = findViewById(R.id.buttonStartSP);
        name = findViewById(R.id.editPlayerNameSP);
        hintergr = MediaPlayer.create(this, R.raw.hintergr); //Hintergrund musik

        if (getIntent().hasExtra(PLAYER_NAME)) {
            playerName = getIntent().getExtras().getString(PLAYER_NAME);
            name.setText(playerName);
        }
    }

    public void startSPGame(View view){
        if(name.getText().toString().isEmpty() == false){
            Globals g = Globals.getInstance();
            g.setScore(0);
            g.setFalseWords(0);
            g.setTime(120);
            playerName = name.getText().toString();
            Intent startSPGame = new Intent(this, SingleplayerGame.class);
            startSPGame.putExtra(PLAYER_NAME, playerName);
            startActivity(startSPGame);
            hintergr.start();
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), GIB_DEINEN_GAMERTAG_EIN,Toast.LENGTH_LONG).show(); //Fehlermeldung wenn kein Name eingegeben
        }
    }
}
