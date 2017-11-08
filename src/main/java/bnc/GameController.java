package bnc;

import static bnc.util.ConsoleHelper.*;

/**
 * Created by astotal on 17.06.17.
 */
public class GameController {
    static GameModel gm;

    GameController(int wordSize) {
        gm = new GameModel(wordSize);
    }

    public static void main(String[] args) {
        GameController gc = new GameController(4);
        gc.startGameLoop();
    }

    void startGameLoop() {
        //showIntro();
        initNewGame();
        loop();
    }

    void loop() {
        applyInfoMessage();
        while (!gm.isGameOver()) {
            checkResult(getResult(readValidInt()));
            if (gm.isGameOver()) askForNewGame();
        }
        writeMessage("Покеда! Хорошего дня!");
    }

    void showIntro() {
        writeMessage(INTRO_MESSAGE);
    }

    void showSuccessMessage() {
        writeMessage("Ты угадал с %d попытки!", gm.getAttemptCounter());
    }

    void askForNewGame() {
        writeMessage("Сыграть снова? [д/н]");
        if (readString().matches("[дy]")) {
            showIntro();
            initNewGame();
        }
    }

    void applyResult(int[] result) {
        writeMessage("Быки: %d\nКоровы: %d", result[0], result[1]);
    }

    private void applyInfoMessage() {
        writeMessage("Введи %d-значное число", gm.getWordSize());
    }

    /**
     * Initializes game data
     */
    static void initNewGame() {
        gm.initModel();
    }

    /**
     * If getResult returns [4, 0] the game is over. Else apply current result to view and continue
     *
     * @param result
     */
    void checkResult(int[] result) {
        if (result[0] == 4) {
            showSuccessMessage();
            gm.setGameOver();
        } else {
            applyResult(result);
        }
    }

    /**
     * @param playerNumber the number that player inputs
     * @return array, where result[0] is cows and result[1] is bulls
     */
    int[] getResult(String playerNumber) {
        //TODO make validation
        gm.incrementAttempt();
        int bulls = 0;
        int cows = 0;
        if (!gm.getEnemyNumber().equals(playerNumber)) {
            for (int i = 0; i < gm.getWordSize(); i++) {
                for (int j = 0; j < gm.getWordSize(); j++) {
                    if (gm.getEnemyNumber().charAt(i) == playerNumber.charAt(j))
                        if (i == j) bulls++;
                        else cows++;
                }
            }
            return new int[]{bulls, cows};
        }

        return new int[]{4, 0};
    }

    static GameModel getModel() {
        return gm;
    }
}
