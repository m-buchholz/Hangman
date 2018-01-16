package de.tu_dresden.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Singleplayer extends AppCompatActivity {

    Button start;
    EditText name;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        start = (Button)findViewById(R.id.buttonStartSP);
        name = (EditText)findViewById(R.id.editPlayerNameSP);
    }

    public void startSPGame(View view){
        playerName = name.getText().toString();
        if(name.getText().toString().isEmpty() == false){
            Intent startSPGame = new Intent(this, SingleplayerGame.class);
            startSPGame.putExtra("playerName", playerName);
            startActivity(startSPGame);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Gib einen Gamertag ein!",Toast.LENGTH_LONG); //Fehlermeldung wenn kein Name eingegeben
        }
    }
}
