import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AUTO_DISPLAY extends JPanel implements ActionListener {
    AVG_AUTO runner;
    public AUTO_DISPLAY(AVG_AUTO runner) {
        this.runner = runner;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(runner.WIDTH + 17, runner.HEIGHT + 40);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(this);
        Timer t = new Timer(16, this);
        t.restart();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < runner.getBoard().length; row++) {
            for (int col = 0; col < runner.getBoard()[row].length; col++) {
                Color color = new Color(0, runner.getBoard()[row][col], runner.getBoard()[row][col]);
                g.setColor(color);
                g.drawRect(col, row, 1, 1);
            }
        }
        runner.nextInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
