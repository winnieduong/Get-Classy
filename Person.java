import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public int getYOB() { return YOB; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    public String toJSON() {
        return "{ \"ID\": \"" + ID + "\", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"title\": \"" + title + "\", \"YOB\": " + YOB + " }";
    }

    public String toXML() {
        return "<Person><ID>" + ID + "</ID><firstName>" + firstName + "</firstName><lastName>" + lastName + "</lastName><title>" + title + "</title><YOB>" + YOB + "</YOB></Person>";
    }

    @Override
    public String toString() {
        return formalName() + " (ID: " + ID + ", YOB: " + YOB + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        return ID.equals(person.ID);
    }
}
