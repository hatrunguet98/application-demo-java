package view;

import service.dao.HostToFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
//        ArrayList<Host> hostArrayList = new ArrayList<>();
//        Host host = new Host("12", "Trung", "Nd", 234, 23452345, 6);
//        hostArrayList.add(host);
//        new HostToFile().save(hostArrayList);
        ArrayList listHost = new HostToFile().get();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Đăng nhập với tư cách \n");
        System.out.printf("Host: 1 \n");
        System.out.printf("Renter: 2 \n");
        String userIndex = scanner.nextLine();
        System.out.printf("\n");
//        while (!userIndex.equals("0"))
//        if(userIndex.equals("1")){
//            System.out.printf("User name:");
//            String userName = scanner.nextLine();
//            System.out.printf("\n");
//            if(checkUser(listHost,userName)){
//                userIndex="0";
//                System.out.printf("Đăng nhập thành công \n");
//            }
//            else System.out.printf("Đăng nhập thất bại \n");
//        }
    }
}
