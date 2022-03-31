package ir.maktab;

import ir.maktab.model.Role;
import ir.maktab.model.User;
import ir.maktab.service.doctor.DoctorService;
import ir.maktab.service.doctor.DoctorServiceImpl;
import ir.maktab.service.prescription.PrescriptionService;
import ir.maktab.service.prescription.PrescriptionServiceImpl;
import ir.maktab.service.reserve.ReserveService;
import ir.maktab.service.reserve.ReserveServiceImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceImpl;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl();
    private static final DoctorService doctorService = new DoctorServiceImpl();
    private static final ReserveService reserveService = new ReserveServiceImpl();
    private static final PrescriptionService prescriptionService = new PrescriptionServiceImpl();
    private static User user;

    public static void main(String[] args) {
        showMenu();
        boolean isExit = true;
        while (isExit) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();
                    user = userService.findByUsernameAndPassword(username, password);
                    if (user != null) {
                        System.out.println("Login Successful");
                        isExit = false;
                        break;
                    }
                    System.out.println("Login Failed");
                    break;
                case 2:
                    System.out.println("Enter your username: ");
                    String username1 = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String password1 = scanner.nextLine();
                    User user = createUser(username1, password1, Role.USER);
                    userService.save(user);
                    if (user != null) {
                        System.out.println("Register Successful");
                        isExit = false;
                        break;
                    }
                    System.out.println("Register Failed");
                    break;
                case 3:
                    System.out.println("Enter your username: ");
                    String username2 = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    String password2 = scanner.nextLine();
                    User user1 = createUser(username2, password2, Role.ADMIN);
                    userService.save(user1);
                    if (user1 != null) {
                        System.out.println("Register Successful");
                        isExit = false;
                        break;
                    }
                    System.out.println("Register Failed");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        isExit = true;
        if (user.getRole().equals(Role.ADMIN)) {
            showMenuAdmin();
            while (isExit) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:

                }
            }
        } else {

        }
    }

    private static User createUser(String username1, String password1, Role role) {
        return User.builder()
                .username(username1)
                .password(password1)
                .role(role)
                .build();
    }

    public static void showMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register user");
        System.out.println("3. Register admin");
    }

    public static void showMenuAdmin() {
        System.out.println("1. Show all Reservation");
        System.out.println("2. Show all Presentation");
        System.out.println("3. show all Doctor");
        System.out.println("4. Show all users");
        System.out.println("5. show all Reservation of user");
        System.out.println("6. show all Presentation of user");
        System.out.println("7. show all Doctor of user");
        System.out.println("8. Show all Reservation of doctor");
        System.out.println("9. Show all Presentation of doctor");
    }

    public static void showMenuUser() {
        System.out.println("1. show my description");
        System.out.println("2. show my reservation");
        System.out.println("3. show my presentation");
        System.out.println("4. show my doctor");
        System.out.println("5 show all doctor");
        System.out.println("6. reserve");
    }
}
