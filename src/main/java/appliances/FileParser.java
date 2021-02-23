package appliances;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class FileParser {
    public void read(CommandHandler commandHandler) throws IOException {
        // маппинг csv
        //String[] mapping = new String[]{"groupName", "coorX", "coorY", "count", "transfer", "mark", "sem", "admin",
        //        "height", "eye", "hair", "country", "locX", "locY", "locName"};

        try {
            String inPutPath = System.getenv("Lab5");
            FileInputStream fileInputStream = new FileInputStream(inPutPath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);
            int i;
            StringBuilder s = new StringBuilder();
            while ((i = bufferedInputStream.read()) != -1) {
                s.append((char) i);
                if((char)i == '\n'){
                    String[] columns = s.toString().split(",");
                    Semester sem = null; Color eye = null, hair = null; Country country = null;
                    Integer height = 0, count = 0, transfer = 0, mark = 0;
                    try{ if(Integer.parseInt(columns[8]) > 0 ) height = Integer.parseInt(columns[8]);
                    } catch (Exception e){}
                    try{ if(Integer.parseInt(columns[3]) > 0 ) count = Integer.parseInt(columns[3]);
                    } catch (Exception e){}
                    try{ if(Integer.parseInt(columns[4]) > 0 ) transfer = Integer.parseInt(columns[4]);
                    } catch (Exception e){}
                    try{ if(Integer.parseInt(columns[5]) > 0  && Integer.parseInt(columns[5]) <= 5)
                        mark = Integer.parseInt(columns[5]);
                    } catch (Exception e){}
                    for (Semester semester : Semester.values()) {
                        if (columns[6].toLowerCase().equals(semester.name().toLowerCase())){
                            sem = semester;
                            break;
                        }
                    }
                    for (Color color : Color.values()) {
                        if (columns[9].toLowerCase().equals(color.name().toLowerCase())){
                            eye = color;
                            break;
                        }
                    }
                    for (Color color : Color.values()) {
                        if (columns[10].toLowerCase().equals(color.name().toLowerCase())){
                            hair = color;
                            break;
                        }
                    }
                    for (Country country1 : Country.values()) {
                        if (columns[11].toLowerCase().equals(country1.name().toLowerCase())){
                            country = country1;
                            break;
                        }
                    }

                    commandHandler.setCoordinates(Double.parseDouble(columns[2]),Double.parseDouble(columns[1])); //y,x
                    commandHandler.setLocations(Integer.parseInt(columns[13]), Float.parseFloat(columns[12]),columns[14]);//y,x,locName
                    commandHandler.setPersons(
                            columns[7],                                                                     //name Person
                            height,
                            eye,
                            hair,
                            country,
                            commandHandler.getLocations().get(commandHandler.getLocations().size() - 1)     //coordinates
                    );

                    commandHandler.setGroups(
                            commandHandler.getGroups().size(),                                              //id group
                            columns[0],                                                                     //name group
                            commandHandler.getCoordinates().get(commandHandler.getCoordinates().size() - 1),//coordinates
                            count,
                            transfer,
                            mark,
                            sem,
                            commandHandler.getPersons().get(commandHandler.getPersons().size() - 1)         //admin
                    );
                    s.setLength(0);
                }
            }
            System.out.println("Данные подгружены из базы данных . . .");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
