package WorkingwithAbstractionLab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;


public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

        public void ParseCommand(String[] args) {

        if (args[0].equals("Create")) {
            create(args);
        } else if (args[0].equals("Show")) {
            show(args[1]);
        }
    }

    private void show(String arg) {
        if (repo.containsKey(arg)) {
            Student student = repo.get(arg);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice person.";
            }
            System.out.println(view);
        }
    }

    private void create(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        if (!repo.containsKey(name)) {
            Student student = new Student(name, age, grade);
            repo.put(name, student);
        }
    }
}
