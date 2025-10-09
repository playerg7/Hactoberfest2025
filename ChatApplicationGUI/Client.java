import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client {
    private JFrame frame = new JFrame("Chat Application");
    private JTextArea textArea = new JTextArea(20, 50);
    private JTextField textField = new JTextField(50);
    private JButton sendButton = new JButton("Send");

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // GUI setup
        textArea.setEditable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);
        frame.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Action listener for sending messages
        sendButton.addActionListener(e -> sendMessage());
        textField.addActionListener(e -> sendMessage());

        // Thread to read messages from server
        new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    textArea.append(message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        String serverAddress = JOptionPane.showInputDialog("Enter Server IP Address:");
        new Client(serverAddress, 12345);
    }
}
