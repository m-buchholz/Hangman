package de.tu_dresden.hangman;

/**
 * Created by wunderlichpaul on 27.01.18.
 */
//Klasse für globale Variablen, wie z.B. Score beim Singleplayer

public class Globals {
        private static Globals instance;

        // Global variable
        private int score;
        private int remainingTime;

        // Restrict the constructor from being instantiated
        private Globals(){}

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

