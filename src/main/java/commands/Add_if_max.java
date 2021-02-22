package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;

import java.util.Collections;
import java.util.List;

public class Add_if_max implements Command{
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if(args.length == 1){
            int id;
            try{
                id = Integer.parseInt(args[0]);
            }
            catch (Exception e){
                System.out.println("В качестве аргумента не Integer или <0");
                return false;
            }

            if(id < 0 ) return false;
            List<StudyGroup> list = commandHandler.sortGroups();
            Collections.sort(list);

            if(commandHandler.getGroups().size() == 0){
                Command cmd = commandHandler.getCommands().get("add");
                if (cmd.execute(commandHandler, "studygroup")) {
                    list = commandHandler.sortGroups();
                    list.get(0).setId(id);
                } else System.out.println("Команда не выполнена, неверный аргумент(ы)");
            }
            else {
                if (id > list.get(commandHandler.getGroups().size() - 1).getId()) {
                    Command cmd = commandHandler.getCommands().get("add");
                    if (cmd.execute(commandHandler, "studygroup")) {
                        list = commandHandler.sortGroups();
                        list.get(commandHandler.getGroups().size() - 1).setId(id);
                    } else System.out.println("Команда не выполнена, неверный аргумент(ы)");
                }
            }
            return true;
        }
        else return true;
    }

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return " {id_StudyGroup} (с которым вы хотите добавить новый элемент) : добавить новый " +
                "элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
