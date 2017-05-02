package com.example.da981108.i_control;

import android.support.v7.app.AppCompatActivity;

import java.util.Random;

/**
 * Created by ak970617 on 2017-01-12.
 */

public class RandomNumberGeneretor extends AppCompatActivity {
    //a variable that saves the random number created below
    private static Random rand = new Random();

    //method to create a random number betweeen a given range
    public static int getRandomIntBetween(int lowerno,
                                          int higherno){
        return rand.nextInt(higherno -lowerno)+lowerno;
    }
    //method to return the random number
    public static int getRandInt(int higherno){
        return  rand.nextInt(higherno);
    }
}
