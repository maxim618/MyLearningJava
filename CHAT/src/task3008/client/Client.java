package task3008.client;


import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

   protected Connection connection;
   private volatile boolean clientConnected = false;

   protected String getServerAddress(){
     return ConsoleHelper.readString();
   }
   protected int getServerPort(){
       return ConsoleHelper.readInt();
   }
   protected String getUserName(){
       return ConsoleHelper.readString();
   }
   protected boolean shouldSendTextFromConsole(){
       return true;
   }
   protected SocketThread getSocketThread(){
       return new SocketThread();
   }
   protected void sendTextMessage(String text)  {
       try {
           connection.send(new Message(MessageType.TEXT, text));

       }catch (IOException e){
           clientConnected = false;
           ConsoleHelper.writeMessage("Произошла ошибка!");
       }
   }

   public void run(){
       Thread thread = new SocketThread();
       getSocketThread().setDaemon(true);
      getSocketThread().start();
     

      Thread thread1 = new SocketThread();
      thread1.start();
       try {
           synchronized (this) {
               this.wait();
           }
       } catch (InterruptedException e) {
           ConsoleHelper.writeMessage("Wrong");
       }
       if(clientConnected){System.out.println("Соединение установлено. Для выхода наберите команду 'exit'.");}
       else               {System.out.println("Произошла ошибка во время работы клиента.");}
       while (clientConnected){
           String string = ConsoleHelper.readString();
           if(string.equals("exit"))break;
           if(shouldSendTextFromConsole()){
               sendTextMessage(string);
           }
       }
   }




    public  class SocketThread extends Thread{
       protected void processIncomingMessage(String message){
           ConsoleHelper.writeMessage(message);
       }
       protected void informAboutAddingNewUser(String userName){
           ConsoleHelper.writeMessage("пользователь с именем " + userName +  "присоединислся к чату");
       }
       protected void informAboutDeletingNewUser(String userName){
           ConsoleHelper.writeMessage("пользователь с именем " + userName +  "покинул чат");
       }
       protected void notifyConnectionStatusChanged(boolean clientConnected){
          Client.this.clientConnected = clientConnected;
          synchronized (Client.this){
              Client.this.notify();
          }
       }
       protected void clientHandshake() throws IOException, ClassNotFoundException{

           while (true){

                   Message message = connection.receive();
                   if (message.getType() == MessageType.NAME_REQUEST) {
                       String name = getUserName();
                       Message message1 = new Message(MessageType.USER_NAME, name);
                       connection.send(message1);
                   }else
                   if (message.getType() == MessageType.NAME_ACCEPTED) {
                       notifyConnectionStatusChanged(true);
                       break;
                   }else  throw new IOException("Unexpected MessageType");



           }
       }



       protected void clientMainLoop() throws IOException, ClassNotFoundException{

           while (true) {
               Message message = connection.receive();
               if (message.getType() == MessageType.TEXT) {
                   processIncomingMessage(message.getData());
               }else
               if (message.getType() == MessageType.USER_ADDED) {
                   informAboutAddingNewUser(message.getData());
               }else
               if (message.getType() == MessageType.USER_REMOVED) {
                   informAboutDeletingNewUser(message.getData());
               }else throw new IOException("Unexpected MessageType");

           }


       }


       /*
        public void run() {
            try {
                // Создаем соединение с сервером
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));

                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
        */

        @Override
        public void run() {


           try {
               connection = new Connection(new Socket(getServerAddress(),getServerPort()));
               clientHandshake();
               clientMainLoop();
           }catch (IOException|ClassNotFoundException e){
               notifyConnectionStatusChanged(false);
           }

        }
    }


}
