package bnc;

import static bnc.AI_enemy.getEnemyNum;
import static bnc.util.ConsoleHelper.*;

/**
 * Created by astotal on 17.06.17.
 */
public class GameController {
    private static String enemyNumber;
    private int wordSize;
    private static boolean gameIsOver;
    private static int attemptCounter;

    GameController(int wordSize) {
        this.wordSize = wordSize;
    }

    public static void main(String[] args) {
        GameController controller = new GameController(4);
        controller.startGameLoop();
    }

    void startGameLoop() {
        showIntro();
        initNewGame();
        while (!gameIsOver) {
            checkResult(getResult(readValidInt()));
            if (gameIsOver) askForNewGame();
        }
        writeMessage("Покеда! Хорошего дня!");
    }

    /**
     * Initializes game data
     */
    void initNewGame() {
        enemyNumber = getEnemyNum();
        gameIsOver = false;
        attemptCounter = 0;
        applyInfoMessage();
    }

    /**
     * If getResult returns [4, 0] the game is over. Else apply current result to view and continue
     *
     * @param result
     */
    void checkResult(int[] result) {
        if (result[0] == 4) {
            showSuccessMessage();
            gameIsOver = true;
        } else {
            applyResult(result);
        }
    }

    /**
     * @param playerNumber the number that player inputs
     * @return array, where result[0] is cows and result[1] is bulls
     */
    int[] getResult(String playerNumber) {
        attemptCounter++;
        int bulls = 0;
        int cows = 0;
        if (!enemyNumber.equals(playerNumber)) {
            for (int i = 0; i < wordSize; i++) {
                for (int j = 0; j < wordSize; j++) {
                    if (enemyNumber.charAt(i) == playerNumber.charAt(j))
                        if (i == j) bulls++;
                        else cows++;
                }
            }
            return new int[]{bulls, cows};
        }

        return new int[]{4, 0};
    }

    public void showIntro() {
        writeMessage(INTRO_MESSAGE);
    }

    void showSuccessMessage() {
        writeMessage("Ты угадал с %d попытки!", attemptCounter);
    }

    void askForNewGame() {
        writeMessage("Сыграть снова? [д/н]");
        if (readString().equalsIgnoreCase("д")) {
            initNewGame();
        }
    }

    void applyResult(int[] result) {
        writeMessage("Быки: %d\nКоровы: %d", result[0], result[1]);
    }

    private void applyInfoMessage() {
        writeMessage("Введи %d-значное число", wordSize);
    }
}
