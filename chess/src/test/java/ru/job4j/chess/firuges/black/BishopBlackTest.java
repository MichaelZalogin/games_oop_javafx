package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell result = bishopBlack.position();
        Cell expected = Cell.C8;
        assertEquals(expected, result);
    }

    @Test
    public void testWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(result, expected);
    }
}