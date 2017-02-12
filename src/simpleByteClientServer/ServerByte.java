package simpleByteClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Простой сервер получающий от клиента байтовое значение.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.0
 * @since JDK1.8
 */
public class ServerByte {

    // для удобства создаем систему логирования, которая будет показывать работу сервера
    private static final Logger LOG = Logger.getLogger(ServerByte.class.getName());

    public static void main(String[] args) {
        // создаем однопоточный сервер, который начинает прослушку на порту (port)
        try (ServerSocket serverSocket = new ServerSocket(11111)) {

            // бесконечный цикл обработки подключений от клиентов без штатного завершения
            while (true) {
                try (Socket socket = serverSocket.accept()) {   // дожидаемся следующего подключения
                    serveClient(socket);   // начинаем работать с клиентом
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обрабатывающий поступающего клиента.
     *
     * @param socket - сокет.
     */
    private static void serveClient(Socket socket) throws IOException {

        LOG.info("Serving ClientByte " + socket.getInetAddress());

        // создаем стримы
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // в цикле обрабатываем данные полученные от клиента
        while (true) {
            int request = inputStream.read();   // читаем по-байтово

            // если поток байтов закончится (-1), то прекращаем цикл и "отпускаем" клиента
            if (request == -1) {
                break;
            }

            LOG.info("request " + request); // логи

            // возводим в квадрат и возвращаем обратно клиенту
            outputStream.write(request * request);
            outputStream.flush();
        }
    }
}
