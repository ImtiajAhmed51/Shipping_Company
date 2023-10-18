import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            System.out.println("\nPlease enter correct date format.");
            return null;
        }
    }
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.matches())
            System.out.println("\nPlease enter valid email.");
        return matcher.matches();
    }

    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean choice1 = true;
        while (choice1) {
            String id, name, email;
            Date dateOfBirth, joiningDate;
            System.out.println("\nEnter details for an employee:");
            System.out.print("ID: ");
            id = scanner.nextLine();
            System.out.print("Name: ");
            name = scanner.nextLine();
            System.out.print("Date of Birth (yyyy-MM-dd): ");
            dateOfBirth = parseDate(scanner.nextLine());
            if (null == dateOfBirth)
                continue;
            do {
                System.out.print("Email: ");
                email = scanner.nextLine();
            }
            while (!validate(email));
            System.out.print("Joining Date (yyyy-MM-dd): ");
            joiningDate = parseDate(scanner.nextLine());
            if (null == joiningDate)
                continue;
            Employee employee;
            System.out.println("\nSelect employee type (1. Officer, 2. Staff):");
            int Choice = 0;
            try {
                Choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("\nEnter valid input. Choice 1 Or 2.");
            }
            switch (Choice) {
                case 1:
                    employee = new Officer(id, name, dateOfBirth, email, joiningDate);
                    break;
                case 2:
                    employee = new Staff(id, name, dateOfBirth, email, joiningDate);
                    break;
                default:
                    continue;
            }
            int vacationLeave = employee.calculateLeaveDays("Vacation");
            int sickLeave = employee.calculateLeaveDays("Sick");
            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + formatDate(employee.getDateOfBirth()));
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Joining Date: " + formatDate(employee.getJoiningDate()));
            System.out.println("Vacation Leave: " + vacationLeave);
            System.out.println("Sick Leave: " + sickLeave);
            System.out.print("\nPlease enter details for another employee, 'yes' to exit: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes"))
                choice1 = false;
        }
        scanner.close();
    }
}

