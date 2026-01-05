package lecture1and2;

// When we want to factor out redundancy between functions, we create a helper function
// and call it from the other functions. When we want to factor out redundancy between classes,
// we create a helper class and refer to it from the other classes.

// Note that AbstractDuration has package scope rather than public,
// because it's an implementation detail shared by our two classes
// but not part of the public API for durations

abstract class AbstractDuration implements Duration {
  @Override
  public int compareTo(Duration o) {
    return Long.compare(this.inSeconds(), o.inSeconds());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Duration other)) {
      return false;
    }
    return this.inSeconds() == other.inSeconds();
  }

  @Override
  public int hashCode() {
    return Long.hashCode(inSeconds());
  }

  @Override
  public String toString() {
    return asHMS();
  }

  // FACTORY METHOD PATTERN -  written a method that has the ability to return
  // objects of several different types, depending on which object was used to call it
  protected abstract Duration fromSeconds(long inSeconds);

  @Override
  public Duration plus(Duration other) {
    return fromSeconds(this.inSeconds() + other.inSeconds());
  }

  protected static String asHms(int hours, int minutes, int seconds) {
    return String.format("%d:%02d:%02d", hours, minutes, seconds);
  }

  protected static int minutesOf(long inSeconds) {
    return (int) (inSeconds / 60 % 60);
  }

  protected static int secondsOf(long inSeconds) {
    return (int) (inSeconds % 60);
  }

  protected static int hoursOf(long inSeconds) {
    if (inSeconds / 3600 > Integer.MAX_VALUE) {
      throw new ArithmeticException("result cannot fit in type");
    }

    return (int) (inSeconds / 3600);
  }

}

