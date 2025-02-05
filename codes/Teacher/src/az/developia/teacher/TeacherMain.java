package az.developia.teacher;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMain {

	public static void main(String[] args) {
		TeacherEntity teacher=new TeacherEntity
				(0, "Elrahim", "Elizade", "051", "nizami st.", "elirahim1", "1234");
		
		TeacherRepository repo=new TeacherRepository(); repo.add(teacher);
	}

}
