package ratings;

/**
 * Function interface used for filtering in the
 * RatingsDatabase. Note this is only useful for
 * determining if a Show should be selected, not
 * for actually calculating data.
 */
public interface FilterCriteria {

  /**
   * Returns true if the criteria states this show
   * should have its data retrieved
   *
   * @param show the show to decide on
   * @return true iff it passes the criteria
   */
  boolean shouldRetrieve(Show show);

}
