package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends AppCompatActivity {

    String playerName, word;
    int tries;
    TextView notice;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        word = getIntent().getExtras().getString("word");
        playerName = getIntent().getExtras().getString("playerName");
        tries = getIntent().getExtras().getInt("tries");

        notice = (TextView) findViewById(R.id.lose_notice);
        shareButton = (Button) findViewById(R.id.share);

        notice.setText("Du hast leider, mit "+Integer.toString(tries)+" Versuchen, verloren, "+playerName+".");

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"Hangman");
                String counter = "Verloren nach: " + Integer.toString(tries);
                String platzhalter = "                                              ";
                String result = " wurde erhängt!";
                share.putExtra(Intent.EXTRA_TEXT,"" + playerName + result + platzhalter + counter /*+ Versuchen*/+ " Versuchen." + platzhalter + "Das Wort war: " + word );
                startActivity(Intent.createChooser(share, "Zeige es deinen Freunden"));
            }
        });
    }

    public void openSingleplayer(View view){
        Intent singleplayer = new Intent(this, Singleplayer.class);
        startActivity(singleplayer);
        finish();
    }

    public void finish(View view){
        finish();
    }
}
