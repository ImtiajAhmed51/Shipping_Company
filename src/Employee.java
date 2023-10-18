import java.util.Date;

public abstract class Employee {
    private String id;
    private String name;
    private Date dateOfBirth;
    private String email;
    private Date joiningDate;

    public Employee() {
    }

    public Employee(String id, String name, Date dateOfBirth, String email, Date joiningDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.joiningDate = joiningDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    public abstract int getVacationLeave();

    public abstract int getSickLeave();

    public int calculateLeaveDays(String leaveType) {
        int totalLeaveDays;
        int daysInYear = isLeapYear(joiningDate.getYear()) ? 366 : 365;

        if (leaveType.equals("Vacation")) {
            totalLeaveDays = getVacationLeave();
        } else {
            totalLeaveDays = getSickLeave();
        }

        int daysWorked = (int) ((joiningDate.getTime() - new Date(joiningDate.getYear(), 0, 1).getTime()) / (24 * 60 * 60 * 1000)) + 1;
        double leaveDays = ((double) (daysInYear - daysWorked + 1) / daysInYear) * totalLeaveDays;

        return (leaveDays < 0.5) ? (int) Math.floor(leaveDays) : (int) Math.ceil(leaveDays);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
