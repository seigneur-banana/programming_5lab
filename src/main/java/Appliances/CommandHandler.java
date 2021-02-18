package Appliances;

import Commands.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class CommandHandler {
    private static final String ERR_MSG = "Command not found";

    private Map<String, Command> commands;
    private Map<Double, Location> locations;
    private Map<Double, Coordinates> coordinates;
    private Map<String, Person> persons;
    private Set<StudyGroup> groups; //ListHashSet

    public CommandHandler(){
        commands = new HashMap<>();
        Command cmd = new History();
        commands.put(cmd.getName(), cmd);
        cmd = new Help();
        commands.put(cmd.getName(), cmd);
        cmd = new Exit();
        commands.put(cmd.getName(), cmd);
        cmd = new Save();
        commands.put(cmd.getName(), cmd);
        cmd = new ExecuteScript();
        commands.put(cmd.getName(), cmd);
        cmd = new Add();
        commands.put(cmd.getName(), cmd);
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствие!!! @Допиши сюда что-то хорошее@ ");
        do {
            try {
                //read();
                System.out.print("> ");
                String str = scanner.nextLine();

                ParsedCommand pc = new ParsedCommand(str);
                if (pc.getCommand() == null || "".equals(pc.getCommand())) {
                    continue;
                }
                Command cmd = commands.get(pc.getCommand().toLowerCase());

                if (cmd == null) {
                    System.out.println(ERR_MSG + " in comHand IF");
                    continue;
                }
                if (!cmd.execute(pc.getArgs())){
                    System.out.println("Команда не выполнена, неверный аргумент(ы)");
                }

                History history = (History) commands.get("history");
                history.addQueue(str);
                if(history.getSizeQueue() == 9){
                    history.removeQueue();
                }
                }
                catch (Exception e){
                    e.printStackTrace();
                    System.out.println(ERR_MSG + " in comHand catch");
                }
        } while (true);
    }

    public void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\AA_ITMO\\prog\\fifth_lab\\in.txt");

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);
            int i;
            StringBuilder s = new StringBuilder();
            while ((i = bufferedInputStream.read()) != -1) {
                s.append((char) i);
                if((char)i == '\n'){
                    String[] columns = s.toString().split(",");
                    System.out.println(s);
                    s.setLength(0);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Map getMap(){
        return commands;
    }
    public String getErrMsg(){
        return ERR_MSG;
    }

}
