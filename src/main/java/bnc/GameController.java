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

    private GameController(int wordSize) {
        this.wordSize = wordSize;
    }

    public static void main(String[] args) {
        GameController controller = new GameController(4);
        controller.startGameLoop();
    }

    private void startGameLoop() {
        writeMessage(INTRO_MESSAGE);
        initNewGame();
        while (!gameIsOver) {
            checkResult(getResult(readValidInt()));
            checkPlayAnotherGame();
        }
        writeMessage("Покеда! Хорошего дня!");
    }

    private void checkPlayAnotherGame() {
        if (!gameIsOver) return;
        writeMessage("Сыграть снова? [д/н]");
        if (readString().equalsIgnoreCase("д")) {
            initNewGame();
        }
    }

    /**
     * Инициализация игровых значений
     */
    private void initNewGame() {
        enemyNumber = getEnemyNum();
        gameIsOver = false;
        attemptCounter = 0;
        writeMessage("Введи %d-значное число", wordSize);
    }

    /**
     * Если метод getResult вернул в [4, 0] то игра закончена. Иначе выводим статистику и играем дальше
     * @param result
     */
    private void checkResult(int[] result) {
        if (result[0] == 4) {
            writeMessage("Ты угадал с %d попытки!", attemptCounter);
            gameIsOver = true;
        } else {
            writeMessage("Быки: %d\nКоровы: %d", result[0], result[1]);
        }
    }

    /**
     * @param playerNumber the number that player inputs
     * @return array, where result[0] is cows and result[1] is bulls
     */
    private int[] getResult(String playerNumber) {
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
}
