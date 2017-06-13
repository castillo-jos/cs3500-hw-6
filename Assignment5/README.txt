Benjamin Reed

For this assignment, we were tasking with constructing a model of a music creator.
To accomplish this I used 3 interfaces, 3 classes, an Enumerator and 4 test classes.
Interfaces:
IMusicModel 	- Used to contain functions for a MusicCreator that were required to be public.
INote		- Used to contain functions for a Note that were required to be public.
IOctave		- Used to contain functions for an Octave that were required to be public.

Classes:
KeyBoardModel	- Model of a KeyBoard. Represents a 10 octave keyboard.
Note		- Model of a Note. Represents a single note played.
Octave		- Model of an Octave. Represents an on octave of keys to play.

Enumerator:
Pitch		- Enumerator containing the 12 different keys per octave.

How everything interacts:
The KeyBoardModel contains 2 things, an int of how many total beats the song is, and an ArrayList of Octaves.
The totalBeats value is used for multiple things, mainly printing and removing notes.
The ArrayList of octives is a representation of each octave on a keyboard.

In the octave class, you have 2 more pieces of data,
which octave it is (int) and a hashmap relating pitches to an ArrayList of notes.
The octave it is used for printing notes initially, and will likely be needed for producing audio.
The ArrayList of notes is an Arraylist for each pitch, containing each note to be played.

In the Note class, it contains 3 things, its pitch,
the starting beat at which to play it(int), and the number of beats to play it(int).
The pitch is used to print the note, and determine if notes overlap. 
The starting beat is used to determine if the print value should be an X.
The number of beats to play it is used to determine if the print value should be a |.
The starting beat and number of beats are also used to determine if notes overlap.