package project.l09gr03.controller;

import java.io.IOException;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;

public abstract class Controller<T>
{
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
