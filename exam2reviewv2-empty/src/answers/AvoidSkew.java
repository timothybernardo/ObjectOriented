package answers;

import java.util.List;
import ratings.FilterCriteria;
import ratings.RatingsDatabase;
import ratings.Show;
import ratings.Stars;

public class AvoidSkew implements FilterCriteria {
  private final FilterCriteria crit;
  private final Stars rating;
  private final RatingsDatabase db;


  public AvoidSkew(FilterCriteria crit, Stars rating, RatingsDatabase db) {
    if (crit == null || rating == null || db == null) {
      throw new IllegalArgumentException();
    }
    this.crit = crit;
    this.rating = rating;
    this.db = db;
  }

  @Override
  public boolean shouldRetrieve(Show show) {
    List<Stars> ratingList = db.filterRatings((s) -> s.equals(show));
    if (ratingList.isEmpty()) {
      return false;
    }
    double total = 0;
    for (Stars star : ratingList) {
      total += star.convertToInteger();
    }
    double average = total / ratingList.size();
    return crit.shouldRetrieve(show) && average > rating.convertToInteger();
  }
}
