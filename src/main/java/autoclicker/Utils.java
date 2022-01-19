package autoclicker;

import java.util.Random;

public class Utils {
  private static final Random random = new Random();

  public static int randomBetween(int min, int max) {
    return random.nextInt(max - min) + min;
  }
}
