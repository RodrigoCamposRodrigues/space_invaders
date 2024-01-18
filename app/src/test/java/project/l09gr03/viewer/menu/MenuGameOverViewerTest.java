package project.l09gr03.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.menu.MenuGameOver;

import java.io.IOException;

public class MenuGameOverViewerTest {

    private GUI gui;

    private MenuGameOver menu;

    private MenuGameOverViewer menuViewer;

    @BeforeEach
    void TestSetup() {
        gui = Mockito.mock(GUI.class);
        menu = new MenuGameOver();
        menuViewer = new MenuGameOverViewer(menu);
    }

    @Test
    void drawTest() throws IOException {
        menuViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawText(Mockito.any(), Mockito.any(), Mockito.any());
    }
}
