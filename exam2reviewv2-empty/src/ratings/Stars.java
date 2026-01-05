package ratings;

/**
 * Representation of a simple rating system.
 * The lowest rating is 1 star and the highest is 5.
 */
public enum Stars {
  FIVE(5), FOUR(4), THREE(3), TWO(2), ONE(1);

  private final int stars;

  //Constructs one of the five known values
  Stars(int stars) {
    this.stars = stars;
  }

  /**
   * Returns an integer representation of the rating.
   * Useful for mathematical operations
   *
   * @return the number associated with a rating
   */
  public int convertToInteger() {
    return this.stars;
  }

  /**
   * Comparison method not tied to the default implementation
   * in an enum. Returns a number that states the order of the
   * two objects.
   *
   * @param first  the first rating to compare
   * @param second the other rating to compare to
   * @return <0 if first < second
   * =0 if first == second
   * >0 if first > second
   */
  public static int compareRatings(Stars first, Stars second) {
    return first.convertToInteger() - second.convertToInteger();
  }
}
