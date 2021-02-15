package Appliances;

import Commands.*;

import java.util.*;

public class CommandHandler {
    private static final String ERR_MSG = "Command not found";

    private Map<String, Command> commands;

    public CommandHandler(){
        commands = new HashMap<>();
        Command cmd = new History();
        commands.put(cmd.getName(), cmd);
        cmd = new Help();
        commands.put(cmd.getName(), cmd);
        cmd = new Exit();
        commands.put(cmd.getName(), cmd);
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        System.out.println("Приветствие!!! @Допиши сюда что-то хорошее@ ");
        do {
            try {
                System.out.print("> ");
                String str = scanner.nextLine();
                ParsedCommand pc = new ParsedCommand(str);
                if (pc.command == null || "".equals(pc.command)) {
                    continue;
                }
                Command cmd = commands.get(pc.command.toLowerCase());

                if (cmd == null) {
                    System.out.println(ERR_MSG);
                    continue;
                }
                result = cmd.execute(pc.args);

                History history = (History) commands.get("history");
                history.addQueue(str);
                if(history.getSizeQueue() == 9){
                    history.removeQueue();
                }
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println(ERR_MSG);
            }
        } while (result);
    }

    public Map getMap(){
        return commands;
    }

    class ParsedCommand {
        String command;
        String[] args;

        public ParsedCommand(String line) {
            String parts[] = line.split(" ");
            if (parts != null) {
                command = parts[0];
                if (parts.length > 1) {
                    args = new String[parts.length - 1];
                    System.arraycopy(parts, 1, args, 0, args.length);
                }
            }
        }
    }
}
