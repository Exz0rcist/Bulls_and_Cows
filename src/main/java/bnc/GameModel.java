package bnc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by astotal on 17.06.17.
 */
public class GameModel {
    private static String enemyNumber;
    private int wordSize;
    private boolean gameOver;
    private int attemptCounter;
    private List<String> history = new ArrayList<>();

    public GameModel(int wordSize) {
        initGame(wordSize);
    }

    public static void setEnemyNumber(String enemyNumber) {
        GameModel.enemyNumber = enemyNumber;
    }

    public void addMove(String number) {
        history.add(number);
    }

    public List<String> getHistory() {
        return history;
    }

    public static String getEnemyNumber() {
        return enemyNumber;
    }

    public int getAttemptCounter() {
        return attemptCounter;
    }

    public int getWordSize() {
        return wordSize;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void initGame(int wordSize){
        this.wordSize = wordSize;
        gameOver = false;
        attemptCounter = 0;
        history.clear();
    }
}
