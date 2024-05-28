import java.util.*;

class CommunicationService {
    private List<String> videoConferences = new ArrayList<>();
    private List<String> chatMessages = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();

    // Simular una videoconferencia
    public void startVideoConference(String patientId, String doctorId) {
        String videoConference = "Video conference started between Patient " + patientId + " and Doctor " + doctorId;
        videoConferences.add(videoConference);
        System.out.println(videoConference);
    }

    public void endVideoConference(String patientId, String doctorId) {
        String videoConference = "Video conference ended between Patient " + patientId + " and Doctor " + doctorId;
        videoConferences.add(videoConference);
        System.out.println(videoConference);
    }

    // Simular un chat
    public void sendMessage(String senderId, String receiverId, String message) {
        String chatMessage = "Chat message from " + senderId + " to " + receiverId + ": " + message;
        chatMessages.add(chatMessage);
        System.out.println(chatMessage);
    }

    public void receiveMessage(String senderId, String receiverId, String message) {
        String chatMessage = "Chat message received by " + receiverId + " from " + senderId + ": " + message;
        chatMessages.add(chatMessage);
        System.out.println(chatMessage);
    }

    // Simular una notificación push
    public void sendNotification(String receiverId, String message) {
        String notification = "Push notification to " + receiverId + ": " + message;
        notifications.add(notification);
        System.out.println(notification);
    }
}
