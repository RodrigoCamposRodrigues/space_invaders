package project.l09gr03.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu{

    public MainMenu() {
        this.entries = Arrays.asList("Start","High Score", "Exit");
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedHighScore()
    {
        return isSelected(1);
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }

}
