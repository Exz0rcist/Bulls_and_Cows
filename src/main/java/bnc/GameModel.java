package bnc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by astotal on 17.06.17.
 */
public class GameModel {
    private String enemyNumber;
    private int wordSize;
    private boolean gameOver;
    private int attemptCounter;
    private int bulls;
    private int cows;
    private List<String> history = new ArrayList<>();

    GameModel(int wordSize) {
        this.wordSize = wordSize;
    }

    void addMove(String number) {
        history.add(number);
    }

    List<String> getHistory() {
        return history;
    }

    String getEnemyNumber() {
        return enemyNumber;
    }

    int getAttemptCounter() {
        return attemptCounter;
    }

    void incrementAttempt(){
        attemptCounter++;
    }

    int getWordSize() {
        return wordSize;
    }

    boolean isGameOver() {
        return gameOver;
    }

    void setGameOver() {
        gameOver = true;
    }

    int getBulls() {
        return bulls;
    }

    void setBulls(int bulls) {
        this.bulls = bulls;
    }

    int getCows() {
        return cows;
    }

    void setCows(int cows) {
        this.cows = cows;
    }

    void initModel(){
        gameOver = false;
        attemptCounter = 0;
        enemyNumber = AI_enemy.getEnemyNum();
        System.out.printf("DEBUG %s%n", enemyNumber);
        history.clear();
    }
}
