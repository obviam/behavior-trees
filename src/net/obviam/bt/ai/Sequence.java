package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sequence extends Routine {

    public enum SequenceType {
        And, Or
    }

    public Sequence(Droid droid, Board board, SequenceType type) {
        super(droid, board);
        this.type = type;
        this.currentRoutine = null;
    }

    private final SequenceType type;
    private Routine currentRoutine;
    List<Routine> routines = new LinkedList<Routine>();
    Queue<Routine> routineQueue = new LinkedList<Routine>();


    public void addRoutine(Routine routine) {
        routines.add(routine);
    }

    @Override
    public void start() {
        // start the current sequence
        super.start();
        // reset the current queue and copy the routines from setup
        routineQueue.clear();
        routineQueue.addAll(routines);
        currentRoutine = routineQueue.poll();
        currentRoutine.start();
    }

    @Override
    public void act(Droid droid, Board board) {

        currentRoutine.act(droid, board);
        // if is still running, then carry on
        if (currentRoutine.isRunning()) {
            return;
        }

        // handling AND sequence
        if (type.equals(SequenceType.And)) {
            // check if there are more routines in the queue
            // and if there are then step forward or set the sequence
            // state if finished
            if (routineQueue.peek() == null) {
                // we processed the last routine in the sequence so set the state to that
                this.state = currentRoutine.getState();
                return;
            }
        }

        // handling OR sequence
        if (type.equals(SequenceType.Or)) {
            // check if the routine is successful and finish the sequence
            if (currentRoutine.isSuccess()) {
                this.state = RoutineState.Success;
                return;
            }
        }

        // We need to progress the sequence. If there are no more routines
        // then the state is the last routine's state. (Success for OR was already handled)
        if (routineQueue.peek() == null) {
            this.state = currentRoutine.getState();
        } else {
            currentRoutine = routineQueue.poll();
            currentRoutine.start();
        }

    }
}
