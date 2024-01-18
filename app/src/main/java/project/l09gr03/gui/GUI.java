package project.l09gr03.gui;

import java.io.IOException;
import project.l09gr03.model.Position;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawShip(Position position);

    void drawAlien(Position position);

    void drawLaser(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SHOOT}

}
