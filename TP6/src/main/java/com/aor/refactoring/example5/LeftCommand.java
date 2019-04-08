package com.aor.refactoring.example5;

public class LeftCommand extends Command {
    LeftCommand(Turtle turtle) {
        super(turtle);
    }

    @Override
    public void execute() {
            this.turtle.getDirection().turnLeft();
    }
}
