package Appliances;

import Commands.*;

import java.util.*;

public class CommandHandler {
    private static final String ERR_MSG = "Command not found";
    private Queue queue;
    private Map<String, Command> commands;

    public CommandHandler(){
        commands = new TreeMap<>();
        Command cmd = new History();
        commands.put(cmd.getName(), cmd);
        cmd = new Help();
        commands.put(cmd.getName(), cmd);
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        queue = new LinkedList();
        System.out.println("Приветствие!!! @Допиши сюда что-то хорошее@ ");
        do {
            try {
                System.out.print("> ");
                String str = scanner.nextLine();
                ParsedCommand pc = new ParsedCommand(str);
                if (pc.command == null || "".equals(pc.command)) {
                    continue;
                }
                Command cmd = commands.get(pc.command.toUpperCase());
                if (cmd == null) {
                    System.out.println(ERR_MSG);
                    continue;
                }
                result = cmd.execute(pc.args);
                System.out.println(str);
                if(queue.size() == 8){
                    queue.remove();
                }
                queue.add(str);
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println(ERR_MSG);
            }
        } while (result);
    }

    public Queue getQueue(){
        return queue;
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
