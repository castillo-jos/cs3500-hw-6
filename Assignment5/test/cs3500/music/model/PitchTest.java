package cs3500.music.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Benjamin Reed on 6/8/2017 to test Pitch.
 */
public class PitchTest {
  private Pitch noteC = Pitch.C;
  private Pitch noteCSharp = Pitch.CSharp;
  private Pitch noteD = Pitch.D;
  private Pitch noteDSharp = Pitch.DSharp;
  private Pitch noteE = Pitch.E;
  private Pitch noteF = Pitch.F;
  private Pitch noteFSharp = Pitch.FSharp;
  private Pitch noteG = Pitch.G;
  private Pitch noteGSharp = Pitch.GSharp;
  private Pitch noteA = Pitch.A;
  private Pitch noteASharp = Pitch.ASharp;
  private Pitch noteB = Pitch.B;

  @Test
  public void toStringTest() throws Exception {
    String[] expecteds = new String[12];
    expecteds[0] = "  C";
    expecteds[1] = " C#";
    expecteds[2] = "  D";
    expecteds[3] = " D#";
    expecteds[4] = "  E";
    expecteds[5] = "  F";
    expecteds[6] = " F#";
    expecteds[7] = "  G";
    expecteds[8] = " G#";
    expecteds[9] = "  A";
    expecteds[10] = " A#";
    expecteds[11] = "  B";
    String[] actuals = new String[12];
    actuals[0] = noteC.toString();
    actuals[1] = noteCSharp.toString();
    actuals[2] = noteD.toString();
    actuals[3] = noteDSharp.toString();
    actuals[4] = noteE.toString();
    actuals[5] = noteF.toString();
    actuals[6] = noteFSharp.toString();
    actuals[7] = noteG.toString();
    actuals[8] = noteGSharp.toString();
    actuals[9] = noteA.toString();
    actuals[10] = noteASharp.toString();
    actuals[11] = noteB.toString();
    assertArrayEquals(expecteds, actuals);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badPitch() {
    Pitch p = Pitch.E;
    p.pitch = 13;
    p.toString();
  }

}