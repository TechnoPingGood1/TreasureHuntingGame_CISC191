package edu.sdccd.cisc191.template.template;

public class NetworkManager {
    private GameClient socketClient;
    private PlayerTimeManager timeManager;
    private long lastTimeSent = 0;
    private long sendInterval = 1000;

    public NetworkManager() {
        timeManager = new PlayerTimeManager(); // Initialize the time manager
    }

    public void startClient(String host) {
        socketClient = new GameClient(host);
        socketClient.start();
        timeManager.startTimer(); // Start the timer when the client starts
    }

    public void sendData(String data) {
        if (socketClient != null) {
            socketClient.sendData(data.getBytes());
        }
    }

    public void updateGameState() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTimeSent >= sendInterval) {
            String playTimeString = "Total time in the Game: " + timeManager.getFormattedPlayTime();
            sendData(playTimeString);
            lastTimeSent = currentTime;
        }
    }

    public void checkGameCompletion() {

    }
}
