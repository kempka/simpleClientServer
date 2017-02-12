package simpleGUI_Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Форма ввода.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.2
 * @since JDK1.8
 */
public class ConnectGUI extends JFrame {

    private JButton buttonConn = new JButton("Подключиться");

    public ConnectGUI() {

        // заголовок окна
        setTitle("Клиент");

        // окно будет выглядеть как задумано в ОС
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // окно не изменяемое в размерах
        setResizable(false);

        // задаем размеры окна
        setBounds(500, 100, 235, 120);      // гориз., вертик., ширина, высота.

        // при закрытии окна закрывается поток и само приложение.
        // Если это не указать, то окно закроется, а
        // приложение останется работать в фоновом режиме
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // задаём разметку по умолчанию
        setLayout(new FlowLayout());

        JLabel ip = new JLabel("IP-адрес: ");
        JLabel port = new JLabel("Порт: ");
        JLabel nick = new JLabel("Ваш ник: ");
        JTextField textField_IP = new JTextField("127.0.0.1");
        JTextField textField_Port = new JTextField(String.valueOf("11111"));
        JTextField textField_nick = new JTextField("Jürgen");

        textField_nick.setColumns(10);

        add(ip);
        add(textField_IP);
        add(port);
        add(textField_Port);
        add(nick);
        add(textField_nick);
        add(buttonConn);

        setVisible(true);

        buttonConn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public JButton getButtonConn() {
        return buttonConn;
    }
}
