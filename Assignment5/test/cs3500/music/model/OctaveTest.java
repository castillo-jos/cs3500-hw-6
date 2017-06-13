package cs3500.music.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by Benjamin Reed on 6/8/2017 to test Octave.
 */
public class OctaveTest {
  private Octave octave = new Octave(1);
  private Note cS23 = new Note(Pitch.CSharp, 2 ,3);
  private Note a22 = new Note(Pitch.A, 2 ,2);

  @Before
  public void before() {
    octave.initialize();
  }

  @Test
  public void initializeTest() throws Exception {
    assertEquals(Collections.emptyList(), octave.getNotes().get(Pitch.A));
  }

  @Test
  public void addNoteTest() throws Exception {
    octave.addNote(Pitch.CSharp, 5, 3);
    octave.addNote(Pitch.CSharp, 2, 3);
    octave.addNote(Pitch.CSharp, 8, 1);
    octave.addNote(Pitch.A, 2, 2);
    octave.addNote(Pitch.A, 4, 2);

    assertEquals(2, octave.getNotes().get(Pitch.A).size());
    assertEquals(3, octave.getNotes().get(Pitch.CSharp).size());
    assertEquals(a22.toString(), octave.getNotes().get(Pitch.A).get(0).toString());
    assertEquals(cS23.toString(), octave.getNotes().get(Pitch.CSharp).get(1).toString());

  }

  @Test
  public void removeNoteTest() throws Exception {
    octave.addNote(Pitch.A, 2, 2);
    octave.addNote(Pitch.A, 4, 2);
    octave.addNote(Pitch.B, 4, 2);
    octave.removeNote(Pitch.A, 2);
    octave.removeNote(Pitch.B, 4);

    assertEquals(1, octave.getNotes().get(Pitch.A).size());
  }

  @Test
  public void printNotesTest() throws Exception {
    String expected = "  C1  C#1   D1  D#1   E1   F1  F#1   G1  G#1   A1  A#1   B1 ";
    assertEquals(expected, octave.printNotes());
  }

  @Test
  public void printBeatTest() throws Exception {
    octave.addNote(Pitch.CSharp, 5, 3);
    octave.addNote(Pitch.CSharp, 2, 3);
    octave.addNote(Pitch.CSharp, 8, 1);
    octave.addNote(Pitch.A, 2, 2);
    octave.addNote(Pitch.A, 4, 2);
    String expected = "       |                                       X            ";
    assertEquals(expected, octave.printBeat(4, 100));

  }



  @Test(expected = IllegalArgumentException.class)
  public void badAddNote1() {
    octave.addNote(Pitch.A, 4, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badAddNote2() {
    octave.addNote(Pitch.A, -1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badAddNote3() {
    octave.addNote(null, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badRemoveNote1() {
    octave.removeNote(null, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badRemoveNote2() {
    octave.removeNote(Pitch.A, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badPrint1() {
    octave.printBeat(-1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badPrint2() {
    octave.printBeat(7, 3);
  }


}