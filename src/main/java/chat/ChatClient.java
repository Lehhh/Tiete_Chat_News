package chat;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import windows.TelaInicial;
import windows.TelaLogin;

public class ChatClient {

    static public String str;
    public void startChat() throws Exception {

        //
        TelaInicial tI = new TelaInicial();
//        TelaInicial.textFieldForMsg;// = TelaInicial.textFieldForMsg;
//        JLabel jLabelChat = null; //= TelaInicial.jLabelChat;
//        JTextArea chatArea = null;// = TelaInicial.chatArea;;

        //
        new TelaInicial().setVisible(true);
        String ipAddress = JOptionPane.showInputDialog(
                tI,
                "Enter IP Address:",
                "IP Address Required!!",
                JOptionPane.PLAIN_MESSAGE);

        Socket soc = new Socket(ipAddress, 8081);

        tI.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        tI.out = new PrintWriter(soc.getOutputStream(), true);
        
         
        while (true) {

            String str = tI.in.readLine();

            if (str.equals("NAMEREQUIRED")) {

                String name = JOptionPane.showInputDialog(
                        tI,
                        "Enter a unique name:",
                        "Name Required!!",
                        JOptionPane.PLAIN_MESSAGE);

                tI.out.println(name);

            } else if (str.equals("NAMEALREADYEXISTS")) {

                String name = JOptionPane.showInputDialog(
                        tI,
                        "Enter another name:",
                        "Name Already Exits!!",
                        JOptionPane.WARNING_MESSAGE);

                tI.out.println(name);

            } else if (str.startsWith("NAMEACCEPTED")) {
                tI.chatArea.setEditable(false);
                tI.textFieldForMsg.setEditable(true);
                tI.jLabelChat.setText("You are logged in as: " + str.substring(12));
                

            } else {

                tI.chatArea.append(str + "\n");

            }

        }
        
        
    }

}
