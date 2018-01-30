package de.tu_dresden.hangman;

import android.media.MediaPlayer;

/**
 * Created by wunderlichpaul on 27.01.18.
 */
//Klasse für globale Variablen, wie z.B. Score beim Singleplayer

public class Globals {
        private static Globals instance;

        // Global variable
        private int score, falseWords;
        private int remainingTime;
        private String PlayerName;
        private String[] scorePlayer;
        private int[] scoreWords, scoreFalseWords;

        // Restrict the constructor from being instantiated
        private Globals(){}

        public void setScoreWords(int[] array){
            this.scoreWords = array;
        }
        public int[] getScoreWords(){
            return scoreWords;
        }

        public void setScoreFalseWords(int[] array){
            this.scoreFalseWords = array;
        }
        public int[] getScoreFalseWords(){
            return scoreFalseWords;
        }

        public void setScorePlayer(String[] array){
            this.scorePlayer = array;
        }
        public String[] getScorePlayer(){
            return scorePlayer;
        }

        public void setPlayerName(String a){
            this.PlayerName = a;
        }
        public String getPlayerName(){
            return PlayerName;
        }

        public void setFalseWords(int d){
            this.falseWords=d;
        }
        public int getFalseWords(){
            return this.falseWords;
        }
        public void falseWordsPlusOne(){
            this.falseWords++;
        }

        public void setScore(int d){
            this.score=d;
        }
        public void ScorePlusOne(){
          this.score++;
        }
        public int getScore(){
            return this.score;
        }

        public int getTime(){
            return this.remainingTime;
        }
        public void setTime(int a){
            this.remainingTime=a;
        }

        public static synchronized Globals getInstance(){
            if(instance==null){
                instance=new Globals();
            }
            return instance;
        }
    }

