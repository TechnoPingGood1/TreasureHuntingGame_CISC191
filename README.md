# CISC191
Intermediate Java Programming Final Project Template
## Prerequisites
1. Maven
2. Git
3. JDK 1.8
## Building
mvn clean install
## Running
java -jar Server/target/Server-1.0.0.jar  
java -jar Client/target/Client-1.0.0.jar
## Common Module
Shared classes between client and server modules.
## Server Module
The server application that handles multiple clients.
## Client Module
The client application used to connect to the server.

## Module 1
A 1D array is used to store and manage game objects and sounds 
that are accessed during gameplay.
## Module 2
The game uses a 2D array to display a map loaded from a text file,
store the map data, and handle collision detection between the player
and game objects based on their x and y coordinates. This demonstrates
how the game world layout and interaction logic are managed.
## Module 3
This module is not demonstrated in the game.
## Module 4
Object-oriented principles are applied by organizing the data and methods
for each game component into their respective classes. Additionally, child
classes like Key and Door inherit shared properties and behaviors from the
parent class, SuperObject.
## Module 5
The game sends state information, such as playtime, over the network using 
serialization.
## Module 6
The project separates the client and server functionality: the Client handles
sending and receiving data, while the Server listens and responds