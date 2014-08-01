package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

public class MoveTo extends Routine {

    final protected int destX;
    final protected int destY;

    public MoveTo(int destX, int destY) {
        super();
        this.destX = destX;
        this.destY = destY;
    }

    public void reset() {
        start();
    }

    @Override
    public void act(Droid droid, Board board) {
        if (isRunning() && !droid.isAlive()) {
            fail();
            return;
        }
        if (isRunning() && !isDroidAtDestination(droid)) {
            moveDroid(droid);
        }
    }

    private void moveDroid(Droid droid) {
        if (destY != droid.getY()) {
            if (destY > droid.getY()) {
                droid.setY(droid.getY() + 1);
            } else {
                droid.setY(droid.getY() - 1);
            }
        }
        if (destX != droid.getX()) {
            if (destX > droid.getX()) {
                droid.setX(droid.getX() + 1);
            } else {
                droid.setX(droid.getX() - 1);
            }
        }
        if (isDroidAtDestination(droid)) {
            succeed();
        }
    }

    private boolean isDroidAtDestination(Droid droid) {
        return destX == droid.getX() && destY == droid.getY();
    }
}
