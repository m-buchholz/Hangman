//Info: Variable counter sind die Fehlversuche für ein Wort

package de.tu_dresden.hangman;

import android.content.Intent;
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
    public static final String EXTRA_WORD = "de.tu-dresden.hangman.EXTRA_WORD";

    //Wortliste, aus der zufällig eins ausgewählt wird, max 9 zeichen
    String[] wordlist = {"KATZE", "HUND", "MAUS", "PAPAGEI", "TIGER", "KUCHEN", "HAMBURGER", "FREUND", "ZUSTAND", "FISCH", "GEIER", "FUCHS", "GANS", "ENTE", "FISCH", "QUALLE", "GLAS", "INSEL", "BAYERN", "SACHSEN", "PULLOVER"};

    //Random number
    int randomNum = (int) Math.round(Math.random()*(wordlist.length-1));

    String word = wordlist[randomNum];
    String playerName;

    int wordLength;
    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ;
    TextView letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8, letter9;
    TextView space1, space2, space3, space4, space5, space6, space7, space8;
    TextView[] letterArray = new TextView[9];

    //Bilder array, Länge 9 = 9 Versuche
    ImageView[] imageArray = new ImageView[9];
    ImageView hangman0, hangman1, hangman2, hangman3, hangman4, hangman5, hangman6, hangman7, hangman8;

    int max = (imageArray.length +1), counter = 0, countertest = 0, counterright =0, counterr=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_game);

        playerName = getIntent().getExtras().getString("playerName");
        Button[] buttons = {buttonA, buttonB};

        //Buttons für Buchstaben
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonF = (Button) findViewById(R.id.buttonF);
        buttonG = (Button) findViewById(R.id.buttonG);
        buttonH = (Button) findViewById(R.id.buttonH);
        buttonI = (Button) findViewById(R.id.buttonI);
        buttonJ = (Button) findViewById(R.id.buttonJ);
        buttonK = (Button) findViewById(R.id.buttonK);
        buttonL = (Button) findViewById(R.id.buttonL);
        buttonM = (Button) findViewById(R.id.buttonM);
        buttonN = (Button) findViewById(R.id.buttonN);
        buttonO = (Button) findViewById(R.id.buttonO);
        buttonP = (Button) findViewById(R.id.buttonP);
        buttonQ = (Button) findViewById(R.id.buttonQ);
        buttonR = (Button) findViewById(R.id.buttonR);
        buttonS = (Button) findViewById(R.id.buttonS);
        buttonT = (Button) findViewById(R.id.buttonT);
        buttonU = (Button) findViewById(R.id.buttonU);
        buttonV = (Button) findViewById(R.id.buttonV);
        buttonW = (Button) findViewById(R.id.buttonW);
        buttonX = (Button) findViewById(R.id.buttonX);
        buttonY = (Button) findViewById(R.id.buttonY);
        buttonZ = (Button) findViewById(R.id.buttonZ);

        //Leerzeichen für Wort und Space dazwischen
        letter1 = (TextView) findViewById(R.id.textView1);
        letter2 = (TextView) findViewById(R.id.textView2);
        letter3 = (TextView) findViewById(R.id.textView3);
        letter4 = (TextView) findViewById(R.id.textView4);
        letter5 = (TextView) findViewById(R.id.textView5);
        letter6 = (TextView) findViewById(R.id.textView6);
        letter7 = (TextView) findViewById(R.id.textView7);
        letter8 = (TextView) findViewById(R.id.textView8);
        letter9 = (TextView) findViewById(R.id.textView9);

        letterArray[0] = letter1;
        letterArray[1] = letter2;
        letterArray[2] = letter3;
        letterArray[3] = letter4;
        letterArray[4] = letter5;
        letterArray[5] = letter6;
        letterArray[6] = letter7;
        letterArray[7] = letter8;
        letterArray[8] = letter9;

        space1 = (TextView) findViewById(R.id.space1);
        space2 = (TextView) findViewById(R.id.space2);
        space3 = (TextView) findViewById(R.id.space3);
        space4 = (TextView) findViewById(R.id.space4);
        space5 = (TextView) findViewById(R.id.space5);
        space6 = (TextView) findViewById(R.id.space6);
        space7 = (TextView) findViewById(R.id.space7);
        space8 = (TextView) findViewById(R.id.space8);

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
        hangman0 = (ImageView) findViewById(R.id.hangman0);
        hangman1 = (ImageView) findViewById(R.id.hangman1);
        hangman2 = (ImageView) findViewById(R.id.hangman2);
        hangman3 = (ImageView) findViewById(R.id.hangman3);
        hangman4 = (ImageView) findViewById(R.id.hangman4);
        hangman5 = (ImageView) findViewById(R.id.hangman5);
        hangman6 = (ImageView) findViewById(R.id.hangman6);
        hangman7 = (ImageView) findViewById(R.id.hangman7);
        hangman8 = (ImageView) findViewById(R.id.hangman8);

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
                    letterArray[i].setText(currentL.toString());
                    win.putExtra(EXTRA_WORD, word);
                    win.putExtra("playerName", playerName); //Spielername übergeben
                    startActivity(win);
                    finish();//Activity schließen, wenn gewonnen
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
            //wenn maxium an fehlversuchen erreicht -> lost activity
            if(counter == max-1){
                lost.putExtra(EXTRA_WORD, word);
                lost.putExtra("playerName", playerName);
                startActivity(lost);
                imageArray[counter-1].setVisibility(View.VISIBLE);
                finish(); //Activity schließen (wenn verloren)
            }
            else if (counter > 0 && counter < (max-1)){
                imageArray[counter-1].setVisibility(View.VISIBLE);
            }
    }

}