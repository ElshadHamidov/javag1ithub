package main;

import data.CommonData;

public class Main {
    public static void main(String[] args) {
        CommonData school = new CommonData("Harward", 500, 40, 20);

        school.showSchoolName();
//        school.showClassCount();
//        school.showTeacherCount();
        school.showTotalPeople();
    }
}
