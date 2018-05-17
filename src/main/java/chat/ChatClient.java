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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import windows.TelaInicial;
import windows.MainClass;

public class ChatClient {

    static public String str;
    public void startChat() throws Exception {

        //
        TelaInicial tI = new TelaInicial();
        String str ="";

        String password = "";
        //
        try {
        	
        
        String ipAddress = "18.231.107.109";

        Socket soc = new Socket(ipAddress, 8081);

        tI.in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        tI.out = new PrintWriter(soc.getOutputStream(), true);
        }
        catch(Exception e) {
        	startChat();
        }
        
        while (true) {

            str = tI.in.readLine();

            if (str.equals("NAMEREQUIRED")) {

                String name = JOptionPane.showInputDialog(
                        tI,
                        "Insira seu usuário:",
                        "Usuário!!",
                        JOptionPane.PLAIN_MESSAGE);

                tI.out.println(name);

            } else if (str.equals("Usuario não Existe")) {

                String name = JOptionPane.showInputDialog(
                        tI,
                        "Tente Novamente:",
                        "Usuário não existe",
                        JOptionPane.WARNING_MESSAGE);

                tI.out.println(name);

            } else if (str.startsWith("NAMEACCEPTED")) {
            	
            	JLabel label = new JLabel("Digite a senha:");
            	JPasswordField jpf = new JPasswordField();
            	JOptionPane.showConfirmDialog(null,
            	new Object[]{label, jpf}, "Password:",
            	JOptionPane.OK_CANCEL_OPTION); 
            	password = jpf.getText();
            	System.out.println(password);
            	
                tI.out.println(password);
                str = tI.in.readLine();
                if (str.startsWith("PasswordACCEPT")) {
            	 new TelaInicial().setVisible(true);
                tI.chatArea.setEditable(false);
                tI.textFieldForMsg.setEditable(true);
                tI.jLabelChat.setText("You are logged in as: " + str.substring(14));
                }

            } else {

                tI.chatArea.append(str + "\n");

            }

        }
        
    }

}
