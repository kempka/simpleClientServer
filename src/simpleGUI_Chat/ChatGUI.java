package simpleGUI_Chat;

import javax.swing.*;
import java.awt.*;

/**
 * Графическая оболочка чата.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.2
 * @since JDK1.8
 */
class ChatGUI extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JTextArea textArea_mini = new JTextArea();
    private JButton button = new JButton("Отправить");

    JTextArea getTextArea() {
        return textArea;
    }

    JTextArea getTextArea_mini() {
        return textArea_mini;
    }

    JButton getButton() {
        return button;
    }

    ChatGUI() {
        setTitle("Пиши!");

        // окно будет выглядеть как задумано в ОС
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
        setResizable(false);

        // гориз., вертик., ширина, высота.
        setBounds(500, 100, 250, 320);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        textArea.setColumns(45); // ширина textArea
        textArea.setRows(20);  // высота textArea
        textArea_mini.setColumns(25);
        textArea_mini.setRows(2);

        add(textArea);
        add(textArea_mini);
        add(button);
    }
}
