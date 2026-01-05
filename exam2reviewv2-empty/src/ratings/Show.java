package ratings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Value class representing a television show. Shows
 * are pairs of names and their genres.
 */
public final class Show implements Comparable<Show> {

  private final String name;
  private final List<Genres> genres;

  /**
   * Constructs a show with the given name and genres
   *
   * @param name   the name of the show
   * @param genres the genres of the show
   * @throws IllegalArgumentException if name or genres is null or
   *                                  if genres is empty
   */
  public Show(String name, List<Genres> genres) {
    if (name == null) {
      throw new IllegalArgumentException("Show name cannot be null");
    }
    this.name = name;

    if (genres == null || genres.isEmpty()) {
      throw new IllegalArgumentException("Genres cannot be null or empty");
    }

    this.genres = new ArrayList<>(genres);
  }

  /**
   * Returns the name of the show
   *
   * @return the name of the show
   */
  public String name() {
    return name;
  }

  /**
   * Returns the genres associated with the show
   *
   * @return genres associated with the show
   */
  public List<Genres> genres() {
    return new ArrayList<>(genres);
  }

  /**
   * Returns true if and only if these are shows
   * have the same name and the same genres
   *
   * @param other the other object to compare against.
   * @return true if and only if they represent the same show
   */
  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof Show)) {
      return false;
    }

    Show that = (Show) other;
    return this.name.equals(that.name)
        && this.genres.equals(that.genres);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.genres);
  }

  /**
   * Compares two shows by name, ignoring the case.
   *
   * @param other the object to be compared.
   * @return <0 if this < other
   * =0 if this == other
   * >0 if this > other
   */
  @Override
  public int compareTo(Show other) {
    return this.name.compareToIgnoreCase(other.name);
  }
}
