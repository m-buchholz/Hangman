/*Info:
    counter: zählt Fehlversuche
    countertest: Hilfsvariable, um Fehlversuche zu zählen
    counterright: zählt richtige Versuche. Wenn Maximum erreicht, dann hat man gewonnen. Maximum = Anzahl der unterschiedlichen Buchstaben in einem Wort
    counterr: Hilfsvariable, um richtige Versuche zu zählen
*/

package de.tu_dresden.hangman;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SingleplayerGame extends AppCompatActivity {

    public static final String TRIES = "tries";
    public static final String PLAYER_NAME = "playerName";
    public static final String WORD = "word";
    public static final String PULLOVER = "PULLOVER";
    public static final String SACHSEN = "SACHSEN";
    public static final String BAYERN = "BAYERN";
    public static final String INSEL = "INSEL";
    public static final String GLAS = "GLAS";
    public static final String QUALLE = "QUALLE";
    public static final String FISCH = "FISCH";
    public static final String ENTE = "ENTE";
    public static final String GANS = "GANS";
    public static final String FUCHS = "FUCHS";
    public static final String GEIER = "GEIER";
    public static final String ZUSTAND = "ZUSTAND";
    public static final String FREUND = "FREUND";
    public static final String HAMBURGER = "HAMBURGER";
    public static final String KUCHEN = "KUCHEN";
    public static final String TIGER = "TIGER";
    public static final String PAPAGEI = "PAPAGEI";
    public static final String MAUS = "MAUS";
    public static final String HUND = "HUND";
    public static final String KATZE = "KATZE";
    public static final String KATZENKLO = "Katzenklo";
    public static final String PASSED_WORDS = "passedWords";
    //Wortliste, aus der zufällig eins ausgewählt wird, max 9 zeichen
    String[] wordlist = {KATZENKLO, KATZE, HUND, MAUS, PAPAGEI, TIGER, KUCHEN, HAMBURGER, FREUND, ZUSTAND, FISCH, GEIER, FUCHS, GANS, ENTE, FISCH, QUALLE, GLAS, INSEL, BAYERN, SACHSEN, PULLOVER};

    //Random number
    int randomNum = (int) Math.round(Math.random()*(wordlist.length-1));

    String word = wordlist[randomNum].toUpperCase();
    String playerName;

    int wordLength, passedWords = 0;
    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ;
    TextView letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8, letter9;
    TextView space1, space2, space3, space4, space5, space6, space7, space8;
    TextView[] letterArray = new TextView[9];
    TextView timerTV;

    //Bilder array, Länge 9 = 9 Versuche
    ImageView[] imageArray = new ImageView[9];
    ImageView hangman0, hangman1, hangman2, hangman3, hangman4, hangman5, hangman6, hangman7, hangman8;

    int max = (imageArray.length+1), counter = 0, countertest = 0, counterright =0, counterr=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_game);

        playerName = getIntent().getExtras().getString(PLAYER_NAME);
        Button[] buttons = {buttonA, buttonB};

        //Buttons für Buchstaben
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        buttonE = findViewById(R.id.buttonE);
        buttonF = findViewById(R.id.buttonF);
        buttonG = findViewById(R.id.buttonG);
        buttonH = findViewById(R.id.buttonH);
        buttonI = findViewById(R.id.buttonI);
        buttonJ = findViewById(R.id.buttonJ);
        buttonK = findViewById(R.id.buttonK);
        buttonL = findViewById(R.id.buttonL);
        buttonM = findViewById(R.id.buttonM);
        buttonN = findViewById(R.id.buttonN);
        buttonO = findViewById(R.id.buttonO);
        buttonP = findViewById(R.id.buttonP);
        buttonQ = findViewById(R.id.buttonQ);
        buttonR = findViewById(R.id.buttonR);
        buttonS = findViewById(R.id.buttonS);
        buttonT = findViewById(R.id.buttonT);
        buttonU = findViewById(R.id.buttonU);
        buttonV = findViewById(R.id.buttonV);
        buttonW = findViewById(R.id.buttonW);
        buttonX = findViewById(R.id.buttonX);
        buttonY = findViewById(R.id.buttonY);
        buttonZ = findViewById(R.id.buttonZ);

        //Leerzeichen für Wort und Space dazwischen
        letter1 = findViewById(R.id.textView1);
        letter2 = findViewById(R.id.textView2);
        letter3 = findViewById(R.id.textView3);
        letter4 = findViewById(R.id.textView4);
        letter5 = findViewById(R.id.textView5);
        letter6 = findViewById(R.id.textView6);
        letter7 = findViewById(R.id.textView7);
        letter8 = findViewById(R.id.textView8);
        letter9 = findViewById(R.id.textView9);

        letterArray[0] = letter1;
        letterArray[1] = letter2;
        letterArray[2] = letter3;
        letterArray[3] = letter4;
        letterArray[4] = letter5;
        letterArray[5] = letter6;
        letterArray[6] = letter7;
        letterArray[7] = letter8;
        letterArray[8] = letter9;

        space1 = findViewById(R.id.space1);
        space2 = findViewById(R.id.space2);
        space3 = findViewById(R.id.space3);
        space4 = findViewById(R.id.space4);
        space5 = findViewById(R.id.space5);
        space6 = findViewById(R.id.space6);
        space7 = findViewById(R.id.space7);
        space8 = findViewById(R.id.space8);

        //Zeige Striche je nach Wortlänge
        wordLength = word.length();
        switch (wordLength) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                letter4.setVisibility(View.GONE);
                letter5.setVisibility(View.GONE);
                letter6.setVisibility(View.GONE);
                letter7.setVisibility(View.GONE);
                letter8.setVisibility(View.GONE);
                letter9.setVisibility(View.GONE);
                space3.setVisibility(View.GONE);
                space4.setVisibility(View.GONE);
                space5.setVisibility(View.GONE);
                space7.setVisibility(View.GONE);
                space8.setVisibility(View.GONE);
                space6.setVisibility(View.GONE);
                break;
            case 4:
                letter5.setVisibility(View.GONE);
                letter6.setVisibility(View.GONE);
                letter7.setVisibility(View.GONE);
                letter8.setVisibility(View.GONE);
                letter9.setVisibility(View.GONE);
                space4.setVisibility(View.GONE);
                space5.setVisibility(View.GONE);
                space7.setVisibility(View.GONE);
                space8.setVisibility(View.GONE);
                space6.setVisibility(View.GONE);
                break;
            case 5:
                letter6.setVisibility(View.GONE);
                letter7.setVisibility(View.GONE);
                letter8.setVisibility(View.GONE);
                letter9.setVisibility(View.GONE);
                space5.setVisibility(View.GONE);
                space7.setVisibility(View.GONE);
                space8.setVisibility(View.GONE);
                space6.setVisibility(View.GONE);
                break;
            case 6:
                letter7.setVisibility(View.GONE);
                letter8.setVisibility(View.GONE);
                letter9.setVisibility(View.GONE);
                space7.setVisibility(View.GONE);
                space8.setVisibility(View.GONE);
                space6.setVisibility(View.GONE);
                break;
            case 7:
                letter8.setVisibility(View.GONE);
                letter9.setVisibility(View.GONE);
                space7.setVisibility(View.GONE);
                space8.setVisibility(View.GONE);
                break;
            case 8:
                letter9.setVisibility(View.GONE);
                space8.setVisibility(View.GONE);
                break;
            case 9:
                break;
        }

        //Bilder
        hangman0 = findViewById(R.id.hangman0);
        hangman1 = findViewById(R.id.hangman1);
        hangman2 = findViewById(R.id.hangman2);
        hangman3 = findViewById(R.id.hangman3);
        hangman4 = findViewById(R.id.hangman4);
        hangman5 = findViewById(R.id.hangman5);
        hangman6 = findViewById(R.id.hangman6);
        hangman7 = findViewById(R.id.hangman7);
        hangman8 = findViewById(R.id.hangman8);

        //Bilder in Array
        imageArray[0] = hangman0;
        imageArray[1] = hangman1;
        imageArray[2] = hangman2;
        imageArray[3] = hangman3;
        imageArray[4] = hangman4;
        imageArray[5] = hangman5;
        imageArray[6] = hangman6;
        imageArray[7] = hangman7;
        imageArray[8] = hangman8;

        //Countdown Timer
        timerTV = (TextView) findViewById(R.id.timerTV);
        new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTV.setText("" + millisUntilFinished/60000 + ":" + (millisUntilFinished/1000)%60);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                timerTV.setText("done!");
            }

        }.start();

    }

    public void clickButton(View view){
            view.setVisibility(View.INVISIBLE);
            Button b = (Button)view;
            String letterToCheck = b.getText().toString();
            Character currentL;

            Intent lost = new Intent(this, Lose.class);
            Intent win = new Intent(this, Win.class);

            HashMap<Character,Integer> map = new HashMap<Character,Integer>();
            String s = word;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
               Integer val = map.get(c);
               if(val != null){
                   map.put(c, new Integer(val + 1));
               }else{
                   map.put(c,1);
               }
            }


            for(int i = 0; i < wordLength; i++) {
                currentL = word.charAt(i);
                if (letterToCheck.equalsIgnoreCase(currentL.toString()) && counterright < (map.size()-1) && counter < max) {
                    letterArray[i].setText(currentL.toString());
                    counterr++;
                }
                else if (letterToCheck.equalsIgnoreCase(currentL.toString()) && counterright == (map.size()-1) ) {
                    passedWords ++;
                    letterArray[i].setText(currentL.toString());
                    win.putExtra(WORD, word); //Werte übergeben
                    win.putExtra(PLAYER_NAME, playerName);
                    win.putExtra(TRIES, counter);
                    win.putExtra(PASSED_WORDS, passedWords);
                    startActivity(win);
                    finish(); //Activity schliessen
                }
                else if (letterToCheck.equalsIgnoreCase(currentL.toString()) && counter == (max-1) && counterright < (map.size()-1) ){
                    letterArray[i].setText(currentL.toString());
                    counterr++;
                }
                else if (!letterToCheck.equalsIgnoreCase(currentL.toString()) && counter < (max-1) ) {
                    countertest++;
                }

            }

            if(counterr > 0){
                counterright++;
                counterr=0;
            }

            if (countertest > word.length()-1){
                counter++;
            }
            countertest=0;
            //wenn Maxium an Fehlversuchen erreicht -> lost activity
            if(counter == max-1){
                lost.putExtra(WORD, word); //Werte übergeben
                lost.putExtra(PLAYER_NAME, playerName);
                lost.putExtra(TRIES, counter);
                startActivity(lost);
                imageArray[counter-1].setVisibility(View.VISIBLE);
                imageArray[counter-2].setVisibility(View.INVISIBLE);
                finish(); //Activity schliessen
            }
            else if (counter > 0 && counter < (max-1)){
                imageArray[counter-1].setVisibility(View.VISIBLE);
                if (counter > 1) imageArray[counter-2].setVisibility(View.INVISIBLE);
            }
    }

}