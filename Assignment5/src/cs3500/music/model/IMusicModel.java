package cs3500.music.model;

/**
 * This interface is used to represent different functionalities inside writing music.
 * Should other instruments need to be coded, they would implement this interface.
 * */
public interface IMusicModel {

  /**
   * A boolean that determines if the song is over.
   * */
  boolean isSongOver();

  /**
   * A void function that edits input octaves hashmap to add the given note.
   * @param pitch the pitch of the note to add
   * @param octave which octave to add the note to
   * @param startBeat the initial press beat
   * @param beatsHeld how many beats the note is HELD for, 1 = quarter measure, 2 = half measure
   * */
  void addNote(Pitch pitch, int octave, int startBeat, int beatsHeld);

  /**
   * A void function that edits input octaves hashmap to remove the given note.
   * @param pitch the pitch of the note to remove
   * @param octave which octave to remove the note from
   * @param startBeat the initial press beat
   * */
  void removeNote(Pitch pitch, int octave, int startBeat);
}
