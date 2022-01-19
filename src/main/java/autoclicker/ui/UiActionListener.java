package autoclicker.ui;

public interface UiActionListener {
  void startClicked(int minSecondsBetweenClicks, int maxSecondsBetweenClicks);

  void stopClicked();
}
