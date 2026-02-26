package session12_bai04;

import java.util.LinkedList;

public class EmergencyRoom {
    private LinkedList<String> q = new LinkedList<>();

    public void patientCheckIn(String name) {
        q.addLast(name);
    }

    public void emergencyCheckIn(String name) {
        q.addFirst(name);
    }

    public void treatPatient() {
        if (q.isEmpty()) {
            System.out.println("Không có bệnh nhân");
            return;
        }
        String name = q.removeFirst();
        if (q.size() >= 0) {
            if (name.equals("C")) {
                System.out.println("Đang cấp cứu: " + name);
            } else {
                System.out.println("Đang khám: " + name);
            }
        }
    }
}
