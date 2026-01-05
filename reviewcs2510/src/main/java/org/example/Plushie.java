package org.example;

// Represents a Plushie with a name and properties
class Plushie {
  String name;
  boolean fluffy;
  boolean huggable;

  // Constructor
  Plushie(String name, boolean fluffy, boolean huggable) {
    this.name = name;
    this.fluffy = fluffy;
    this.huggable = huggable;
  }

  // Two plushies are equal if all fields are equal
  boolean samePlushie(Plushie other) {
    return this.name.equals(other.name)
            && this.fluffy == other.fluffy
            && this.huggable == other.huggable;
  }
}
