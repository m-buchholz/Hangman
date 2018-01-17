package de.tu_dresden.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Lose extends AppCompatActivity {

    String playerName;
    TextView notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        playerName = getIntent().getExtras().getString("playerName");
        notice = (TextView) findViewById(R.id.lose_notice);
        notice.setText("Du hast leider verloren, "+playerName+".");
    }

    public void openSingleplayer(View view){
        Intent singleplayer = new Intent(this, Singleplayer.class);
        startActivity(singleplayer);
        finish();
    }

    public void finish(View view){
        finish();
    }
}
