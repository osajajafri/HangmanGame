🔠 Hangman Game – Java GUI Edition 

📌 Overview

This project is a fully functional GUI-based implementation of the classic word-guessing game Hangman, developed in Java Swing. It was created as part of the F27SB: Software Development 2 coursework at Heriot-Watt University for the 2023/24 academic year.
The game challenges players to guess a randomly selected word from a dictionary file, with limited chances to make mistakes. The GUI is dynamic, intuitive, and responsive, built using clean object-oriented design.
________________________________________
🎯 Objective
To develop a single-player GUI-based Hangman game that:

•	Loads words from a file at runtime

•	Tracks correct and incorrect guesses

•	Prevents repeated guesses

•	Offers win/lose feedback and replay option

•	Follows good OOP principles and GUI design patterns

________________________________________
🧩 Gameplay

•	A word is randomly selected at the start of each game.

•	The word is displayed with hidden letters as underscores (_).

•	The user guesses letters via on-screen buttons (A–Z).

•	Correct guesses reveal letters; incorrect guesses reduce the player’s health.

•	The player wins by revealing all letters before running out of incorrect guesses.

•	After a game ends, a dialog offers to restart or quit.

________________________________________
🖥️ GUI Panels
The GUI is modular and divided into three key panels:

✅ WordPanel

•	Displays the hidden word using underscores and reveals correct letters.

•	Updates dynamically after each guess.

✅ ButtonPanel

•	Contains 26 letter buttons (A–Z).

•	Buttons become disabled after being pressed to prevent duplicate guesses.

✅ HealthPanel

•	Displays the number of incorrect guesses left using colored indicators (e.g., green = life, red = lost life).

•	Updates as incorrect guesses occur.

________________________________________
🔧 Technologies Used

•	Java (JDK 11+)

•	Java Swing (JFrame, JPanel, JButton, JLabel, etc.)

•	Object-Oriented Programming principles

•	File I/O (reading words from text file)

________________________________________
📂 Project Structure

src/
├── Main.java           # Contains main method
├── MainWindow.java     # JFrame setup, GUI assembly
├── WordPanel.java      # Displays word with underscores / guessed letters
├── ButtonPanel.java    # Alphabet buttons (A–Z)
├── HealthPanel.java    # Lives tracking and visual feedback
├── WordLoader.java     # Reads word list from file and selects random word
├── assets/
│   └── words.txt       # Dictionary of words (1 word per line)


________________________________________
🧪 Features Summary

Feature	Status ✅

Word loaded randomly from file	✅

Word panel with underscores	✅

Alphabet letter buttons (A–Z)	✅

Buttons disable after click	✅

Incorrect guess tracker (lives)	✅

Game over (win/lose) handling	✅

Restart or exit after game	✅

Clean OOP design & separation	✅
________________________________________
🌟 Optional Extensions (Possible ideas)
These features are not implemented (unless you’ve added them), but can be considered for future work:

•	Dynamic word length selection

•	Language switcher (e.g., English, French)

•	Multiplayer mode (turn-based)

•	Load custom word list from user file picker

•	Save and restore game state

________________________________________
👨‍💻 Developer
Osaja Jafri
BSc Computer Science (AI)
Heriot-Watt University Dubai




