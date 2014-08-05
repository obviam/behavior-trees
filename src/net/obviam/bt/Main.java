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
        Droid droid1 = new Droid("Droid_1", 2, 2, 10, 1, 3);
        Droid droid2 = new Droid("Droid_2", 10, 10, 10, 2, 2);

        Routine brain1 = Routines.sequence(
                Routines.moveTo(5, 10),
                Routines.moveTo(15, 12),
                Routines.moveTo(2, 4)
        );
        droid1.setRoutine(brain1);

        Routine brain2 = Routines.sequence(
            Routines.repeat(Routines.wander(board), 4)
        );
        droid2.setRoutine(brain2);

        for (int i = 0; i < 30; i++) {
            System.out.println(droid1.toString());
            System.out.println(droid2.toString());
            droid1.update();
            droid2.update();
        }
    }
}
