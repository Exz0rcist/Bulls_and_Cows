package bnc;

import javax.swing.*;
import java.awt.*;

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

    private GameGuiController controller;

    public GameGuiView(GameGuiController controller) {
        this.controller = controller;
        initGui();
    }

    public void initGui() {
        frame = new JFrame();
        frame.setContentPane(panBackground);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

//        panStats.setVisible(false);




        frame.setVisible(true);
    }

    void showIntro() {
        JOptionPane.showMessageDialog(
                frame,
                INTRO_MESSAGE,
                "Правила",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
