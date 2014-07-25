package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

public abstract class Routine {

    public enum RoutineState {
        Success,
        Failure,
        Running
    }

    protected final Board board;
    protected final Droid droid;
    protected RoutineState state;

    protected Routine(Droid droid, Board board) {
        this.droid = droid;
        this.board = board;
    }

    public Droid getDroid() {
        return droid;
    }

    public Board getBoard() {
        return board;
    }


    public void start() {
        System.out.println(">>> Starting routine: " + this.getClass().getSimpleName() + " for droid: " + droid.getName());
        this.state = RoutineState.Running;
    }

    public abstract void reset();

    public abstract void act(Droid droid, Board board);

    protected void succeed() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " SUCCEEDED for droid: " + droid.getName());
        this.state = RoutineState.Success;
    }

    protected void fail() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " FAILED for droid: " + droid.getName());
        this.state = RoutineState.Failure;
    }

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
