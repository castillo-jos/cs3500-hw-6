package cs3500.music.model;

/**
 * Created by Benjamin Reed on 6/8/2017 to represent a Note.
 * A Note contains a Pitch, its start beat, and how long it is played for.
 */
public interface INote {

  /**
   * Returns a boolean value determining if this note overlaps the input note.
   * @param that the Note comparing this note against.
   * */
  boolean overlaps(Note that);

  /**
   * Returns the starting beat for this note.
   * */
  public int getStart();

  /**
   * Returns a boolean value that indicates if this note should be played.
   * @param beat the beat at which to determine if the note should be played.
   * */
  public boolean shouldPlay(int beat);

  /**
   * Returns a string of this note, dependant on if the note should be played.
   * If the note should be played, check if it was pressed initially or held.
   * @param beat the beat at which to determine the return string.
   * */
  public String printAtBeat(int beat);
}
