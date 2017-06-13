package cs3500.music.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a full octave of notes. This class contains:
 * A hashmap, relating a Pitch to a ArrayList of Notes.
 * An int, representing which octave this octave is.
 */
public class Octave implements IOctave {
  private HashMap<Pitch, ArrayList<Note>> notes;
  private int octave;

  /**
   * Constructor for this octave, initializing the hashmap, and assigning its octave.
   * @param octave which octave on the keyboard this octave is.
   * */
  public Octave(int octave) {
    if (octave < 1) {
      throw new IllegalArgumentException("Invalid octave!");
    }
    this.octave = octave;
    this.notes = new HashMap<>();
  }

  @Override
  public void initialize() {

    for (Pitch p : Pitch.values()) {
      ArrayList<Note> emptySheet = new ArrayList<>();
      notes.put(p, emptySheet);
    }
  }

  /**
   * This method is used for testing purposes.
   * It returns the hashmap, used to check the class functions work properly in testing.
   * */
  public HashMap<Pitch, ArrayList<Note>> getNotes() {
    return this.notes;
  }

  @Override
  public void addNote(Pitch pitch, int start, int duration) throws IllegalArgumentException {
    if (pitch == null || start < 0 || duration < 1) {
      throw new IllegalArgumentException("Invalid input arguments in Octave, function addNote");
    }
    Note noteToAdd = new Note(pitch, start, duration);

    Iterator<Note> iterator = this.notes.get(pitch).iterator();
    //iterate through double checking no notes are being overwritten
    while (iterator.hasNext()) {
      Note n = iterator.next();
      if (noteToAdd.overlaps(n)) {
        throw new IllegalArgumentException("Notes of the same pitch cant overlap!");
      }
    }

    this.notes.get(pitch).add(noteToAdd);
  }

  @Override
  public void removeNote(Pitch pitch, int start) throws IllegalArgumentException {
    if (pitch == null || start < 0) {
      throw new IllegalArgumentException("Invalid input arguments in Octave, function removeNote");
    }
    ArrayList<Note> toRemoveFrom = this.notes.get(pitch);

    Iterator<Note> iterator = this.notes.get(pitch).iterator();
    //iterate through double checking no notes are being overwritten
    Note noteToRemove = null;
    while (iterator.hasNext()) {
      Note n = iterator.next();
      if (n.getStart() == start) {
        noteToRemove = n;
      }
    }

    if (noteToRemove != null) {
      this.notes.get(pitch).remove(noteToRemove);
    }

    //notes.put(pitch, toRemoveFrom);
  }

  @Override
  public String printNotes() {
    String retVal = "";
    for (Pitch p : Pitch.values()) {
      retVal += p.toString() + Integer.toString(this.octave);
      if (this.octave < 10) {
        retVal += " ";
      }
    }
    return retVal;
  }

  @Override
  public String printBeat(int beat, int totalBeats) {
    if (beat < 0 || totalBeats < beat) {
      throw new IllegalArgumentException("Beats cannot be less than 0!");
    }
    String retVal = "";
    for (Pitch p : Pitch.values()) {
      List<Note> list = this.notes.get(p);
      boolean needsPrinting = true;
      for (Note n : list) {
        if (n.shouldPlay(beat)) {
          retVal += n.printAtBeat(beat);
          needsPrinting = false;
        }
      }
      if (needsPrinting) {
        retVal += "     ";
      }
    }
    return retVal;
  }



}
