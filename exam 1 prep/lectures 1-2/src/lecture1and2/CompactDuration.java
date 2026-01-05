package lecture1and2;

public final class CompactDuration extends AbstractDuration {
  private final long inSeconds;

  public CompactDuration(long inSeconds) {
    if (inSeconds < 0) {
      throw new IllegalArgumentException("Seconds should not be negative");
    }
    this.inSeconds = inSeconds;
  }

  public CompactDuration(int hours, int minutes, int seconds) {
    if (hours < 0 || minutes < 0 || seconds < 0) {
      throw new IllegalArgumentException("Hours, minutes, and seconds should not be negative");
    }
    inSeconds = hours * 3600 + minutes * 60 + seconds;
  }

  @Override
  public long inSeconds() {
    return inSeconds;
  }

  @Override
  public String asHMS() {
    return asHms(hoursOf(inSeconds), minutesOf(inSeconds), secondsOf(inSeconds));
  }

  @Override
  protected Duration fromSeconds(long inSeconds) {
    return new CompactDuration(inSeconds);
  }
}
