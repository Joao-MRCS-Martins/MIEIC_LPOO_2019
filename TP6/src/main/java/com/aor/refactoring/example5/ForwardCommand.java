package com.aor.refactoring.example5;

public class ForwardCommand extends Command {
    ForwardCommand(Turtle turtle) {
        super(turtle);
    }

    @Override
    public void execute() {
            this.turtle.getDirection().moveForward();
    }
}
