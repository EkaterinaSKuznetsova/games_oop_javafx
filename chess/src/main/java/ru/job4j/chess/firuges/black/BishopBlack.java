package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.lang.invoke.MethodType;

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
       if (!isDiagonal(this.position, dest)) {
           throw new ImpossibleMoveException(
                   String.format("Could not way by diagonal from %s to %s", position, dest)
           );
       }
       int size = Math.abs(dest.getX() - this.position.getX());
       Cell[] steps = new Cell[size];
       int deltaX = dest.getX() >= this.position.getX() ? 1 : -1;
       int deltaY = dest.getY() >= this.position.getY() ? 1 : -1;
       int x = this.position.getX();
       int y = this.position.getY();
       for (int i = 0; i < size; i++) {
            x = x + deltaX;
            y = y + deltaY;
           steps[i] = Cell.findBy(x, y);
       }
      return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = Math.abs(source.getX() - dest.getX());
        int deltaY = Math.abs(source.getY() - dest.getY());
        if (deltaX == deltaY) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
