package org.example;

/**
 * Durations, with a resolution of seconds. All durations are non-negative.
 * <p>
 * Different {@code Duration} implementations should work together,
 * meaning that:
 * <p>
 * <p>
 * Two durations must be equal if they have the same number of seconds.
 * The hash code of a duration is the result of calling
 * {@link Long#hashCode(long)} on its length in seconds.
 */
public interface Duration extends Comparable<Duration> {
  /**
   * Gets the total duration in seconds.
   *
   * @return the number of seconds (non-negative)
   */
  long inSeconds();

  /**
   * Formats this duration in the form {@code H:MM:SS} where the hours and
   * minutes are both zero-padded to two digits, but the hours are not.
   *
   * @return this duration formatted in hours, minutes, and seconds
   */
  String asHms();

  /**
   * Returns the sum of two durations.
   *
   * @param other the duration to add to {@code this}
   * @return the sum of the durations
   */
  Duration plus(Duration other);
}