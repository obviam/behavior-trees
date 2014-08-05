package net.obviam.bt;

import net.obviam.bt.ai.Repeat;
import net.obviam.bt.ai.Routine;
import net.obviam.bt.ai.Wander;

public class Test {

    public static void main(String[] args) {
        // Setup
        Board board = new Board(10, 10);

        Droid droid = new Droid("MyDroid", 5, 5, 10, 1, 2);
        board.addDroid(droid);

        Routine routine = new Repeat((new Wander(board)));
        droid.setRoutine(routine);
        System.out.println(droid);

        for (int i = 0; i < 10; i++) {
            droid.update();
            System.out.println(droid);
        }
    }
}
