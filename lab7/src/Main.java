import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Double> set = new HashSet<>();
        System.out.println("Introduceți numerele (introduceți 'stop' pentru a termina):");
        while (scanner.hasNextDouble()) {
            set.add(scanner.nextDouble());
        }
        if (isGeometricProgression(set)) {
            double sum = set.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Numerele formează o progresie geometrică.");
            System.out.println("Suma numerelor este: " + sum);
        } else {
            System.out.println("Numerele nu formează o progresie geometrică.");
        }
    }
    public static boolean isGeometricProgression(Set<Double> set) {
        List<Double> list = new ArrayList<>(set);
        if (list.size() < 2) return true;

        double ratio = list.get(1) / list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) / list.get(i - 1) != ratio) {
                return false;
            }
        }
        return true;
    }
}
