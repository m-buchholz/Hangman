package de.tu_dresden.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Singleplayer extends AppCompatActivity {

    Button start;
    EditText playerName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        start = (Button)findViewById(R.id.buttonStartSP);
        playerName = (EditText)findViewById(R.id.editPlayerNameSP);
    }

    public void startSPGame(View view){
        name = playerName.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bitte einen Namen eingeben!");
        builder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();

        if(name.equalsIgnoreCase("")){
            alert.show();
        }
        else {
            Intent startSPGame = new Intent(this, SingleplayerGame.class);
            startSPGame.putExtra("name", name);
            startActivity(startSPGame);
            finish(); //Activity schließen (wenn Spiel gestartet wird)
        }
    }
}
