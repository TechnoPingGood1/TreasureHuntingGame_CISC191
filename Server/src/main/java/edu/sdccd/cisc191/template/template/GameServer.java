package edu.sdccd.cisc191.template.template;

import java.io.IOException;
import java.net.*;

public class GameServer extends Thread {

    private DatagramSocket socket;

    public GameServer() {
        try {
            this.socket = new DatagramSocket(1331);
            System.out.println("Server started on: " + socket.getLocalPort());
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message = new String(packet.getData()).trim();


            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();

            System.out.println("Received from client (" + clientAddress.getHostAddress() + "): " + message);

            sendData(("Server received: " + message).getBytes(), clientAddress, clientPort);
        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method to run the server as a standalone application
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start();
    }
}
