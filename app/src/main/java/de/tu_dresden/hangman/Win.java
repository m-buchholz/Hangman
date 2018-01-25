package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    public static final String PLAYER_NAME = "playerName";
    public static final String ZEIGE_ES_DEINEN_FREUNDEN = "Zeige es deinen Freunden";
    public static final String DAS_WORT_WAR = "Das Wort war: ";
    public static final String FEHLVERSUCHEN = " Fehlversuchen. \n";
    public static final String GESCHAFFT_NACH = "Geschafft nach ";
    public static final String HAT_ÜBERLEBT = " hat überlebt! \n";
    public static final String HANGMAN = "Hangman";
    public static final String TEXT_PLAIN = "text/plain";
    public static final String FEHLVERSUCHEN_GEWONNEN = " Fehlversuchen gewonnen!";
    public static final String DU_HAST_MIT = ", du hast mit ";
    public static final String HERZLICHEN_GLÜCKWUNSCH = "Herzlichen Glückwunsch ";
    public static final String TRIES = "tries";
    public static final String WORD = "word";
    String playerName, word, tries;
    TextView notice;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        word = getIntent().getExtras().getString(WORD);
        playerName = getIntent().getExtras().getString(PLAYER_NAME); //Spielernamen importieren
        tries = Integer.toString(getIntent().getExtras().getInt(TRIES));

        notice = findViewById(R.id.win_notice);
        shareButton = findViewById(R.id.share);

        notice.setText(HERZLICHEN_GLÜCKWUNSCH +playerName+ DU_HAST_MIT +tries+ FEHLVERSUCHEN_GEWONNEN);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType(TEXT_PLAIN);
                share.putExtra(Intent.EXTRA_SUBJECT, HANGMAN);
                share.putExtra(Intent.EXTRA_TEXT,playerName + HAT_ÜBERLEBT + GESCHAFFT_NACH + tries + FEHLVERSUCHEN + DAS_WORT_WAR + word );
                startActivity(Intent.createChooser(share, ZEIGE_ES_DEINEN_FREUNDEN));
            }
        });
    }

    public void openSingleplayer(View view){
        Intent singleplayer = new Intent(this, Singleplayer.class);
        singleplayer.putExtra(PLAYER_NAME, playerName);
        startActivity(singleplayer);
        finish();
    }

    public void finish(View view){
        finish();
    }
}
