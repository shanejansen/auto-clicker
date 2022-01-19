package autoclicker.ui;

import javax.swing.*;
import java.awt.*;

public class Ui {
  private final UiActionListener uiActionListener;

  public Ui(UiActionListener uiActionListener) {
    this.uiActionListener = uiActionListener;
  }

  public void display() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);

    // Options panel
    JPanel optionsPanel = new JPanel();
    JLabel minSecondsLbl = new JLabel("Min seconds between clicks:");
    JTextField minSecondsTf = new JTextField(10);
    JLabel maxSecondsLbl = new JLabel("Max seconds between clicks:");
    JTextField maxSecondsTf = new JTextField(10);
    optionsPanel.add(minSecondsLbl);
    optionsPanel.add(minSecondsTf);
    optionsPanel.add(maxSecondsLbl);
    optionsPanel.add(maxSecondsTf);

    // Start/stop panel
    JPanel startPanel = new JPanel();
    JButton startBtn = new JButton("Start");
    startBtn.addActionListener(e -> {
      try {
        uiActionListener.startClicked(Integer.parseInt(minSecondsTf.getText()), Integer.parseInt(maxSecondsTf.getText()));
      } catch (NumberFormatException ignored) {
      }
    });
    JButton stopBtn = new JButton("Stop");
    stopBtn.addActionListener(e -> uiActionListener.stopClicked());
    startPanel.add(startBtn);
    startPanel.add(stopBtn);

    frame.getContentPane().add(BorderLayout.CENTER, optionsPanel);
    frame.getContentPane().add(BorderLayout.SOUTH, startPanel);
    frame.setVisible(true);
  }
}
