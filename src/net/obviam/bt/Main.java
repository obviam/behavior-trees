package net.obviam.bt;

import net.obviam.bt.ai.Routine;
import net.obviam.bt.ai.Routines;

import javax.swing.*;

public class Main {
    private JPanel panel1;
    private JPanel mainPanel;
    private JPanel canvas;

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Main");
//        frame.setPreferredSize(new Dimension(800, 600));
//        frame.setResizable(false);
//        frame.setContentPane(new Main().mainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

        Board board = new Board(25, 25);
        Droid droid = new Droid("Droid_1", 2, 2, 10, 1, 3);
        Routine brain = Routines.sequenceAnd(droid, board,
            Routines.moveTo(droid, board, 5, 10),
            Routines.moveTo(droid, board, 15, 12),
            Routines.moveTo(droid, board, 2, 4)
        );
        droid.setRoutine(brain);

        for (int i = 0; i < 30; i++) {
            System.out.println(droid.toString());
            droid.update();
        }
    }
}
