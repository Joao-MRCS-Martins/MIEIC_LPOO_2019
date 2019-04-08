package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private Direction direction;

    public Turtle(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Direction getDirection() {
        return direction;
    }

    public void execute(Command command) {
        command.execute();
    }
}
