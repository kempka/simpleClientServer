package simpleStringClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Простой сервер получающий от клиента строковое значение.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.1
 * @since JDK1.8
 */
public class ServerString {

    // для удобства создаем систему логирования, которая будет показывать работу сервера
    private static final Logger LOG = Logger.getLogger(ServerString.class.getName());

    public static void main(String[] args) {

        // создаем однопоточный сервер, который начинает прослушку на порту (11111)
        try (ServerSocket serverSocket = new ServerSocket(11111)) {

            // бесконечный цикл обработки подключений от клиентов без штатного завершения
            while (true) {
                try (Socket socket = serverSocket.accept()) {   // дожидаемся следующего подключения

                    // начинаем работать с клиентом
                    serveClient(socket);

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
     * @throws EOFException - клиент закрыл соединение.
     */
    private static void serveClient(Socket socket) throws IOException {

        LOG.info("Serving Client " + socket.getInetAddress());  // логи

        try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                String request = dataInputStream.readUTF();

                LOG.info("Request " + request);

                // отправляем обратно клиенту
                dataOutputStream.writeUTF("Вы отправили: " + request);
                dataOutputStream.flush();
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } // клиент закрыл соединение
    }

}
