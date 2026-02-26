package session12_bai01;
import java.util.ArrayList;
import java.util.Iterator;

public class Session12_bai01 {
    public static void main(String[] args) {

        ArrayList<Double> temperatureList = new ArrayList<>();
        temperatureList.add(36.5);
        temperatureList.add(40.2);
        temperatureList.add(37.0);
        temperatureList.add(12.5);
        temperatureList.add(39.8);
        temperatureList.add(99.9);
        temperatureList.add(36.8);

        System.out.println("Danh sách ban đầu: " + temperatureList);

        Iterator<Double> iterator = temperatureList.iterator();

        while (iterator.hasNext()) {
            Double temperature = iterator.next();
            if (temperature < 34.0 || temperature > 42.0) {
                iterator.remove();
            }
        }

        System.out.println("Danh sách sau khi lọc: " + temperatureList);

        double sum = 0;
        for (Double temperature : temperatureList) {
            sum += temperature;
        }

        double average = sum / temperatureList.size();

        System.out.printf("Nhiệt độ trung bình: %.2f\n", average);
    }
}
