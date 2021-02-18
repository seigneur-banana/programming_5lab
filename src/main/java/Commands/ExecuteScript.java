package Commands;

import Appliances.CommandHandler;
import Appliances.ParsedCommand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExecuteScript implements Command{
    @Override
    public boolean execute(String... args) {
        boolean result = true;
        if (args.length == 1) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String line;
                CommandHandler commandHandler = new CommandHandler();
                Map<String, Command> commands = commandHandler.getMap();

                do{
                    line = reader.readLine();
                    ParsedCommand pc = new ParsedCommand(line);
                    Command cmd = commands.get(pc.getCommand().toLowerCase());
                    if (cmd == null) {
                        System.out.println(commandHandler.getErrMsg() + " in execute");
                        continue;
                    }
                    result = cmd.execute(pc.getArgs());

                }while (line != null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }else return false;

    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return " file_name : считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, " +
                "в котором их вводит пользователь в интерактивном режиме.";
    }
}

