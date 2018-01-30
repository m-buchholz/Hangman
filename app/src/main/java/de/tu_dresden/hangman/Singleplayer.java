package de.tu_dresden.hangman;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class Singleplayer extends AppCompatActivity {

    public static final String GIB_DEINEN_GAMERTAG_EIN = "Gib deinen Gamertag ein!";
    public static final String PLAYER_NAME = "playerName";

    Button start;
    EditText name;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        start = findViewById(R.id.buttonStartSP);
        name = findViewById(R.id.editPlayerNameSP);

        //Spielernamen aus dem Speicher lesen, ansonsten leer lassen
        SharedPreferences sharedPreferences = this.getSharedPreferences("de.tu_dresden.hangman", Context.MODE_PRIVATE);
        playerName = sharedPreferences.getString("player", "");
        name.setText(playerName);
    }

    public void startSPGame(View view){
        if(name.getText().toString().isEmpty() == false){ //Wenn EditText leer eine Fehlermeldung ausgeben
            //globale Variablen zuruecksetzen
            Globals g = Globals.getInstance();
            g.setScore(0);
            g.setFalseWords(0);
            g.setTime(120); // ZUM TESTEN

            //Spielernamen aus dem TextEdit lesen
            playerName = name.getText().toString();

            //Spielernamen persistent speichern
            SharedPreferences sharedPreferences = this.getSharedPreferences("de.tu_dresden.hangman", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("player", playerName).apply();

            //Spielernamen als globale Variable uebernehmen
            g.setPlayerName(playerName);

            //Spiel starten und diese Activity beenden
            Intent startSPGame = new Intent(this, SingleplayerGame.class);
            startSPGame.putExtra(PLAYER_NAME, playerName);
            startActivity(startSPGame);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), GIB_DEINEN_GAMERTAG_EIN,Toast.LENGTH_LONG).show(); //Fehlermeldung wenn kein Name eingegeben wurde
        }
    }
}
