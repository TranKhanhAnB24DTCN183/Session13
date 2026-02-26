package session12_bai05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Patient> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ BỆNH ÁN =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Hiển thị");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    removePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    showAll();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        if (findById(id) != null) {
            System.out.println("ID đã tồn tại! Không thể thêm.");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        Patient newPatient = new Patient(id, name, age, diagnosis);
        list.add(newPatient);
        System.out.println("Tiếp nhận bệnh nhân thành công.");
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        System.out.print("Nhập chẩn đoán mới: ");
        String diagnosis = sc.nextLine();
        p.setDiagnosis(diagnosis);

        System.out.println("Cập nhật thành công.");
    }

    private static void removePatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        list.remove(p);
        System.out.println("Xuất viện thành công.");
    }

    private static void sortPatients() {
        list.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }
                return p1.getFullName().compareTo(p2.getFullName());
            }
        });

        System.out.println("Đã sắp xếp xong.");
    }

    private static void showAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (Patient p : list) {
            System.out.println(p);
        }
    }

    private static Patient findById(String id) {
        for (Patient p : list) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}