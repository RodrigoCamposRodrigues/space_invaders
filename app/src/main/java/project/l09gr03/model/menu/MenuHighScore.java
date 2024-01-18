package project.l09gr03.model.menu;

import java.util.Arrays;
import java.util.List;

public class MenuHighScore extends Menu{

    public MenuHighScore() {
        this.entries = Arrays.asList("Back to menu", "Exit");
    }

    public boolean isSelectedBacktoMenu() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

}
