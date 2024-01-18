package project.l09gr03.viewer.menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.gui.GUI;

import java.io.IOException;
public class MenuViewerTest {
    private GUI gui;

    private MainMenu menu;

    private MenuViewer menuviewer;

    @BeforeEach
    void TestSetup() {
        gui = Mockito.mock(GUI.class);
        menu=new MainMenu();
        menuviewer = new MenuViewer(menu);
    }

    @Test
    void drawTest() throws IOException {
        menuviewer.draw(gui);
        Mockito.verify(gui, Mockito.times(4)).drawText(Mockito.any(), Mockito.any(), Mockito.any());
    }

}
