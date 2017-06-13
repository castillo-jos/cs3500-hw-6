package cs3500.music.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Benjamin Reed on 6/8/2017 to test Note.
 */
public class NoteTest {
  Note a51 = new Note(Pitch.A, 5, 1);
  Note a72 = new Note(Pitch.A, 7, 2);
  Note a64 = new Note(Pitch.A, 6, 4);
  Note b12 = new Note(Pitch.B, 1, 2);
  Note a82 = new Note(Pitch.A, 8, 2);
  Note a42 = new Note(Pitch.A, 4, 2);
  Note b32 = new Note(Pitch.B, 3, 2);
  Note cS22 = new Note(Pitch.CSharp, 2, 2);

  @Test
  public void overlapsTest() throws Exception {
    boolean[] expecteds = new boolean[6];
    boolean[] actuals = new boolean[6];
    expecteds[0] = false;
    expecteds[1] = false;
    expecteds[2] = false;
    expecteds[3] = true;
    expecteds[4] = true;
    expecteds[5] = true;
    actuals[0] = a51.overlaps(a72);
    actuals[1] = a64.overlaps(b12);
    actuals[2] = b12.overlaps(b32);
    actuals[3] = a42.overlaps(a51);
    actuals[4] = a82.overlaps(a64);
    actuals[5] = a72.overlaps(a82);
    assertArrayEquals(expecteds, actuals);
  }

  @Test
  public void getStartTest() throws Exception {
    int[] expecteds = new int[7];
    int[] actuals = new int[7];
    expecteds[0] = 5;
    expecteds[1] = 7;
    expecteds[2] = 6;
    expecteds[3] = 1;
    expecteds[4] = 8;
    expecteds[5] = 4;
    expecteds[6] = 3;
    actuals[0] = a51.getStart();
    actuals[1] = a72.getStart();
    actuals[2] = a64.getStart();
    actuals[3] = b12.getStart();
    actuals[4] = a82.getStart();
    actuals[5] = a42.getStart();
    actuals[6] = b32.getStart();
    assertArrayEquals(expecteds, actuals);
  }

  @Test
  public void shouldPlayTest() throws Exception {
    boolean[] expecteds = new boolean[6];
    boolean[] actuals = new boolean[6];
    expecteds[0] = false;
    expecteds[1] = false;
    expecteds[2] = false;
    expecteds[3] = true;
    expecteds[4] = true;
    expecteds[5] = true;
    actuals[0] = a51.shouldPlay(6);
    actuals[1] = a64.shouldPlay(5);
    actuals[2] = b12.shouldPlay(3);
    actuals[3] = a42.shouldPlay(4);
    actuals[4] = a82.shouldPlay(9);
    actuals[5] = a72.shouldPlay(8);
    assertArrayEquals(expecteds, actuals);
  }

  @Test
  public void playAtBeatTest() throws Exception {
    String[] expecteds = new String[3];
    String[] actuals = new String[3];
    expecteds[0] = "  X  ";
    expecteds[1] = "  |  ";
    expecteds[2] = "     ";
    actuals[0] = a51.printAtBeat(5);
    actuals[1] = a64.printAtBeat(8);
    actuals[2] = b12.printAtBeat(6);
    assertArrayEquals(expecteds, actuals);
  }

  @Test
  public void toStringTest() throws Exception {
    String[] expecteds = new String[3];
    String[] actuals = new String[3];
    expecteds[0] = "Note:   A Starts at: 5 Ends at: 6";
    expecteds[1] = "Note:  C# Starts at: 2 Ends at: 4";
    expecteds[2] = "Note:   B Starts at: 1 Ends at: 3";
    actuals[0] = a51.toString();
    actuals[1] = cS22.toString();
    actuals[2] = b12.toString();

    assertArrayEquals(expecteds, actuals);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badNote1() {
    Note test = new Note(Pitch.A, 4, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badNote2() {
    Note test = new Note(Pitch.A, -1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badNote3() {
    Note test = new Note(null, 1, 2);
  }

}