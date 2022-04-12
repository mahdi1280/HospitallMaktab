package ir.maktab;

import ir.maktab.model.Reserve;
import ir.maktab.model.Role;
import ir.maktab.model.Time;
import ir.maktab.model.User;
import ir.maktab.service.doctor.DoctorService;
import ir.maktab.service.doctor.DoctorServiceImpl;
import ir.maktab.service.prescription.PrescriptionService;
import ir.maktab.service.prescription.PrescriptionServiceImpl;
import ir.maktab.service.reserve.ReserveService;
import ir.maktab.service.reserve.ReserveServiceImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceImpl;
import ir.maktab.session.MySession;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl();
    private static final DoctorService doctorService = new DoctorServiceImpl();
    private static final ReserveService reserveService = new ReserveServiceImpl();
    private static final PrescriptionService prescriptionService = new PrescriptionServiceImpl();
    private static User user;

    public static void main(String[] args) {
        MySession.getInstance();
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
                    user = createUser(username1, password1, Role.USER);
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
                    user = createUser(username2, password2, Role.ADMIN);
                    userService.save(user);
                    if (user != null) {
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
                        reserveService.showAll();
                        break;
                    case 2:
                        prescriptionService.findAll();
                        break;
                    case 3:
                        doctorService.showAllDoctors();
                        break;
                    case 4:
                        userService.showAll();
                        break;
                    case 5:
                        userService.showAll();
                        System.out.println("Enter your id: ");
                        long id = scanner.nextInt();
                        scanner.nextLine();
                        List<Reserve> byUserId = reserveService.findByUserId(id);
                        for (Reserve reserve : byUserId) {
                            System.out.println(reserve);
                        }
                        break;
                    case 6:
                        userService.showAll();
                        System.out.println("Enter your id: ");
                        long id1 = scanner.nextInt();
                        scanner.nextLine();
                        prescriptionService.findByUserId(id1);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } else {
            showMenuUser();
            while (isExit) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        User byId = userService.findById(user.getId());
                        System.out.println(byId);
                        break;
                    case 2:
                        List<Reserve> byUserId = reserveService.findByUserId(user.getId());
                        for (Reserve reserve : byUserId) {
                            System.out.println(reserve);
                        }
                        break;
                    case 3:
                        prescriptionService.findByUserId(user.getId());
                        break;
                    case 4:
                        doctorService.showAllDoctors();
                        break;
                    case 5:
                        doctorService.showAllDoctors();
                        System.out.println("Enter your id: ");
                        long id2 = scanner.nextInt();
                        scanner.nextLine();
                        doctorService.findDoctorById(id2);
                        Arrays.stream(Time.values()).forEach(System.out::println);
                        System.out.println("Enter your time: ");
                        Time time = getTime();
                        Reserve byDoctroIdAndTime = reserveService.findByDoctroIdAndTime(id2, time);
                        if (byDoctroIdAndTime != null) {
                            System.out.println("time is full");
                            break;
                        }
                        reserveService.add(new Reserve(LocalDate.now(), time, user, doctorService.findDoctorById(id2)));
                        System.out.println("Reserve Success");
                        break;


                }
            }
        }
    }

    private static Time getTime() {
        while (true) {
            try {
                String s = scanner.nextLine();
                return Time.valueOf(s);
            } catch (Exception e) {
                System.out.println("not valid time. try again");
            }
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
    }

    public static void showMenuUser() {
        System.out.println("1. show my description");
        System.out.println("2. show my reservation");
        System.out.println("3. show my presentation");
        System.out.println("4. show my doctor");
        System.out.println("5. reserve");
    }
}
