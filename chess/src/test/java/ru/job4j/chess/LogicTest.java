package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C8);
        logic.add(bishopBlack);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    logic.move(Cell.C8, Cell.C7);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C8 to C7");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Figure kingBlack = new KingBlack(Cell.B7);
        logic.add(kingBlack);
        logic.add(bishopBlack);
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> {
                    logic.move(Cell.C8, Cell.A6);
                });
        assertThat(exception.getMessage()).isEqualTo("Cell is occupied");
    }

    @Test
    public void whenValidMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell source = Cell.C8;
        Cell dest = Cell.A6;
        Figure bishopBlack = new BishopBlack(source);
        logic.add(bishopBlack);
        logic.move(source, dest);
        Cell actual = logic.getFigures()[0].position();
        assertThat(actual).isEqualTo(dest);
    }
}