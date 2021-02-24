package commands;

import appliances.CommandHandler;
import appliances.StudyGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Save implements Command {
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if (args == null) {
            try (PrintWriter writer = new PrintWriter(new File("in.csv"))) {
                StringBuilder sb = new StringBuilder();

                for (StudyGroup temp : commandHandler.getGroups()) {
                    sb.append(temp.getName()).append(",");
                    sb.append(temp.getCoordinates().getX()).append(",");
                    sb.append(temp.getCoordinates().getY()).append(",");
                    sb.append(temp.getStudentsCount()).append(",");
                    sb.append(temp.getTransferredStudents()).append(",");
                    sb.append(temp.getAverageMark()).append(",");
                    sb.append(temp.getSemesterEnum()).append(",");
                    sb.append(temp.getGroupAdmin().getName()).append(",");

                    sb.append(temp.getGroupAdmin().getHeight()).append(",");
                    sb.append(temp.getGroupAdmin().getEyeColor()).append(",");
                    sb.append(temp.getGroupAdmin().getHairColor()).append(",");
                    sb.append(temp.getGroupAdmin().getCountry()).append(",");
                    sb.append(temp.getGroupAdmin().getLocation().getX()).append(",");
                    sb.append(temp.getGroupAdmin().getLocation().getY()).append(",");
                    sb.append(temp.getGroupAdmin().getLocation().getName());
                }
                writer.write(sb.toString());

                System.out.println("done!");

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
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

