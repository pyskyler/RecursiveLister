import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class Viewer extends JFrame {

    JTextArea filesTextArea = new JTextArea();
    JButton quitButton = new JButton("Quit");
    JButton startButton = new JButton("Start");

    public Viewer() {
        setTitle("Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel labelPanel = new JPanel();

        JLabel label = new JLabel("Files Lister");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("Avenir Next", Font.BOLD, 24));

        labelPanel.add(label);
        panel.add(labelPanel);

        panel.add(startButton);

        JScrollPane filesScrollPane = new JScrollPane(filesTextArea);
        filesScrollPane.setPreferredSize(new Dimension(600, 400));
        filesTextArea.setEditable(false);

        panel.add(filesScrollPane);

        quitButton.addActionListener(e -> System.exit(0));
        panel.add(quitButton);

        add(panel);

        setVisible(true);
    }

    public void setFilesTextArea(String string) {
        filesTextArea.setText(string);
    }

    public void setStartButton(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public File getDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        return fileChooser.getSelectedFile();
    }
}
