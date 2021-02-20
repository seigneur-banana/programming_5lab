package Appliances;

import java.util.Date;

public class StudyGroup {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int studentsCount; //Значение поля должно быть больше 0
    private int transferredStudents; //Значение поля должно быть больше 0
    private int averageMark; //Значение поля должно быть больше 0
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле не может быть null

    StudyGroup(Integer id, String name, Coordinates coordinates, Date date, int count, int transfer, int mark, Semester sem, Person admin){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = date;
        this.studentsCount = count;
        this.transferredStudents = transfer;
        this.averageMark = mark;
        this.semesterEnum = sem;
        this.groupAdmin = admin;
    }

    @Override
    public String toString() {
        return  " id: "+id+
                " name: "+name+
                " coordinates: "+coordinates.toString()+
                " creationDate: "+creationDate+
                " studentsCount: "+studentsCount+
                " transferredStudents: "+transferredStudents+
                " averageMark: "+averageMark+
                " semesterEnum: "+semesterEnum+
                " groupAdmin: "+groupAdmin.getName()+"\n";
    }

}