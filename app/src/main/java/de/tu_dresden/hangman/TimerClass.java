package de.tu_dresden.hangman;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by wunderlichpaul on 27.01.18.
 */

class TimerClass extends CountDownTimer{

    private TextView remainingTimeDisplay;
    private Context context;
    private int remainingTime;

    public TimerClass(Context context,long millisInFuture, long countDownInterval,TextView remainingTimeDisplay, int time) {
        super(millisInFuture, countDownInterval);
        this.context = context;
        this.remainingTimeDisplay = remainingTimeDisplay;
        this.remainingTime=time;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long millis = millisUntilFinished;
        String hms = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        remainingTimeDisplay.setText(hms);
        remainingTime--;
    }

    @Override
    public void onFinish() {
        Toast.makeText(context,"COUNTDOWN FINISH :)",Toast.LENGTH_SHORT).show();
    }

    public int getRemainingTime()
    {
        return remainingTime;
    }
}

    /*private static final TimerClass ourInstance = new TimerClass();

    private CountDownTimer timer;
    private TextView remainingTimeDisplay;

    static TimerClass getInstance() {
        return ourInstance;
    }

    private TimerClass() {
        timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                //mTextField.setText("done!");
            }
        };
    }

    public void startTimer(){
        timer.start();
    }

    public void getValue(){

    }


}*/
