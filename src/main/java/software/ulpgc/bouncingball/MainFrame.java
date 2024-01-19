package software.ulpgc.bouncingball;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BallDisplay display;

    public MainFrame() throws HeadlessException {
        this.setTitle("Bouncing Ball");
        this.setSize(400,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createBallDisplay());
    }

    public BallDisplay getDisplay() {
        return display;
    }

    private Component createBallDisplay() {
        SwingBallDisplay display = new SwingBallDisplay();
        this.display = display;
        return display;
    }
}
