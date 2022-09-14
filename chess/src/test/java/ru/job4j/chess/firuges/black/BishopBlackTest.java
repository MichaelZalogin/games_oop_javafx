package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

    @Test
    public void testWhenChangePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell result = bishopBlack.position();
        Cell expected = Cell.C8;
        assertEquals(expected, result);
    }

    @Test
    public void testWhenCreateCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = Cell.A4;
        assertEquals(expected, bishopBlack.copy(Cell.A4).position());
    }

    @Test
    public void testWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(result, expected);
    }

    @Test
    public void testWhenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell point = Cell.H8;
        assertTrue(bishopBlack.isDiagonal(bishopBlack.position(), point));
    }

    @Test
    public void testWhenIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A7);
        Cell point = Cell.F3;
        assertFalse(bishopBlack.isDiagonal(bishopBlack.position(), point));
    }
}