package commands;

import appliances.*;
import java.util.Scanner;

public class Add implements Command {
    @Override
    public boolean execute(CommandHandler commandHandler, String... args) {
        if (args != null && args.length == 1) {
            Scanner scanner = new Scanner(System.in);
            switch (args[0].toLowerCase()) {
                case "coordinates": {
                    double x, y;
                    System.out.println("Чтобы добавить элемент в Coordinates, введите такие поля, как (Обязательные поля помечены *):" +
                            "\n1*. Координата Y (Double Значение поля должно быть больше -748)\n2. Координата Х (double).");
                    do {
                        try {
                            System.out.print("Введите Y> ");
                            y = Double.parseDouble(scanner.nextLine()); //y = scanner.nextDouble();
                            if (y < -748) {
                                System.out.println("Введено неверное значение для Y (меньше -748)");
                            } else break;
                        } catch (Exception e) {
                            System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                        }
                    } while (true);
                    try {
                        System.out.print("Введите X> ");
                        x = Double.parseDouble(scanner.nextLine()); //x = scanner.nextDouble();
                    } catch (Exception e) {
                        x = 0;
                    }
                    commandHandler.setCoordinates(y, x);
                }break;

                case "location": {
                    Float x; Integer y; String name;
                    System.out.println("Чтобы добавить элемент в Location, введите такие поля, как (Обязательные поля помечены *):" +
                            "\n1*. Координата X (Float)\n2*. Координата Y (Integer)\n3. Название name (String).");
                    do {
                        try {
                            System.out.print("Введите X> ");
                            x = Float.parseFloat(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                        }
                    } while (true);
                    do {
                        try {
                            System.out.print("Введите Y> ");
                            y = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                        }
                    } while (true);
                    System.out.print("Введите name> ");
                    name = scanner.nextLine();
                    if(name.equals("")) name = null;
                    commandHandler.setLocations(y,x,name);
                }
                break;

                case "person": {
                    String name, temp; int height; Color eyeColor = null, hairColor = null;
                    Country nationality = null; Location location = null;
                    System.out.println("Чтобы добавить элемент в Person, введите такие поля, как (Обязательные поля помечены *):" +
                            "\n1*. Имя Name (String)\n2*. Рост height (int, знач > 0)\n3. ЦветГлаз eyeColor (Color)." +
                            "\n4. ЦветПричёски hairColor (Color).\n5. Национальность nationality (Country)\n6. Локация location (Location).");
                    do {
                        System.out.print("Введите Имя> ");
                        name = scanner.nextLine();
                        if(!name.equals("")) break;
                        else System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                    } while (true);

                    do {
                        try {
                            System.out.print("Введите height> ");
                            height = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                        }
                    } while (true);

                    System.out.print("Введите ЦветГлаз> ");
                    temp = scanner.nextLine();
                    for (Color clr : Color.values()) {
                        if (temp.toLowerCase().equals(clr.name().toLowerCase())){
                            eyeColor = clr;
                            break;
                        }
                    }

                    System.out.print("Введите ЦветПричёски> ");
                    temp = scanner.nextLine();
                    for (Color clr : Color.values()) {
                        if (temp.toLowerCase().equals(clr.name().toLowerCase())){
                            hairColor = clr;
                            break;
                        }
                    }

                    System.out.print("Введите Национальность> ");
                    temp = scanner.nextLine();
                    for (Country cntr : Country.values()) {
                        if (temp.toLowerCase().equals(cntr.name().toLowerCase())){
                            nationality = cntr;
                            break;
                        }
                    }

                    System.out.println("Доступные Locations: " + commandHandler.getLocations());
                    System.out.print("Введите id location> ");
                    Integer idLocation;
                    try {
                        idLocation = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Неверный формат id Location");
                        idLocation = null;
                    }
                    if(idLocation != null && idLocation < commandHandler.getLocations().size() && idLocation >=0)
                        location = commandHandler.getLocations().get(idLocation);
                    commandHandler.setPersons(name, height, eyeColor, hairColor, nationality, location);
                }
                break;

                case "studygroup": {
                    String name; Coordinates coordinates = null; int count = 0, transfer = 0, mark = 0; Semester sem = null; Person admin;

                    if(commandHandler.getPersons().size() == 0) {
                        System.out.println("В базе нет доступных Person для выбора админом группы," +
                            " пожалуйста, сначала добавьте Person (add Person)");
                        return false;
                    }
                    System.out.println("StudyGroups, введите такие поля, как (Обязательные поля помечены *):" +
                            "\n1*. Название Name (String)\n2*. id Админа (Person)\n3. id Координат (Coordinates)" +
                            "\n4. Кол-во студентов (int).\n5. Перевед-ые студенты (int)\n6. Средн.Оценка (int, знач > 0)"+
                            "\n7. Номер семестра (SemesterEnum).");

                    do {
                        System.out.print("Введите Название> ");
                        name = scanner.nextLine();
                        if(!name.equals("")) break;
                        else System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                    } while (true);

                    do {
                        try {
                            System.out.println("Доступные Persons: " + commandHandler.getPersons());
                            System.out.print("Введите id_Person для выбора Админа группы> ");
                            int tmp = Integer.parseInt(scanner.nextLine());
                            if(tmp >= commandHandler.getPersons().size() || tmp < 0)continue;
                            else admin = commandHandler.getPersons().get(tmp);
                            break;
                        } catch (Exception e) {
                            System.out.println("Неверный формат ввода, пожалуйста, попробуйте снова.");
                        }
                    } while (true);

                    System.out.println("Доступные Coordinates: " + commandHandler.getCoordinates());
                    System.out.print("Введите id_Координат> ");
                    try {
                        Integer idCoordinates = Integer.parseInt(scanner.nextLine());
                        if(idCoordinates < commandHandler.getCoordinates().size() && idCoordinates >=0)
                            coordinates = commandHandler.getCoordinates().get(idCoordinates);
                    } catch (Exception e) {
                        System.out.println("Неверный формат id_Coordinates присвоен null");
                    }

                    System.out.print("Введите Количество студентов> ");
                    try {
                        int temp = Integer.parseInt(scanner.nextLine());
                        if(temp >= 0) count = temp;
                    } catch (Exception e) {
                        System.out.println("Неверный формат, присвоен 0");
                    }

                    System.out.print("Введите Количество переведенных студентов> ");
                    try {
                        int temp = Integer.parseInt(scanner.nextLine());
                        if(temp >= 0) transfer = temp;
                    } catch (Exception e) {
                        System.out.println("Неверный формат, присвоен 0");
                    }

                    System.out.print("Введите значение сред. оценки в группе> ");
                    try {
                        int temp = Integer.parseInt(scanner.nextLine());
                        if(temp >= 0 && temp <= 5) mark = temp;
                    } catch (Exception e) {
                        System.out.println("Неверный формат, присвоен 0");
                    }

                    System.out.print("Введите номер семестра> ");
                    String temp = scanner.nextLine();
                    for (Semester semester : Semester.values()) {
                        if (temp.toLowerCase().equals(semester.name().toLowerCase())){
                           sem = semester;
                           break;
                        }
                    }
                    commandHandler.setGroups(commandHandler.getGroups().size(), name, coordinates, count, transfer, mark, sem, admin);
                }break;

                default: {
                    System.out.println("Аргумент не распознан, попробуйте снова :) ");
                }
                break;
            }
            return true;
        }
        else{return false;}
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return " {element} : добавить новый элемент в коллекцию";
    }
}
