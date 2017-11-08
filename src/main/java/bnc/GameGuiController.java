package bnc;

/**
 * Created by astotal on 17.06.17.
 */
public class GameGuiController extends GameController {
    private GameGuiView view = new GameGuiView(this);

    GameGuiController(int wordSize) {
        super(wordSize);
    }

    public static void main(String[] args) {
        GameController gc = new GameGuiController(4);
        gc.showIntro();
        gc.startGameLoop();
    }

    @Override
    void loop() {
        //DO NOTHING
    }

    @Override
    void showIntro() {
        view.showIntro();
    }

    @Override
    void showSuccessMessage() {
        gm.setBulls(4);
        gm.setCows(0);
        view.showSuccessMessage();
    }

    @Override
    void askForNewGame() {
        view.askForNewGame();
    }

    @Override
    void applyResult(int[] result) {
        gm.setBulls(result[0]);
        gm.setCows(result[1]);
        view.applyResult();
    }

    byte validator(String s){
        byte err = 0;
        if (s.length() != 4) err = 1;
        try{
            int val = Integer.parseInt(s);
            if (val < 0) err = 2;
        }
        catch (Exception ignore){

            err = 3;
        }
        return err;
    }
}
