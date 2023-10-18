import java.util.Date;

public class Officer extends Employee{
    private static final int SICK_DAYS = 10;
    private static final int VACATION_DAYS = 15;

    public Officer(String id, String name, Date dateOfBirth, String email, Date joiningDate) {
        super(id, name, dateOfBirth, email, joiningDate);
    }

    @Override
    public int getVacationLeave() {
        return VACATION_DAYS;
    }

    @Override
    public int getSickLeave() {
        return SICK_DAYS;
    }
}
