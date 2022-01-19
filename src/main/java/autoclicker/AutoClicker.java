package autoclicker;

import autoclicker.ui.Controls;
import autoclicker.ui.Ui;
import autoclicker.ui.UiActionListener;

import java.util.Random;

public class AutoClicker implements UiActionListener {
  private final Controls controls;
  private boolean running;

  public AutoClicker() {
    this.controls = new Controls();
    this.running = false;
  }

  public void start() {
    Ui ui = new Ui(this);
    ui.display();
  }

  @Override
  public void startClicked(int minSecondsBetweenClicks, int maxSecondsBetweenClicks) {
    if (running) return;
    running = true;
    new Thread(() -> {
      while (running) {
        int millisBetweenClicks = Utils.randomBetween(minSecondsBetweenClicks, maxSecondsBetweenClicks) * 1000;
        try {
          Thread.sleep(millisBetweenClicks);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        controls.click();
      }
    }).start();
  }

  @Override
  public void stopClicked() {
    running = false;
  }
}
