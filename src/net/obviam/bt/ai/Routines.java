package net.obviam.bt.ai;

import net.obviam.bt.Board;
import net.obviam.bt.Droid;

/**
 * Static convenience methods to create And or Or sequences
 */
public class Routines {

    public static Routine sequenceAnd(Droid droid, Board board, Routine... routines) {
        Sequence sequence = new Sequence(droid, board, Sequence.SequenceType.And);
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine sequenceOr(Droid droid, Board board, Routine... routines) {
        Sequence sequence = new Sequence(droid, board, Sequence.SequenceType.Or);
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine moveTo(Droid droid, Board board, int x, int y) {
        return new MoveTo(droid, board, x, y);
    }

    public static Routine repeatInfinite(Routine routine) {
        return new Repeat(routine);
    }

    public static Routine repeat(Routine routine, int times) {
        return new Repeat(routine, times);
    }

    public static Routine wander(Droid droid, Board board) {
        return new Wander(droid, board);
    }

}
