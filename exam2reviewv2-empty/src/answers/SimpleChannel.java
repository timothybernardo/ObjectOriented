package answers;

import java.util.ArrayList;
import java.util.List;
import ratings.FilterCriteria;
import ratings.RatingsDatabase;
import ratings.Show;
import ratings.Stars;

public class SimpleChannel implements Channel {
  private final String name;
  private final List<Show> shows;
  private final RatingsDatabase db;

  public SimpleChannel(String name, RatingsDatabase db) {
    if (name == null || db == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.db = db;
    this.shows = new ArrayList<>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addShow(Show show) {
    if (show == null) {
      throw new IllegalArgumentException();
    }
    if (db.filterRatings((s) -> s.equals(show)).isEmpty()) {
      throw new IllegalStateException();
    }
    shows.add(show);
  }

  @Override
  public double averageRating() {
    return filterRatings((s) -> shows.contains(s));
  }

  @Override
  public double filterRatings(FilterCriteria crit) {
    if (crit == null) {
      throw new IllegalArgumentException();
    }
    try {
      List<Stars> stars = db.filterRatings((s) -> shows.contains(s)
          && crit.shouldRetrieve(s));
      double total = 0;
      for (Stars rating : stars) {
        total += rating.convertToInteger();
      }
      return total / stars.size();
    } catch (IllegalStateException e) {
      return 0;
    }
  }
}

