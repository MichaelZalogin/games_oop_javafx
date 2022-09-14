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
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest));
        }
        int deltaX = dest.getX() - this.position.getX();
        int deltaY = dest.getY() - this.position.getY();
        int size = Math.abs(deltaX);
        int x = position().getX();
        int y = position().getY();
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(x, y);
            x = position().getX() + i;
            y = position().getY() - i;
        }
        return steps;
}

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = Math.abs(source.getX() - dest.getX());
        int deltaY = Math.abs(source.getY() - dest.getY());
        return deltaX - deltaY == 0;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
