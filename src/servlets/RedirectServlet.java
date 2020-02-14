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


	@WebServlet("/RedirectServlet")
	public class RedirectServlet extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			
			HttpSession session = request.getSession();
			String action = request.getParameter("action");
			ArrayList<CourseBean> availableCourses = (ArrayList<CourseBean>) session.getAttribute("availableCourses");
			ArrayList<CourseBean> currentCourses = (ArrayList<CourseBean>) session.getAttribute("currentCourses");
			availableCourses.removeAll(currentCourses);

			if (action.equals("Register")) {
				
				session.setAttribute("availableCourses", availableCourses);
			    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Enroll.jsp");
				rd.forward(request, response);
			} else if (action.equals("Drop")) {
				session.setAttribute("selectedCourse", request.getParameter("courseList"));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ConfirmRemove.jsp");
				rd.forward(request, response);
				}
			else if (action.equals("Exit")) {
				RequestDispatcher rd = request.getRequestDispatcher("registLogin.jsp");
				rd.forward(request, response);
				};
			}
		}
	}
