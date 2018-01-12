package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleplayerGame extends AppCompatActivity {

    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_game);

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
    }

    public void clickA(View view){

    }

}
