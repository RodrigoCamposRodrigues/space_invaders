package project.l09gr03.viewer.game;

import project.l09gr03.model.game.elements.Element;
import project.l09gr03.gui.GUI;

public interface ElementViewer<T extends Element> {

    void draw(T element, GUI gui);

}
