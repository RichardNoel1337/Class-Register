package servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import beanPod.CourseBean;

@WebServlet("/addRemoveServlet")
public class addRemoveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			
			HttpSession session = request.getSession();
			String courseAction = request.getParameter("courseAction");
			CourseBean tempCB = new CourseBean();
			
			ArrayList<CourseBean> availableCourses = (ArrayList<CourseBean>) session.getAttribute("availableCourses");
			ArrayList<CourseBean> currentCourses = (ArrayList<CourseBean>) session.getAttribute("currentCourses");

			if (courseAction.equals("ENROLL")) {
				session.setAttribute("selectedCourse", request.getParameter("courseAdded"));
				
				for(CourseBean cb : availableCourses){
					if(cb.getCourseID().equals(session.getAttribute("selectedCourse"))){				
				tempCB = cb;	
				}}
				currentCourses.add(tempCB);
				availableCourses.remove(tempCB);
				session.setAttribute("availableCourses", availableCourses);
				session.setAttribute("currentCourses", currentCourses);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
				rd.forward(request, response);
			} else if (courseAction.equals("YES")) {
				
				for(CourseBean cb : currentCourses){
					if(cb.getCourseID().equals(session.getAttribute("selectedCourse"))){
						tempCB = cb;						
					}}
				currentCourses.remove(tempCB);
				availableCourses.add(tempCB);
				session.setAttribute("availableCourses", availableCourses);
				session.setAttribute("currentCourses", currentCourses);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
				rd.forward(request, response);
			} else if (courseAction.equals("EXIT") || courseAction.equals("NO")) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
				rd.forward(request, response);
			}
		}
	}
}
