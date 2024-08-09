package task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            //super.processIncomingMessage(message);
            if (!message.contains(": ")) return;
                String userName = message.split(": ")[0];
                String command = message.replaceFirst(userName + ": ", "");
                Date date = Calendar.getInstance().getTime();
                String format = null;
                switch (command) {
                    case "дата":
                        format = "d.MM.YYYY";
                       
                    case "день":
                        format = "d";
                        break;
                    case "месяц":
                        format = "MMMM";
                        break;
                    case "год":
                        format = "YYYY";
                        break;
                    case "время":
                        format = "H:mm:ss";
                        break;
                    case "час":
                        format = "H";
                        break;
                    case "минуты":
                        format = "m";
                        break;
                    case "секунды":
                        format = "s";
                        break;
                }
                if(format!=null) {
                    sendTextMessage("Информация для " + userName + ": " + new SimpleDateFormat(format).format(date));
                }

            }


    }





    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String str = "date_bot_";
        int x = (int) (Math.random() * 100);
        return str + x;
    }
}
