import java.io.File;

public class Controller {
    public Controller(Viewer gui) {
        gui.setStartButton(e -> {
            File directory = gui.getDirectory();
            RecursiveLister lister = new RecursiveLister(directory);
            lister.list();
            gui.setFilesTextArea(lister.getSb().toString());
        });
    }
}
