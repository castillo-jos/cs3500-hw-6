package cs3500.music.model;

/**
 * A class representing a note. A note contains 5 things: pitch, octave, isSharp, isPressed, isHeld.
 * Pitch: The pitch that is physically pressed, as in: A, B, C...
 * start: the starting beat for this Note.
 * totalBeats: the total number of beats this note is played for.
 */
public class Note implements INote {
  private Pitch pitch;
  private int start;
  private int totalBeats;

  /**
   * Note constructor.
   * @param pitch the pitch of the note.
   * @param start the starting beat of the note.
   * @param totalBeats the number of beeats the note is held for.
   * */
  public Note(Pitch pitch, int start, int totalBeats) {
    if (pitch == null || start < 0 || totalBeats < 1) {
      throw new IllegalArgumentException("Bad Note!");
    }
    this.pitch = pitch;
    this.start = start;
    this.totalBeats = totalBeats;
  }

  @Override
  public boolean overlaps(Note that) {
    return this.pitch == that.pitch
      && ((this.start + this.totalBeats > that.start && this.start < that.start)
      || (that.start + that.totalBeats > this.start) && that.start < this.start);
  }

  @Override
  public int getStart() {
    return this.start;
  }

  //This override is used for testing.
  @Override
  public String toString() {
    return "Note: " + this.pitch.toString() + " Starts at: " + Integer.toString(start)
      + " Ends at: " + Integer.toString(totalBeats + start);
  }

  @Override
  public boolean shouldPlay(int beat) {
    return start <= beat && beat < start + totalBeats - 1;
  }

  @Override
  public String printAtBeat(int beat) {
    if (this.start == beat) {
      return "  X  ";
    }
    if (this.shouldPlay(beat)) {
      return "  |  ";
    }
    return "     ";
  }

}
