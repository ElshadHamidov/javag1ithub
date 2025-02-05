package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import az.developia.teacher.entity.TeacherEntity;

public class TeacherRepository {
	public void add(TeacherEntity teacher){
		String query = "INSERT INTO teacher(name,surname,phone,address,username,password) VALUES " + "('"
				+ teacher.getName() + "','" + teacher.getSurname() + "','" + teacher.getPhone() + "','"
				+ teacher.getAddress() + "','" + teacher.getUsername() + "','" + teacher.getPassword() + "')";
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_teacher?useSSL=false",
					"root","E20091110");

			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
