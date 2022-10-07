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
        int deltaX = dest.getX() - this.position.getX() < 0 ? -1 : 1;
        int deltaY = dest.getY() - this.position.getY() < 0 ? -1 : 1;
        int size = Math.abs(dest.getX() - this.position.getX());
        int x = this.position.getX();
        int y = this.position.getY();
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            x += deltaX;
            y += deltaY;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) - Math.abs(source.getY() - dest.getY()) == 0;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
