package session12_bai06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Medicine> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU KÊ ĐƠN THUỐC =====");
            System.out.println("1. Thêm thuốc");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá rẻ (< 50.000)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    removeMedicine();
                    break;
                case 4:
                    printBill();
                    break;
                case 5:
                    findCheapMedicine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        Medicine m = findById(id);

        if (m != null) {
            System.out.print("Thuốc đã tồn tại. Nhập số lượng thêm: ");
            int qty = Integer.parseInt(sc.nextLine());
            m.setQuantity(m.getQuantity() + qty);
            System.out.println("Đã cộng dồn số lượng.");
            return;
        }

        System.out.print("Nhập tên thuốc: ");
        String name = sc.nextLine();

        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());

        list.add(new Medicine(id, name, price, qty));
        System.out.println("Đã thêm thuốc vào đơn.");
    }

    private static void updateQuantity() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }

        System.out.print("Nhập số lượng mới: ");
        int qty = Integer.parseInt(sc.nextLine());

        if (qty == 0) {
            list.remove(m);
            System.out.println("Đã xóa thuốc khỏi đơn.");
        } else {
            m.setQuantity(qty);
            System.out.println("Đã cập nhật số lượng.");
        }
    }

    private static void removeMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }

        list.remove(m);
        System.out.println("Đã xóa thuốc.");
    }

    private static void printBill() {

        if (list.isEmpty()) {
            System.out.println("Đơn thuốc trống.");
            return;
        }

        double total = 0;

        System.out.println("\n=============== HÓA ĐƠN ===============");
        System.out.printf("%s %s %s %s %s\n",
                "Mã", "Tên thuốc", "Giá", "SL", "Thành tiền");

        for (Medicine m : list) {
            System.out.printf("%s %s %.0f %d %.0f\n",
                    m.getDrugId(),
                    m.getDrugName(),
                    m.getUnitPrice(),
                    m.getQuantity(),
                    m.getTotal());

            total += m.getTotal();
        }

        System.out.println("-----------------------------------------------");
        System.out.printf("TỔNG TIỀN: %.0f VNĐ\n", total);

        list.clear();
        System.out.println("Đã hoàn tất đơn và làm mới danh sách.");
    }

    private static void findCheapMedicine() {
        boolean found = false;
        for (Medicine m : list) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugId() + " - " +
                        m.getDrugName() + " - " +
                        m.getUnitPrice() + " VNĐ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có thuốc giá rẻ.");
        }
    }

    private static Medicine findById(String id) {
        for (Medicine m : list) {
            if (m.getDrugId().equals(id)) {
                return m;
            }
        }
        return null;
    }
}
