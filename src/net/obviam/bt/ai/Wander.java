package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

import java.util.Random;

public class Wander extends Routine {

    private static Random random = new Random();
    private final Board board;
    private MoveTo moveTo;

    @Override
    public void start() {
        super.start();
        this.moveTo.start();
    }

    public void reset() {
        this.moveTo = new MoveTo(random.nextInt(board.getWidth()), random.nextInt(board.getHeight()));
    }

    public Wander(Board board) {
        super();
        this.board = board;
        this.moveTo = new MoveTo(random.nextInt(board.getWidth()), random.nextInt(board.getHeight()));
    }

    @Override
    public void act(Droid droid, Board board) {
        if (!moveTo.isRunning()) {
            return;
        }
        this.moveTo.act(droid, board);
        if (this.moveTo.isSuccess()) {
            succeed();
        } else if (this.moveTo.isFailure()) {
            fail();
        }
    }
}
