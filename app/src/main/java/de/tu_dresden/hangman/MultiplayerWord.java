package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplayerWord extends AppCompatActivity {

    Button startGame;
    EditText editMultiWord;
    TextView showActingPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_word);

        startGame = (Button)findViewById(R.id.buttonStartMPGame);
        editMultiWord = (EditText)findViewById(R.id.editMultiWord);
        showActingPlayer = (TextView)findViewById(R.id.showActingPlayer);
    }

    public void startMPGame(View view){
        Intent startMPGame = new Intent(this, MultiplayerGame.class);
        startActivity(startMPGame);
    }
}
