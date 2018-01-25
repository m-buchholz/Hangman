package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    String playerName, word, tries;
    TextView notice;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        word = getIntent().getExtras().getString("word");
        playerName = getIntent().getExtras().getString("playerName"); //Spielernamen importieren
        tries = Integer.toString(getIntent().getExtras().getInt("tries"));

        notice = (TextView) findViewById(R.id.win_notice);
        shareButton = (Button) findViewById(R.id.share);

        notice.setText("Herzlichen Glückwunsch "+playerName+", du hast mit "+tries+" Versuchen gewonnen!");

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"Hangman");
                share.putExtra(Intent.EXTRA_TEXT,playerName + " hat  überlebt! \n" + "Geschafft nach: " + tries + " Versuchen. \n" + "Das Wort war: " + word );
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
