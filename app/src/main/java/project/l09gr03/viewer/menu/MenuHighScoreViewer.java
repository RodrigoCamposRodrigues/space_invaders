package project.l09gr03.viewer.menu;

import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.Position;
import project.l09gr03.model.menu.MenuGameOver;
import project.l09gr03.model.menu.MenuHighScore;
import project.l09gr03.viewer.Viewer;

public class MenuHighScoreViewer extends Viewer<MenuHighScore> {

    public MenuHighScoreViewer(MenuHighScore menuHighScore) {
        super(menuHighScore);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(1, 7), "Highest score: " + Game.getHighScore(), "#29B01E");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(1, 9 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#AF190C" : "#FFFFFF");
    }

}
