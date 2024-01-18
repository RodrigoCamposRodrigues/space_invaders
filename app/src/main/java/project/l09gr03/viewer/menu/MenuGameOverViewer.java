package project.l09gr03.viewer.menu;

import project.l09gr03.gui.GUI;
import project.l09gr03.model.Position;
import project.l09gr03.model.menu.MenuGameOver;
import project.l09gr03.viewer.Viewer;

public class MenuGameOverViewer extends Viewer<MenuGameOver> {

    public MenuGameOverViewer(MenuGameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(3, 7), "Game Over!", "#29B01E");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(3, 9 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#AF190C" : "#FFFFFF");
    }

}
