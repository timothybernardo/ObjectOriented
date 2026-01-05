package org.example;

/**
 * Durations represented compactly, with a range of 0 to
 * 2^63-1 seconds.
 */
public final class CompactDuration extends AbstractDuration {
  /**
   * Constructs a duration in terms of its length in seconds.
   *
   * @param inSeconds the number of seconds (non-negative)
   * @throws IllegalArgumentException {@code inSeconds} is negative
   */
  private final long inSeconds;

  public CompactDuration(long inSeconds) {
    if (inSeconds < 0) {
      throw new IllegalArgumentException("must be non-negative");
    }

    this.inSeconds = inSeconds;
  }

  /**
   * Constructs a duration in terms of its length in hours, minutes, and
   * seconds.
   *
   * @param hours   the number of hours
   * @param minutes the number of minutes
   * @param seconds the number of inSeconds
   * @throws IllegalArgumentException if any argument is negative
   */
  public CompactDuration(int hours, int minutes, int seconds) {
    if (hours < 0 || minutes < 0 || seconds < 0) {
      throw new IllegalArgumentException("must be non-negative");
    }

    inSeconds = 3600 * hours + 60 * minutes + seconds;
  }

  protected Duration fromSeconds(long inSeconds) {
    return new CompactDuration(inSeconds);
  }

  @Override
  public long inSeconds() {
    return inSeconds;
  }
  
  @Override
  public String asHms() {
    return asHms(hoursOf(inSeconds),
            minutesOf(inSeconds),
            secondsOf(inSeconds));
  }
}
