import java.util.HashMap;
import java.util.Scanner;

interface StringFunction {
    String run();
}

public class Main {

    public static String mobile = "0123456789";
    public static String password = "123456789";
    public static int balance = 5000000;

    public static HashMap<Integer, Transaction> transactionArrayList = new HashMap<>();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Đăng nhập: ");
        while (true) {
            System.out.print("Mobile: ");
            String mobileLogin = sc.nextLine();

            System.out.print("Password: ");
            String passwordLogin = sc.nextLine();

            if (!mobileLogin.equals(mobile) || !passwordLogin.equals(password)) {
                System.out.println("Điện thoại hoặc mật khẩu sai!");
                break;
            } else {
                System.out.println("Đã đăng nhập");
                int temp = 0;
                while (temp == 0) {
                    System.out.println("\n1. Truy vấn số dư tài khoản\n2. Chuyển tiền\n3. Lịch sử giao dịch\n4. End");
                    System.out.print("Nhập lựa chọn: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            query();
                            break;
                        case 2:
                            transfer();
                            break;
                        case 3:
                            transactionHistory();
                            break;
                        case 4:
                            temp = 1;
                    }
                }

            }
        }

    }

    public static void query() {
        //        Truy vấn số dư tài khoản
        StringFunction s = () -> {
            return "Số dư: " + balance;
        };
        System.out.println(s.run());
    }

    public static void transfer() {
        System.out.print("Chọn ngân hàng bạn muốn chuyển tiền: ");
        String bankName = sc.nextLine();
        System.out.print("Nhập số TK nhận tiền: ");
        int accountReceive = sc.nextInt();
        System.out.print("Nhập số tiền chuyển: ");
        int moneySent = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = sc.nextLine();


        StringFunction s = () -> {
            balance = balance - moneySent;
            return "Đã chuyển: " + moneySent + "\n" + "Số dư còn lại: " + balance;
        };

        if (moneySent < 50000) {
            System.out.println("Số tiền muốn chuyển cần lớn hơn 50.000");
        } else if (balance - moneySent < 50000) {
            System.out.println("Tài khoản luôn luôn dư ít nhất là 50.000");
        } else {
            System.out.println(s.run());
            transactionArrayList.put(transactionArrayList.size() + 1, new Transaction(java.time.LocalDate.now(), description, accountReceive, moneySent));

        }
    }

    public static void transactionHistory() {
        System.out.println("Lịch sử giao dịch: ");
        transactionArrayList.forEach((integer, transaction) -> {
            System.out.println(integer + ": " + transaction);
        });
    }
}
