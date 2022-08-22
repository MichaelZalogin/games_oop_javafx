package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        Cell[] array = new Cell[0];
        if (((dest.getX() - dest.getY()) == 1 && (dest.getY() - dest.getX()) == -1)
                || ((dest.getX() - dest.getY()) == -1 && (dest.getY() - dest.getX()) == 1)) {
//        boolean a = this.position == dest;
        } else {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        return array;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
