package simpleGUI_Chat;

import simpleGUI_Chat.ClientG;
import simpleGUI_Chat.ConnectGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Запускает чат.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.2
 * @since JDK1.8
 */
public class MainG {

    /**
     * Точка входа.
     *
     * @throws IOException - ошибка ввода-вывода.
     */
    public static void main(String[] args) throws IOException {
        ConnectGUI connect = new ConnectGUI();

        connect.getButtonConn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ClientG();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
