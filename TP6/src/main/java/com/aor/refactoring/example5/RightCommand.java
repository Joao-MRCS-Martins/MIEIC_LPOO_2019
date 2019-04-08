package com.aor.refactoring.example5;

public class RightCommand extends Command {
    RightCommand(Turtle turtle) {
        super(turtle);
    }

    @Override
    public void execute() {
            this.turtle.getDirection().turnRight();
    }
}
