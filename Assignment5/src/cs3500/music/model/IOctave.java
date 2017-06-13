package cs3500.music.model;

/**
 * Created by Benjamin Reed on 6/8/2017 to represent an Octave.
 * The octave contains a hasmap of Pitches to a list of Notes, and which octave it is.
 */
public interface IOctave {

  /**
   * Initialize this octave to contain a hashmap of notes, with a list of 'r' chracters.
   * This way, the song length is known via the length of the list of characters.
   * */
  void initialize();

  /**
   * Adds a key press at the starting beat, for the given duration on the input note.
   * @param pitch    the note that will be added.
   * @param start    the starting beat to play said note.
   * @param duration the number of beats the note will be played for.
   *
   * @throws IllegalArgumentException if a note will be overwritten, or on invalid inputs.
   * */
  void addNote(Pitch pitch, int start, int duration) throws IllegalArgumentException;

  /**
   * Removes a given note and the starting beat index.
   * @param pitch the list of pitches to be removed from.
   * @param start the starting beat index to remove it from.
   * @throws IllegalArgumentException if input parameters are invalid.
   * */
  void removeNote(Pitch pitch, int start) throws IllegalArgumentException;

  String printNotes();

  String printBeat(int beat, int totalBeats);
}
