package de.tu_dresden.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.*;

public class MainMenu extends AppCompatActivity {

    MediaPlayer soundTest;

    Button singleplayer;
    Button multiplayer;
    Button score;
    Button credits;

    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        singleplayer = findViewById(R.id.buttonSingle);
        multiplayer = findViewById(R.id.buttonMulti);
        score = findViewById(R.id.buttonScore);
        credits = findViewById(R.id.buttonCredits);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void openSingleplayer(View view){
        Intent singleplayer = new Intent(this, Singleplayer.class);
        startActivity(singleplayer);
    }

    public void openMultiplayer(View view){
        Intent multiplayer = new Intent(this, Multiplayer.class);
        startActivity(multiplayer);
    }

    public void openScore(View view){
        Intent score = new Intent(this, Score.class);
        startActivity(score);
    }

    public void openCredits(View view){
        Intent credits = new Intent(this, Credits.class);
        startActivity(credits);
    }
}
