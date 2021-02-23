package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;

import java.util.Collections;
import java.util.List;

public class Print_descending implements Command {
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if(args == null){
            List<StudyGroup> list = commandHandler.sortGroups();
            Collections.sort(list, Collections.reverseOrder());

            /* Sorted List in reverse order
            for(StudyGroup group: list){
                System.out.println(group);
            }*/
            System.out.println("Descending StudyGroup : " + list);
            return true;
        }
        else return false;
    }

    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String getDescription() {
        return " : вывести элементы коллекции в порядке убывания";
    }
}
