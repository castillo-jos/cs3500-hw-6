package cs3500.music.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Benjamin Reed on 6/8/2017 to test KeyBoardModel.
 */
public class KeyBoardModelTest {
  private KeyBoardModel keyBoardModel;
  private String beforeAddingNotes = "   C1  C#1   D1  D#1   E1   F1  F#1   G1  G#1   A1  A#1   B1 "
      + "  C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2  A#2   B2 "
      + "  C3  C#3   D3  D#3   E3   F3  F#3   G3  G#3   A3  A#3   B3 "
      + "  C4  C#4   D4  D#4   E4   F4  F#4   G4  G#4   A4  A#4   B4 "
      + "  C5  C#5   D5  D#5   E5   F5  F#5   G5  G#5   A5  A#5   B5 "
      + "  C6  C#6   D6  D#6   E6   F6  F#6   G6  G#6   A6  A#6   B6 "
      + "  C7  C#7   D7  D#7   E7   F7  F#7   G7  G#7   A7  A#7   B7 "
      + "  C8  C#8   D8  D#8   E8   F8  F#8   G8  G#8   A8  A#8   B8 "
      + "  C9  C#9   D9  D#9   E9   F9  F#9   G9  G#9   A9  A#9   B9 "
      + "  C10 C#10  D10 D#10  E10  F10 F#10  G10 G#10  A10 A#10  B10 \n"
      + "1                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            \n"
      + "2                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            \n"
      + "3                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            "
      + "                                                            \n";

  /**
   * Test the constructor of the KeyBoardModel, giving it 3 beats total.
   * A new keyBoardModel should be used for each test, so that also occurs here.
   * */
  @Before
  public void testConstructor() throws Exception {
    keyBoardModel = new KeyBoardModel(3);

    assertEquals(beforeAddingNotes, keyBoardModel.toString());

  }


  @Test
  public void addNoteTest() throws Exception {
    keyBoardModel.addNote(Pitch.A, 1, 1, 3);
    keyBoardModel.addNote(Pitch.ASharp, 2, 2, 2);
    keyBoardModel.addNote(Pitch.B, 3, 3, 1);
    keyBoardModel.addNote(Pitch.C, 4, 1, 3);
    keyBoardModel.addNote(Pitch.CSharp, 5, 2, 2);
    keyBoardModel.addNote(Pitch.D, 6, 3, 1);
    keyBoardModel.addNote(Pitch.DSharp, 7, 1, 3);
    keyBoardModel.addNote(Pitch.E, 8, 2, 2);
    keyBoardModel.addNote(Pitch.F, 9, 3, 1);
    keyBoardModel.addNote(Pitch.FSharp, 10, 1, 3);
    keyBoardModel.addNote(Pitch.G, 1, 2, 2);
    keyBoardModel.addNote(Pitch.GSharp, 2, 3, 1);
    String expected = "   C1  C#1   D1  D#1   E1   F1  F#1   G1  G#1   A1  A#1   B1 "
        + "  C2  C#2   D2  D#2   E2   F2  F#2   G2  G#2   A2  A#2   B2 "
        + "  C3  C#3   D3  D#3   E3   F3  F#3   G3  G#3   A3  A#3   B3 "
        + "  C4  C#4   D4  D#4   E4   F4  F#4   G4  G#4   A4  A#4   B4 "
        + "  C5  C#5   D5  D#5   E5   F5  F#5   G5  G#5   A5  A#5   B5 "
        + "  C6  C#6   D6  D#6   E6   F6  F#6   G6  G#6   A6  A#6   B6 "
        + "  C7  C#7   D7  D#7   E7   F7  F#7   G7  G#7   A7  A#7   B7 "
        + "  C8  C#8   D8  D#8   E8   F8  F#8   G8  G#8   A8  A#8   B8 "
        + "  C9  C#9   D9  D#9   E9   F9  F#9   G9  G#9   A9  A#9   B9 "
        + "  C10 C#10  D10 D#10  E10  F10 F#10  G10 G#10  A10 A#10  B10 \n"
        + "1                                               X            "
        + "                                                            "
        + "                                                            "
        + "  X                                                         "
        + "                                                            "
        + "                                                            "
        + "                 X                                          "
        + "                                                            "
        + "                                                            "
        + "                                X                           \n"
        + "2                                     X         |            "
        + "                                                    X       "
        + "                                                            "
        + "  |                                                         "
        + "       X                                                    "
        + "                                                            "
        + "                 |                                          "
        + "                      X                                     "
        + "                                                            "
        + "                                |                           \n"
        + "3                                     |         |            "
        + "                                          X         |       "
        + "                                                         X  "
        + "  |                                                         "
        + "       |                                                    "
        + "            X                                               "
        + "                 |                                          "
        + "                      |                                     "
        + "                           X                                "
        + "                                |                           \n";

    assertEquals(expected, keyBoardModel.toString());
  }


  @Test
  public void removeNoteTest() throws Exception {
    keyBoardModel.addNote(Pitch.A, 1, 1, 3);
    keyBoardModel.addNote(Pitch.ASharp, 2, 2, 2);
    keyBoardModel.removeNote(Pitch.A, 1, 1);
    keyBoardModel.removeNote(Pitch.ASharp, 2, 2);
    keyBoardModel.removeNote(Pitch.B, 3, 3);

    assertEquals(beforeAddingNotes, keyBoardModel.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void badAddNote() {
    keyBoardModel.addNote(Pitch.A, 1, 2, 2);
    keyBoardModel.addNote(Pitch.A, 1, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void badOctave() {
    KeyBoardModel badModel = new KeyBoardModel(-1);
  }

}