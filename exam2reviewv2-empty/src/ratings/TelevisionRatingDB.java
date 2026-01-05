package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stores the various ratings of multiple television shows.
 * The database can either be constructed from scratch with
 * the given methods OR read from a file for ease.
 */
public class TelevisionRatingDB implements RatingsDatabase {

  private final Map<Show, List<Stars>> database;
  //INVARIANT: Shows in the database are unique by name
  //INVARIANT: database != null
  //INVARIANT: Every show in the database has a non-empty list

  /**
   * Creates an empty database.
   */
  public TelevisionRatingDB() {
    this.database = new HashMap<>();
  }

  /**
   * Reads the database from a file and populates
   * the database.
   *
   * @param filePath the path to the file
   * @throws IllegalArgumentException filePath is null, does not
   *                                  point to a real file, or the file format is invalid
   */
  public TelevisionRatingDB(String filePath) {
    this(); //Calls the empty constructor for the class
    ensureNonNull(filePath);

    //... assume this constructor reads from the file
    //... and populates the database as needed
  }

  private Stars fromString(String rating) {
    int num = Integer.parseInt(rating);
    switch (num) {
      case 5:
        return Stars.FIVE;
      case 4:
        return Stars.FOUR;
      case 3:
        return Stars.THREE;
      case 2:
        return Stars.TWO;
      case 1:
        return Stars.ONE;
      default:
        throw new RuntimeException("WHAT?!");
    }
  }

  @Override
  public double getTotalAverageRating() {
    ensureDatabaseNotEmpty();

    List<Stars> stars = new ArrayList<>();
    for (Show show : database.keySet()) {
      stars.addAll(database.get(show));
    }

    if (stars.isEmpty()) {
      throw new IllegalStateException("Criteria cannot find any shows");
    }
    return calculateAverageRating(stars);
  }

  //Helper method for subclasses only
  protected double calculateAverageRating(List<Stars> stars) {
    double totalNumRatings = stars.size();
    double totalRated = 0;
    for (Stars rating : stars) {
      totalRated += rating.convertToInteger();
    }
    return totalRated / totalNumRatings;
  }

  private void ensureDatabaseNotEmpty() {
    if (database.isEmpty()) {
      throw new IllegalStateException("Database is empty");
    }
  }

  @Override
  public List<Stars> filterRatings(FilterCriteria crit) {
    ensureNonNull(crit);
    ensureDatabaseNotEmpty();
    List<Stars> ratings = new ArrayList<>();
    for (Show show : database.keySet()) {
      if (crit.shouldRetrieve(show)) {
        ratings.addAll(database.get(show));
      }
    }
    if (ratings.isEmpty()) {
      throw new IllegalStateException("Nothing fits the criteria");
    }
    return ratings;
  }

  @Override
  public List<Show> recommendShows(FilterCriteria crit) {
    ensureNonNull(crit);
    ensureDatabaseNotEmpty();
    List<Show> results = new ArrayList<>();
    for (Show show : database.keySet()) {
      if (crit.shouldRetrieve(show)) {
        results.add(show);
      }
    }

    results.sort(Show::compareTo);
    if (results.isEmpty()) {
      throw new IllegalStateException("Nothing fits the criteria");
    }
    return results;
  }

  @Override
  public void rateShow(Show show, Stars rating) {
    ensureNonNull(show, rating);
    List<Stars> ratingsSoFar = database.getOrDefault(show, new ArrayList<>());
    ratingsSoFar.add(rating);
    database.put(show, ratingsSoFar);
  }

  //Throws an IllegalArgumentException if any of the objects are null
  //Does nothing otherwise
  private void ensureNonNull(Object... objects) {
    for (Object obj : objects) {
      if (obj == null) {
        throw new IllegalArgumentException("Null object in args");
      }
    }
  }
}
