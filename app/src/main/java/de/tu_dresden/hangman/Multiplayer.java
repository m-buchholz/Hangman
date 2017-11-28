package de.tu_dresden.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Multiplayer extends AppCompatActivity {

    Button start;
    EditText playerName;
    EditText enemyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        start = (Button)findViewById(R.id.buttonStartMP);
        playerName = (EditText)findViewById(R.id.editPlayerNameMP);
        enemyName = (EditText)findViewById(R.id.editEnemyName);
    }
}
