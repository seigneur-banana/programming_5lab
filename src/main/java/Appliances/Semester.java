package Appliances;

public enum Semester {
    FIRST(1),
    SECOND(2),
    FIFTH(3),
    SIXTH(4),
    SEVENTH(5);
    private int value;

    Semester(int i) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static Semester getSemestrById(int id) {

        Semester semester = null;

        switch (id) {
            case 1:
                semester = FIRST;
                break;
            case 2:
                semester = SECOND;
                break;
            case 3:
                semester = FIFTH;
                break;
            case 4:
                semester = SIXTH;
                break;
            case 5:
                semester = SEVENTH;
                break;

            default:
                break;
        }
        return semester;
    }
}
