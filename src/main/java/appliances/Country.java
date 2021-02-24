package appliances;

public enum Country {
    FRANCE(1),
    THAILAND(2),
    SOUTH_KOREA(3);
    private int value;

    Country(int i) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Country getCountryById(int id) {

        Country country = null;

        switch (id) {
            case 1:
                country = FRANCE;
                break;
            case 2:
                country = THAILAND;
                break;
            case 3:
                country = SOUTH_KOREA;
                break;

            default:
                break;
        }
        return country;
    }
}
