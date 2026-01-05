package org.example;

// Represents an empty plushie collection
class EmptyCollection implements PlushieCollection {

  EmptyCollection() {
  }

  // Adding to empty: just return a new SinglePlushie
  public PlushieCollection add(Plushie p) {
    return new NonEmptyCollection(p, this);
  }

  // No plushies to reduce: return empty
  public PlushieCollection reduceToNonHuggable() {
    return this;
  }

  public PlushieCollection reduceToFluffy() {
    return this;
  }

  public PlushieCollection reduce(IPredicate<Plushie> pred) {
    return this;
  }
}
