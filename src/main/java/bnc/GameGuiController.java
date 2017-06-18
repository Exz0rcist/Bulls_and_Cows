package bnc;

/**
 * Created by astotal on 17.06.17.
 */
public class GameGuiController extends GameController {
    private GameGuiView view = new GameGuiView(this);
    private GameModel model;

    GameGuiController(int wordSize) {
        super(wordSize);
        model = new GameModel(wordSize);
    }

    @Override
    public void showIntro() {
        view.showIntro();
    }



}
