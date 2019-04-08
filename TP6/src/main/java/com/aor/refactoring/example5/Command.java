package com.aor.refactoring.example5;

public abstract class Command {
    protected Turtle turtle;

    Command(Turtle turtle) {
        this.turtle=turtle;
    }

    public abstract void execute();
}
