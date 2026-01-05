package ratings;

import java.util.List;

/**
 * Representative behaviors for a personal database of television
 * show ratings. Allows full customization for retrieving data
 * from the database. Each show in the database is assumed to
 * have at least one rating, if not more.
 */
public interface RatingsDatabase {

  /**
   * Returns the average rating over all shows in the database.
   *
   * @return the average of total stars / total number of stars
   * @throws IllegalStateException if no shows are in the database
   */
  double getTotalAverageRating();

  /**
   * Returns the list of ratings for shows that fit
   * the given criteria.
   *
   * @param crit a function that says if a show should be included
   * @return the list of all ratings for all shows that fit the criteria
   * @throws IllegalStateException if no shows are in the database
   * @throws IllegalStateException if no shows fit the criteria
   */
  List<Stars> filterRatings(FilterCriteria crit);

  /**
   * Returns the list of shows the database recommends
   * based on the given criteria.
   *
   * @param crit a function that says if a show should be included
   * @return the list of all shows that fit the criteria, sorted alphabetically
   * by name, ignoring case
   * @throws IllegalStateException if no shows are in the database
   * @throws IllegalStateException if no shows fit the criteria
   */
  List<Show> recommendShows(FilterCriteria crit);

  /**
   * Adds the given rating to the show.
   * If the show is not present on the channel,
   * it will be added in this method.
   *
   * @param show   the show to rate
   * @param rating the number of stars (1-5) for the show
   * @throws IllegalArgumentException show or ratings is null
   */
  void rateShow(Show show, Stars rating);

}
