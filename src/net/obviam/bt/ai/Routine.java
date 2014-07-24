package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

public abstract class Routine {

    protected final Droid droid;
    protected final Board board;

    protected Routine(Droid droid, Board board) {
        this.droid = droid;
        this.board = board;
    }

    public enum RoutineState {
        Success,
        Failure,
        Running
    }

    protected RoutineState state;

    public void start() {
        System.out.println(">>> Starting routine: " + this.getClass().getSimpleName());
        this.state = RoutineState.Running;
    }

    public abstract void act(Droid droid, Board board);

    public boolean isSuccess() {
        return state.equals(RoutineState.Success);
    }

    public boolean isFailure() {
        return state.equals(RoutineState.Failure);
    }

    public boolean isRunning() {
        return state.equals(RoutineState.Running);
    }

    public RoutineState getState() {
        return state;
    }
}
