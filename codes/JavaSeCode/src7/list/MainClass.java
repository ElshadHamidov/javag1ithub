package list;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Alice", "Mathematics");
        Teacher teacher2 = new Teacher("Bob", "Physics");
        Teacher teacher3 = new Teacher("Charlie", "Chemistry");
        Teacher teacher4 = new Teacher("Diana", "Biology");

        List<Teacher> teacherList = new ArrayList<>();

        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);
        teacherList.add(teacher4);

        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
}
