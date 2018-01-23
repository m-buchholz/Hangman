package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    String playerName, word;
    TextView notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        word = getIntent().getExtras().getString("word");
        playerName = getIntent().getExtras().getString("playerName"); //Spielernamen importieren
        notice = (TextView) findViewById(R.id.win_notice);
        notice.setText("Herzlichen Glückwunsch "+playerName+", du hast gewonnen!");

        Button button = (Button) findViewById(R.id.share);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"Hangman");
                String counter = "Geschafft nach: ";
                String platzhalter = "                                              ";
                String result = " hat überlebt!";
                String player = playerName;
                share.putExtra(Intent.EXTRA_TEXT,"" + player + result + platzhalter + counter /*+ Versuchen*/+ "Versuchen." + platzhalter + "Das Wort war: " + word );
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
