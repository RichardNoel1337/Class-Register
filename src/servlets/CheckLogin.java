package servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import JDBCHelper.DBConnection;
import beanPod.CourseBean;
import beanPod.LoginBean;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet implements beanPod.BeanSearch {

	public ArrayList<CourseBean> availableCourses = new ArrayList<CourseBean>();
	public Hashtable<String, ArrayList<CourseBean>> studEnrollment = new Hashtable<String, ArrayList<CourseBean>>();
	public LoginBean studentLogin = new LoginBean();
	public ArrayList<String> currentStudents = new ArrayList<String>();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			availableCourses = DBConnection.populateCourses();
			studEnrollment = DBConnection.populateStudEnrollment(availableCourses);	
			currentStudents = DBConnection.populateStudentLog();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String studentCookie = request.getParameter("StudentId");
		boolean studentFound = false;
		
		if(!findStudent(studentCookie, studEnrollment)){
			studEnrollment.put(studentCookie, new ArrayList<CourseBean>());
		}
		
		for(String studentID : currentStudents){
			
			if(studentID.equals(studentCookie)){
				if(!studentFound){
					studentFound = true;
					studentLogin.setStudentID(studentCookie);
				}		
			}	
		}	 
		
		if(!studentFound){
			response.sendRedirect("registLogin.jsp?ErrMsg=");
		}
		else{
			session.setAttribute("studentLogin",studentLogin);
			ArrayList<CourseBean> currentCourses = studEnrollment.get(studentLogin.getStudentID());
			session.setAttribute("currentCourses",currentCourses);
			session.setAttribute("availableCourses", availableCourses);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
			rd.forward(request, response);
		}
	}

	
	public boolean findStudent(String studentID, Hashtable<String, ArrayList<CourseBean>> enrollmentLog) {
		if(enrollmentLog.keySet().contains(studentID)){
			return true;
		}
		else{
			return false;
		}
	}

}
