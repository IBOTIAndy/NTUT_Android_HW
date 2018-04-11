package com.paperscissorsstonegame;

import android.support.v4.content.res.ResourcesCompat;

/**
 * Created by pinlin on 2018/4/11.
 */

public class GameSystem {
    private int myChoice;
    private int comChoice;
    private int result;

    // 0 為輸，1 為贏，2 為平手
    private int rule[][] = {{2, 0, 1}, {1, 2, 0}, {0, 1, 2}};

    private int generateRandom() {
        return (int)(Math.random() * 3 + 1);
    }

    public void setMyChoice(int iMyChoice) {
        this.myChoice = iMyChoice;
    }

    public void setComChoice(int iComChoice) {
        this.comChoice = iComChoice;
    }

    public int getComChoice() {
        return this.comChoice;
    }

    public void judge() {
        // 決定誰輸誰贏
        this.result = rule[this.myChoice - 1][this.comChoice - 1];
    }

    public void playGame(int iMyChoice) {
        this.setMyChoice(iMyChoice);
        this.setComChoice(this.generateRandom());
        this.judge();
    }

    public int getResult() {
        return this.result;
    }
}
