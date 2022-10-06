package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BishopBlackTest {

    @Test
    public void whenChangePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell result = bishopBlack.position();
        Cell expected = Cell.C8;
        assertEquals(expected, result);
    }

    @Test
    public void whenCreateCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = Cell.A4;
        assertThat(expected).isEqualTo(bishopBlack.copy(Cell.A4).position());
    }

    @Test
    public void whenWayIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell point = Cell.H8;
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), point)).isTrue();
    }

    @Test
    public void whenIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A7);
        Cell point = Cell.F3;
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), point)).isFalse();
    }

    @Test
    public void whenWayIsNotCorrect() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class, () -> {
                    new BishopBlack(Cell.C1).way(Cell.C3);
                });
        String expected = "Could not move by diagonal from C1 to C3";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}
