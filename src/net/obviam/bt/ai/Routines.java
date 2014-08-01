package net.obviam.bt.ai;

import net.obviam.bt.Board;

/**
 * Static convenience methods to create And or Or sequences
 */
public class Routines {

    public static Routine sequenceAnd(Routine... routines) {
        Sequence sequence = new Sequence(Sequence.SequenceType.And);
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine sequenceOr(Routine... routines) {
        Sequence sequence = new Sequence(Sequence.SequenceType.Or);
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine moveTo(int x, int y) {
        return new MoveTo(x, y);
    }

    public static Routine repeatInfinite(Routine routine) {
        return new Repeat(routine);
    }

    public static Routine repeat(Routine routine, int times) {
        return new Repeat(routine, times);
    }

    public static Routine wander(Board board) {
        return new Wander(board);
    }

}
