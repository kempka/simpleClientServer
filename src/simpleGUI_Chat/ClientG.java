package simpleGUI_Chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Простой клиент, который отправляет на сервер строковое значение,
 * а обратно получает обработанный ответ сервера.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.2
 * @since JDK1.8
 */
public class ClientG extends ChatGUI {
    public ClientG() throws IOException {

        Socket socket = new Socket("127.0.0.1", 11111);

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        // курсор в окне "getTextArea_mini"
        getTextArea_mini().requestFocusInWindow();
        String name = "Jürgen";
        out.writeUTF("Вошёл клиент с сокетом: " + socket.getInetAddress() + ":" + socket.getPort() + "\nи именем: " + name + "\n");
        out.flush();
        getTextArea().append(in.readUTF() + "\n");

        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.writeUTF(name + ": " + getTextArea_mini().getText());
                    out.flush();
                    getTextArea().append(in.readUTF() + "\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
