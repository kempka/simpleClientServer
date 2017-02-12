package simpleStringClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Простой клиент, который отправляет на сервер строковое значение,
 * а обратно получает обработанный ответ сервера.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.1
 * @since JDK1.8
 */
public class ClientString {
    public static void main(String[] args) {

        // создаем сокет (IP, порт) и устанавливаем TCP соединение
        try (Socket socket = new Socket("127.0.0.1", 11111)) {

            // если попытка подключения прошла успешно, то начинается обмен данными.
            // оболочка для преобразования примитивных типов (String) в байты.
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());    // канал: от клиента к серверу.

            // отправляем к серверу (request) разложенную на байты строку.
            dataOutputStream.writeUTF("Привет!");

            // сброс буферов, чтобы все данные ушли.
            dataOutputStream.flush();

            // канал: от сервера к клиенту.
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            // то, что получаем с сервера (response).
            String response = dataInputStream.readUTF();

            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
