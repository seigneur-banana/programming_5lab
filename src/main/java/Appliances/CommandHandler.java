package Appliances;

import Commands.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class CommandHandler {
    private static final String ERR_MSG = "Command not found";

    private Queue<String> history;
    private Map<String, Command> commands;
    private Map<Integer, Location> locations;
    private Map<Integer, Coordinates> coordinates;
    private Map<Integer, Person> persons;
    private Set<StudyGroup> groups; //ListHashSet

    public CommandHandler(){
        history = new LinkedList<>();
        commands = new HashMap<>();
        coordinates = new HashMap<>();
        locations = new HashMap<>();
        persons = new HashMap<>();
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
                    if (!cmd.execute( get(), pc.getArgs())){
                        System.out.println("Команда не выполнена, неверный аргумент(ы)");
                    }

                    history.add(str);
                    if(history.size() == 9){
                        history.remove();
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

    public Map<String, Command> getCommands(){
        return commands;
    }
    public Queue<String> getHistory(){
        return history;
    }
    public Map<Integer, Location> getLocations(){
        return locations;
    }
    public Map<Integer, Coordinates> getCoordinates(){
        return coordinates;
    }
    public Map getPersons(){
        return persons;
    }
    private Set getGroups(){
        return groups;
    }
    public String getErrMsg(){
        return ERR_MSG;
    }
    private CommandHandler get(){
        return this;
    }
    public void setLocations(Integer y, Float x, String name){
        Location tmp = new Location(y,x,name);
        locations.put(locations.size(), tmp);
    }
    public void setPersons(String name, int height, Color eyeColor, Color hairColor, Country nationality, Location location){
        Person tmp = new Person(name, height, eyeColor, hairColor, nationality, location);
        persons.put(persons.size(), tmp);
    }
    public void setCoordinates(Double y, double x){
        Coordinates tmp = new Coordinates(x, y);
        coordinates.put(coordinates.size(), tmp);
    }
    public void setGroups(Set groups1){
        this.groups = groups1;
    }

}
