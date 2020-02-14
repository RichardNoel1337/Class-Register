package JDBCHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beanPod.CourseBean;

import java.util.*;

public class DBConnection {
	private Connection connect;
//Connection Constructor
	public DBConnection() throws ClassNotFoundException, SQLException {
		establishDBConnection();
	}
	// Close connection
	public void closeDBConnection() throws SQLException{
		connect.close();
	}
	// Establishes connection to the database
	public void establishDBConnection() throws SQLException, ClassNotFoundException {

		String url = "jdbc:sqlserver://s16988308.onlinehome-server.com;databaseName=CUNY_DB";
		String user = "cst4713";
		String password = "password1";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Properties connectProp = new Properties();
		connectProp.put("dbms", "sqlserver");
		connectProp.put("user", "cst4713");
		connectProp.put("password", "password1");
		connect = DriverManager.getConnection(url, user, password);
	}
	// Populates courses using Course Table from database
	public static ArrayList<CourseBean> populateCourses() throws ClassNotFoundException, SQLException {
		DBConnection db1 = new DBConnection();
		ArrayList<CourseBean> allCourses = new ArrayList<CourseBean>();
		String query = "select * from Course ORDER BY courseID ASC";
		Statement selectStatement = db1.connect.createStatement();
		ResultSet rs = selectStatement.executeQuery(query);
		while (rs.next()) {
			CourseBean tempCB = new CourseBean();
			tempCB.setCourseID(rs.getString("courseID"));
			tempCB.setSubjectID(rs.getString("subjectID"));
			tempCB.setCourseCredNum(rs.getInt("numOfCredits"));
			allCourses.add(tempCB);
		}
		return allCourses;
	}
	//Creating a hashtable of student enrollment which has the key "ssn" 
	//and value is a CourseBean with a"courseId"
	public static Hashtable<String, ArrayList<CourseBean>> populateStudEnrollment(ArrayList<CourseBean> allCBs) throws ClassNotFoundException, SQLException {
		DBConnection db2 = new DBConnection();
		Hashtable<String, ArrayList<CourseBean>> htEnrollment = new Hashtable<String, ArrayList<CourseBean>>();
		String query = "select * from Enrollment ORDER BY courseId ASC";
		Statement selectStatement = db2.connect.createStatement();
		ResultSet rs = selectStatement.executeQuery(query);
		ArrayList<CourseBean> allCourses = allCBs;
		
		while (rs.next()) {
			if(!htEnrollment.containsKey(rs.getString("ssn"))){
				htEnrollment.put(rs.getString("ssn"), new ArrayList<CourseBean>());
			}
			for(CourseBean cb : allCourses){
				if(cb.getCourseID().equals(rs.getString("courseId"))){
					htEnrollment.get(rs.getString("ssn")).add(cb);	
				}		
			}	
		}
		return htEnrollment;
	}

	// Populating all student ssn's into an ArrayList 
	public static ArrayList<String> populateStudentLog() throws ClassNotFoundException, SQLException {
		DBConnection db3 = new DBConnection();
		ArrayList<String> alStudents = new ArrayList<String>();
		String query = "select * from Students";
		Statement selectStatement = db3.connect.createStatement();
		ResultSet rs = selectStatement.executeQuery(query);
		while (rs.next()) {	
			alStudents.add(rs.getString("ssn"));
		}
		return alStudents;
	}
	
}
