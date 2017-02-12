package simpleGUI_Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Простой сервер получающий от клиента строковое значение.
 * Created by UserBoot on 12.12.2016.
 *
 * @author Kempka
 * @version 1.0.2
 * @since JDK1.8
 */
public class ServerG {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(11111)) {

            // бесконечный цикл обработки подключений от клиентов без штатного завершения
            while (true) {

                // дожидаемся следующего подключения
                try (Socket socket = serverSocket.accept()) {

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

        try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                String request = dataInputStream.readUTF();

                // отправляем обратно клиенту
                dataOutputStream.writeUTF(request);
                dataOutputStream.flush();
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } // клиент закрыл соединение
    }
}
