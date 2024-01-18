package project.l09gr03.viewer.menu;

import project.l09gr03.viewer.Viewer;
import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.model.Position;
import project.l09gr03.gui.GUI;

public class MenuViewer extends Viewer<MainMenu> {

    public MenuViewer(MainMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(3, 7), "Space Invaders", "#29B01E");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(3, 9 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#AF190C" : "#FFFFFF");
    }

}
