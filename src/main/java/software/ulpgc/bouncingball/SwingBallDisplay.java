package software.ulpgc.bouncingball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class SwingBallDisplay extends JPanel implements BallDisplay {
    private int y;
    private int r;
    private List<Grabbed> listeners = new ArrayList<>();

    @Override
    public void drawBall(int y, int r) {
        this.y = y;
        this.r = r;
        this.repaint();
        this.captureMouseMoves();
    }

    private void captureMouseMoves() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                listeners.forEach(l->l.at(e.getY()));
            }
        });
    }

    @Override
    public void on(Grabbed grabbed) {
        this.listeners.add(grabbed);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
        g.setColor(Color.WHITE);
        g.fillOval((this.getWidth() - r)/ 2, y, r, r);
    }

}
