package cs3500.music.model;

import java.util.ArrayList;

/**
 * The Interface IMusicModel is used to have general functions for musical instruments.
 * This class is specifically for a KeyBoard implementation.
 */
public class KeyBoardModel implements IMusicModel {
  private int beats;
  private ArrayList<Octave> keyboard;

  /**
   * Constructor for the KeyBoardModel class
   * @param beats the total number of beats for this class.
   * */
  public KeyBoardModel(int beats) {
    if (beats < 1) {
      throw new IllegalArgumentException("Bad total beats!");
    }
    this.beats = beats;
    this.keyboard = new ArrayList<>();

    Octave octave;
    for (int i = 1; i <= 10; i++) {
      octave = new Octave(i);
      octave.initialize();
      keyboard.add(octave);
    }

  }

  @Override
  public boolean isSongOver() {
    return false; //Song is never over at the current level of implementation.
  }

  @Override
  public void addNote(Pitch pitch, int octave, int startBeat, int beatsHeld) {
    keyboard.get(octave - 1).addNote(pitch, startBeat, beatsHeld);
  }

  @Override
  public void removeNote(Pitch pitch, int octave, int startBeat) {
    keyboard.get(octave - 1).removeNote(pitch, startBeat);
  }

  @Override
  public String toString() {
    String retVal = "";
    for (int i = 0; i <  Integer.toString(beats).length(); i++) {
      retVal += " ";
    }
    for (Octave o : keyboard) {
      retVal += o.printNotes();
    }
    retVal += " \n";
    for (int i = 1; i <= this.beats; i++) {
      retVal += Integer.toString(i);
      for (Octave o : keyboard) {
        retVal += o.printBeat(i, this.beats);
      }
      retVal += "\n";
    }
    return retVal;
  }
}
