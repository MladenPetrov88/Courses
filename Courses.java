import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> programStudent = new LinkedHashMap<>();

        while (!command.equals("end")) {
            String[] temp = command.split(" : ");
            List<String> students = programStudent.get(temp[0]);

            if (!programStudent.containsKey(temp[0])) {
                students = new LinkedList<>();
                students.add(temp[1]);
                programStudent.put(temp[0], students);
            } else {
                students.add(temp[1]);
            }


            command = scanner.nextLine();
        }
        programStudent
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry
                            .getValue()
                            .stream()
                            .sorted((a,b) -> a.compareTo(b))
                            .forEach(s -> System.out.println("-- " + s));
                });

    }
}
