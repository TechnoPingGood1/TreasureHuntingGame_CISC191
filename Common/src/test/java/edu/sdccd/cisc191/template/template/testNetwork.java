package edu.sdccd.cisc191.template.template;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.*;

class testNetwork {

    private static final String data = "localhost";
    private static final int port = 1331;

    @Test
    void testTimeDataSent() throws IOException {
        Thread serverThread = new Thread(() -> {
            try (DatagramSocket serverSocket = new DatagramSocket(port)) {
                byte[] receive = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
                serverSocket.receive(receivePacket);
                String receivedMessage = new String(receivePacket.getData()).trim();

                System.out.println("Received: " + receivedMessage);

                //Send back to client
                byte[] sendData = receivedMessage.getBytes();
                InetAddress address = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, clientPort);
                serverSocket.send(sendPacket);

            } catch(IOException e){
                e.printStackTrace();}
        });
        serverThread.start();

        //Start client and send time data
        NetworkManager manager = new NetworkManager();
        manager.startClient(data);

        manager.updateGameState();

        // Ensure that data has been sent to the server
        assertNotNull(manager);

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}