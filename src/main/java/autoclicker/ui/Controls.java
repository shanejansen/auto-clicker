package autoclicker.ui;

import autoclicker.Utils;

import java.awt.*;
import java.awt.event.InputEvent;

public class Controls {
  private Robot robot;

  public Controls() {
    try {
      this.robot = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  public void click() {
    Point mousePoint = MouseInfo.getPointerInfo().getLocation();
    robot.mouseMove(mousePoint.x, mousePoint.y);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    int millisBetweenPress = Utils.randomBetween(100, 300);
    try {
      Thread.sleep(millisBetweenPress);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
  }
}
