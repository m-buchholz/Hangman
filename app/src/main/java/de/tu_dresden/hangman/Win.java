package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    public static final String ZEIGE_ES_DEINEN_FREUNDEN = "Zeige es deinen Freunden";
    public static final String DAS_WORT_WAR = "Das Wort war: ";
    public static final String FEHLVERSUCHEN = " Fehlversuch(en). \n";
    public static final String GESCHAFFT_NACH = "Geschafft nach ";
    public static final String HAT_ÜBERLEBT = " hat überlebt! \n";
    public static final String HERZLICHEN_GLÜCKWUNSCH = "Herzlichen Glückwunsch ";
    public static final String PASSED_WORDS = "passedWords";

    String playerName, triesString;
    int tries, passedWords;

    TextView notice;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        playerName = getIntent().getExtras().getString(playerName); //Spielernamen importieren
        passedWords = getIntent().getExtras().getInt(PASSED_WORDS);

        notice = findViewById(R.id.win_notice);
        shareButton = findViewById(R.id.share);

        Globals g = Globals.getInstance();

        //hier ist die Anzahl der richtigen Worte drin bzw steckt in Globals und kann so aufgerufen werden (= Score)
        int richtigeWorte = g.getScore();
        String[] scorePlayer = g.getScorePlayer();
        int[] scoreWords = g.getScoreWords();
        int[] scoreFalseWords = g.getScoreFalseWords();


        notice.setText(HERZLICHEN_GLÜCKWUNSCH + " du hast " + richtigeWorte + " Wörter richtig erraten.");

        //////////////////SCORESCHLEIFE//////////////////

        for (int i=0; i<=9; i++) { // Schleife um Score auf entsprechenden Platz zu setzen, bzw. Elemente auch nachzuruecken
            if (scoreWords[i]<passedWords) {
                for (int r=9; r>0; r--){ //Elemente ruecken
                    scorePlayer[r]=scorePlayer[r-1];
                    scoreWords[r]=scoreWords[r-1];
                    scoreFalseWords[r]=scoreFalseWords[r-1];
                }

                scorePlayer[i] = playerName;
                scoreWords[i] = passedWords;
                scoreFalseWords[i] = tries;

            } else if (scoreWords[i]==passedWords){
                if (scoreFalseWords[i]>tries) {

                    for (int r=9; r>0; r--){ //Elemente ruecken
                        scorePlayer[r]=scorePlayer[r-1];
                        scoreWords[r]=scoreWords[r-1];
                        scoreFalseWords[r]=scoreFalseWords[r-1];
                    }

                    scorePlayer[i] = playerName;
                    scoreWords[i] = passedWords;
                    scoreFalseWords[i] = tries;
                }
            }
        }

        g.setScorePlayer(scorePlayer); //Werte einsetzen in die globalen Arrays
        g.setScoreWords(scoreWords);
        g.setScoreFalseWords(scoreFalseWords);

        //////////////////SCORESCHLEIFE//////////////////

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Hangman");
                share.putExtra(Intent.EXTRA_TEXT,playerName + HAT_ÜBERLEBT + GESCHAFFT_NACH + triesString + FEHLVERSUCHEN + DAS_WORT_WAR + "Score !!" );
                startActivity(Intent.createChooser(share, ZEIGE_ES_DEINEN_FREUNDEN));
            }
        });
    }

    public void openSingleplayer(View view){
        Intent singleplayer = new Intent(this, Singleplayer.class);
        singleplayer.putExtra(playerName, playerName);
        startActivity(singleplayer);
        finish();
    }

    public void finish(View view){
        finish();
    }
}
