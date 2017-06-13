package cs3500.music.model;

/**
 * Enumerator representing the Pitch a note is.
 */
public enum Pitch {
  C(1),
  CSharp(2),
  D(3),
  DSharp(4),
  E(5),
  F(6),
  FSharp(7),
  G(8),
  GSharp(9),
  A(10),
  ASharp(11),
  B(12);

  public int pitch;

  Pitch(int pitch) {
    this.pitch = pitch;
  }

  /**
   * Returns the appropriate string value for this pitch.
   * */
  @Override
  public String toString() {
    switch (pitch) {
      case 1: return "  C";
      case 2: return " C#";
      case 3: return "  D";
      case 4: return " D#";
      case 5: return "  E";
      case 6: return "  F";
      case 7: return " F#";
      case 8: return "  G";
      case 9: return " G#";
      case 10: return "  A";
      case 11: return " A#";
      case 12: return "  B";
      default: throw new IllegalArgumentException("Invalid key in enum Pitch!");
    }
  }

}
