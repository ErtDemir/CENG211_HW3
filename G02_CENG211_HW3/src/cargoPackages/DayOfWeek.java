package cargoPackages;

public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String day;
    DayOfWeek(String string) {
        day = string;
    }
    public String getDay() {
        return day;
    }
}
