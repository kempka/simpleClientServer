package simpleByteClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Простой клиент, который отправляет на сервер байтовое значение,
 * а обратно получает квадрат отправленного числа.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.0
 * @since JDK1.8
 */
public class ClientByte {
    public static void main(String[] args) {

        // создаем сокет (IP, порт) и устанавливаем TCP соединение
        try (Socket socket = new Socket("127.0.0.1", 11111)) {

            // если попытка подключения прошла успешно, то начинается обмен данными.
            // канал: от клиента к серверу.
            OutputStream outputStream = socket.getOutputStream();

            // то, что отправляем к серверу (request).
            // в скобках - байты.
            outputStream.write(2);

            // сброс буферов, чтобы все данные ушли.
            outputStream.flush();

            // канал: от сервера к клиенту.
            InputStream inputStream = socket.getInputStream();

            // то, что получаем с сервера (response).
            int response = inputStream.read();

            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
