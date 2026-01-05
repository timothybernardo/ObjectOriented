package lecture1and2;

public class DurationImpl extends AbstractDuration {
  private final int hours;
  private final int minutes;
  private final int seconds;

  public DurationImpl(int hours, int minutes, int seconds) {
    // Initialization: throw exceptions for invalid input, allow overflow to be organized properly

    if (hours < 0 || minutes < 0 || seconds < 0) {
      throw new IllegalArgumentException("Hours, minutes, and seconds should not be negative");
    }
    if (minutes > 59) {
      hours += minutes / 60;
      minutes %= 60;
    }
    if (seconds > 59) {
      minutes += seconds / 60;
      seconds %= 60;
    }

    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public DurationImpl(long seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("must be non-negative");
    }

    this.seconds = secondsOf(seconds);
    this.minutes = minutesOf(seconds);
    this.hours = hoursOf(seconds);
  }

  @Override
  public long inSeconds() {
    return 3600 * hours + 60 * minutes + seconds;
  }

  @Override
  public String asHMS() { // H:MM:SS
    return asHms(hours, minutes, seconds);
  }

  @Override
  protected Duration fromSeconds(long inSeconds) {
    return new DurationImpl(inSeconds);
  }
}
