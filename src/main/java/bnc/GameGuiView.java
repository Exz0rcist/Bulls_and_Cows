package bnc;

import javax.swing.*;
import java.awt.event.ActionListener;

import static bnc.util.ConsoleHelper.INTRO_MESSAGE;

/**
 * Created by astotal on 18.06.17.
 */
public class GameGuiView {
    private JFrame frame;
    private JLabel lblLastAnswer;
    private JLabel lblBulls;
    private JLabel lblCows;
    private JButton btnExit;
    private JButton btnCheckout;
    private JButton btnGiveUp;
    private JTextField textFieldAnswer;
    private JLabel lblMission;
    private JPanel panUserAnswer;
    private JPanel panStats;
    private JPanel panButtons;
    private JLabel lblFieldInfo;
    private JPanel panBackground;

    private GameGuiController gc;
    private ActionListener al = e -> {
        gc.checkResult(gc.getResult(textFieldAnswer.getText()));
        panStats.setVisible(true);
        lblLastAnswer.setText("Последний ответ: " + textFieldAnswer.getText());
        textFieldAnswer.setText("");
    };

    GameGuiView(GameGuiController gc) {
        this.gc = gc;
        initGui();
    }

    void initGui() {
        frame = new JFrame();
        frame.setContentPane(panBackground);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panStats.setVisible(false);

        textFieldAnswer.addActionListener(al);
        btnCheckout.addActionListener(al);
        btnExit.addActionListener(e -> System.exit(0));


        frame.setVisible(true);
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            JOptionPane.showMessageDialog(
                    frame,
                    e.getStackTrace(),
                    t.getName(),
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        });
    }

    private void restoreView() {
        panStats.setVisible(false);
        lblBulls.setText("Быки: 0");
        lblCows.setText("Коровы: 0");
    }

    void showIntro() {
        JOptionPane.showMessageDialog(
                frame,
                INTRO_MESSAGE,
                "Правила",
                JOptionPane.INFORMATION_MESSAGE);
    }

    void askForNewGame() {
        if (JOptionPane.showConfirmDialog(frame, "Сыграть снова?", "Повторим?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            restoreView();
            gc.startGameLoop();
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Покеда! Хорошего дня!",
                    "Еще увидимся",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    void showSuccessMessage() {
        JOptionPane.showMessageDialog(
                frame,
                String.format("Ты угадал с %d попытки!", GameController.getModel().getAttemptCounter()),
                "Конец игры",
                JOptionPane.INFORMATION_MESSAGE);
        askForNewGame();
    }

    void applyResult() {
        lblBulls.setText("Быки: " + GameController.getModel().getBulls());
        lblCows.setText("Коровы: " + GameController.getModel().getCows());
    }

    // TODO:
    void giveUp() {
    }
}
