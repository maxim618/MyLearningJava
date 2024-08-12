package task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//import static com.javarush.task.task30.task3008.ConsoleHelper.readInt;

public class Server {
    private static Map <String, Connection>connectionMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        if(port!=0){
            System.out.println("Сервер запущен");
        }
            try(ServerSocket socket = new ServerSocket(port)){
                ConsoleHelper.writeMessage("Сервер запущен");
                while (true){
                    new Handler(socket.accept()).start();
                }
            }catch (IOException e){
               e.printStackTrace();
            }



    }
    public static void  sendBroadcastMessage(Message message){
        for(Connection connection:connectionMap.values()){
            try {
                connection.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if(message.getType()!=MessageType.USER_NAME){
                    continue;
                }
                String name = message.getData();
                if(name.isEmpty()){
                    continue;
                }
                if(connectionMap.containsKey(name)){
                    continue;
                }
                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return name;
            }
        }


        private void notifyUsers(Connection connection, String userName) throws IOException{

             for(Map.Entry entry:connectionMap.entrySet()){
                 String name = (String) entry.getKey();
                 if(name!=userName) {connection.send(new Message(MessageType.USER_ADDED, name));}
             }
        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) {
                    String data = message.getData();
                    Message message1 = new Message(MessageType.TEXT, userName + ": " + data);
                    sendBroadcastMessage(message1);
                } else {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                }
            }
        }


        @Override
        public void run() {
            super.run();
            ConsoleHelper.writeMessage("Установлено новое соединение с адресом: " + socket.getRemoteSocketAddress());
            try (Connection connection = new Connection(socket);){
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }


        }
    }
}
