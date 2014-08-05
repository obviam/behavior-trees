package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

public class IsDroidInRange extends Routine {

    public IsDroidInRange() {}

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Droid droid, Board board) {
        // find droid in range
        for (Droid enemy : board.getDroids()) {
            if (!droid.getName().equals(enemy)) {
                if (isInRange(droid, enemy)) {
                    succeed();
                    break;
                }
            }
        }
        fail();
    }

    private boolean isInRange(Droid droid, Droid enemy) {
        return (Math.abs(droid.getX() - enemy.getX()) <= droid.getRange()
                || Math.abs(droid.getY() - enemy.getY()) < droid.getRange());
    }
}
