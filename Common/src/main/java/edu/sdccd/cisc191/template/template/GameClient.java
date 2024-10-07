package edu.sdccd.cisc191.template.template;

import java.io.IOException;
import java.net.*;

/**
 * The GameClient class represents a client that communicates with a server
 * using the UDP protocol. It sends and receives data packets and runs on a separate thread.
 */
public class GameClient extends Thread {

    private InetAddress ipAddress;
    private DatagramSocket socket;

    /**
     * Constructs a GameClient that connects to a server via the provided IP address.
     * Also prints the local IP address of the client.
     *
     * @param ipAddress The IP address of the game server.
     */
    public GameClient(String ipAddress) {
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
            // Retrieve and print the local IP address of the client
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Client running on local IP: " + localAddress.getHostAddress());
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * Continuously listens for incoming packets from the server and prints the received message.
     * This method runs in a separate thread.
     */
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);  // Receive response from the server
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server > " + new String(packet.getData()).trim());
        }
    }

    /**
     * Sends data to the server as a byte array via UDP.
     *
     * @param data The byte array to be sent to the server.
     */
    public void sendData(byte[] data) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 1331);
        try {
            socket.send(packet);  // Send data to the server
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
