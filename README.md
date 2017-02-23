About
=======
This program takes in a radar image as input and detects any of the known list of space invaders along with their location in the radar image.

Given
------
1. The space invaders list is mentioned in the knownSpaceInvaders.txt file (the patterns are separated by ~~~~~).
2. The radar image is available in the radarImage.txt file.
3. The noise tolerance percentage is mentioned in the application.properties file. A noise tolerance of 0 % means that the match has to be exact.
Please change these as per needs to test different scenarios.

Assumptions
------------
1. This application handles "edge cases".
2. This application handles "noise" in the radar image.

How to run
-----------
1. Compile and execute the class Application.java as a java application.

Results
--------
1. Results are logged on both the console as well as the file system. Look for a sub directory called "logs" in the project root.
2. File system log files thus created are versioned according to date and time of execution.

Notes
------
Total test coverage (unit and integration) is 97%.