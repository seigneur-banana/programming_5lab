package Commands;

import Appliances.CommandHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Save implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if (args == null) {
            String text = "123\nПроверка связи\nИ не только\nАоавпвжльы";
            try(FileOutputStream fos=new FileOutputStream("out.txt");
                PrintStream printStream = new PrintStream(fos))
            {
                printStream.print(text);
                System.out.println("Запись в файл произведена");
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return " : сохранить коллекцию в файл";
    }
}

