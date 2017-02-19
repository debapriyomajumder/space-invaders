About
=======
This program takes in a radar image as input and detects any of the known list of space invaders.

Given
------
1. The space invaders list is mentioned as a comma separated list in the application.properties file.
2. The radar image is available in the radarImage.txt file.
Please change these as per needs to test different scenarios.

Assumptions
------------
1. The order in which space invaders are mentioned in the application.properties file is important.
2. If a space invader pattern has already been matched then other "sub" space invader patterns are not matched.
3. This application handles "edge cases".

How to run
-----------
1. Compile and execute the class Application.java as a java application.

Results
--------
1. Results are logged on both the console as well as the file system. Look for a sub directory called "logs" in the project root.
2. File system log files thus created are versioned according to date and time of execution.

Notes
------
Unit test coverage is 52%.