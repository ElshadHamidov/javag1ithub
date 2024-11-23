package inheritance;

class Student extends Person {
    int id;

    void showStudentInfo() {
        showName();
        System.out.println("ID: " + id);
    }
}
