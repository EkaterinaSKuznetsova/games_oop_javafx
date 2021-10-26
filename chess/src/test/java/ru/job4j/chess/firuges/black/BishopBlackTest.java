package ru.job4j.chess.firuges.black;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(bishopBlack.position(), Cell.C1);
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D1);
        Figure rsl = bishopBlack.copy(Cell.D3);
        assertEquals(rsl.position(), Cell.D3);
    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(bishopBlack.way(Cell.G5), rsl);
    }

    @Ignore
    @Test(expected = ImpossibleMoveException.class)
    public void wayImpossibleMoveException() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G1);
    }



}