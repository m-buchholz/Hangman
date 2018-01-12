package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SingleplayerGame extends AppCompatActivity {

    //Wortliste, aus der zufällig eins ausgewählt wird, max 9 zeichen
    String[] wordlist = {"KATZE", "HUND", "MAUS", "PAPAGEI", "TIGER", "KUCHEN", "HAMBURGER", "FREUND", "ZUSTAND", "FISCH", "GEIER", "FUCHS", "GANS", "ENTE", "FISCH", "QUALLE", "GLAS", "INSEL", "BAYERN", "SACHSEN", "PULLOVER"};

    //Random number
    int randomNum = (int) Math.round(Math.random()*(wordlist.length-1));

    String word = wordlist[randomNum];
    int wordLength;
    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ;
    TextView letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8, letter9;
    TextView space1, space2, space3, space4, space5, space6, space7, space8;
    TextView platzhalterbilder;
    TextView[] letterArray = new TextView[9];
    int max = 11, counter = 0, countertest = 0, counterright =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_game);
        Button[] buttons = {buttonA, buttonB};

        buttonA = (Button)findViewById(R.id.buttonA);
        buttonB = (Button)findViewById(R.id.buttonB);
        buttonC = (Button)findViewById(R.id.buttonC);
        buttonD = (Button)findViewById(R.id.buttonD);
        buttonE = (Button)findViewById(R.id.buttonE);
        buttonF = (Button)findViewById(R.id.buttonF);
        buttonG = (Button)findViewById(R.id.buttonG);
        buttonH = (Button)findViewById(R.id.buttonH);
        buttonI = (Button)findViewById(R.id.buttonI);
        buttonJ = (Button)findViewById(R.id.buttonJ);
        buttonK = (Button)findViewById(R.id.buttonK);
        buttonL = (Button)findViewById(R.id.buttonL);
        buttonM = (Button)findViewById(R.id.buttonM);
        buttonN = (Button)findViewById(R.id.buttonN);
        buttonO = (Button)findViewById(R.id.buttonO);
        buttonP = (Button)findViewById(R.id.buttonP);
        buttonQ = (Button)findViewById(R.id.buttonQ);
        buttonR = (Button)findViewById(R.id.buttonR);
        buttonS = (Button)findViewById(R.id.buttonS);
        buttonT = (Button)findViewById(R.id.buttonT);
        buttonU = (Button)findViewById(R.id.buttonU);
        buttonV = (Button)findViewById(R.id.buttonV);
        buttonW = (Button)findViewById(R.id.buttonW);
        buttonX = (Button)findViewById(R.id.buttonX);
        buttonY = (Button)findViewById(R.id.buttonY);
        buttonZ = (Button)findViewById(R.id.buttonZ);

        letter1 = (TextView)findViewById(R.id.textView1);
        letter2 = (TextView)findViewById(R.id.textView2);
        letter3 = (TextView)findViewById(R.id.textView3);
        letter4 = (TextView)findViewById(R.id.textView4);
        letter5 = (TextView)findViewById(R.id.textView5);
        letter6 = (TextView)findViewById(R.id.textView6);
        letter7 = (TextView)findViewById(R.id.textView7);
        letter8 = (TextView)findViewById(R.id.textView8);
        letter9 = (TextView)findViewById(R.id.textView9);

        letterArray[0] = letter1;
        letterArray[1] = letter2;
        letterArray[2] = letter3;
        letterArray[3] = letter4;
        letterArray[4] = letter5;
        letterArray[5] = letter6;
        letterArray[6] = letter7;
        letterArray[7] = letter8;
        letterArray[8] = letter9;

        space1 = (TextView)findViewById(R.id.space1);
        space2 = (TextView)findViewById(R.id.space2);
        space3 = (TextView)findViewById(R.id.space3);
        space4 = (TextView)findViewById(R.id.space4);
        space5 = (TextView)findViewById(R.id.space5);
        space6 = (TextView)findViewById(R.id.space6);
        space7 = (TextView)findViewById(R.id.space7);
        space8 = (TextView)findViewById(R.id.space8);

        platzhalterbilder = (TextView)findViewById(R.id.nurso);

        wordLength = word.length();
        switch(wordLength){
            case 1:break;
            case 2: break;
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
            case 9: break;
        }

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
                if (letterToCheck.equals(currentL.toString()) && counterright < (map.size()-1) && counter < max) {
                    letterArray[i].setText(currentL.toString());
                    counterright++;
                }
                else if (letterToCheck.equals(currentL.toString()) && counterright == (map.size()-1) ) {
                    letterArray[i].setText(currentL.toString());
                    startActivity(win);
                }
                else if (letterToCheck.equals(currentL.toString()) && counter == (max-1) && counterright < (map.size()-1) ){
                    letterArray[i].setText(currentL.toString());
                    counterright++;
                }
                else if (!letterToCheck.equals(currentL.toString()) && counter < (max-1) ) {
                    countertest++;
                }

            }

            if (countertest > word.length()-1){
                counter++;
            }
            countertest=0;
            platzhalterbilder.setText(""+counter);
            //wenn maxium an fehlversuchen erreicht -> lost activity
            if(counter == max-1){
                startActivity(lost);
            }

    }

}