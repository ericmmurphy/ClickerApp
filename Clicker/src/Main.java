import java.awt.*;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JButton button = new JButton();
    ElapsedTime elapsedTime = new ElapsedTime(button);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setPreferredSize(new Dimension(160, 80));

    button.setText("Click");
    button.setFocusable(false);
    button.addActionListener(elapsedTime);
    button.setPreferredSize(new Dimension(146, 40));

    frame.add(button);
    frame.pack();
    frame.setVisible(true);
  }
}