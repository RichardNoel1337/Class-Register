package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import beanPod.CourseBean;
import beanPod.LoginBean;

public class MyCourseTag extends SimpleTagSupport {
	private LoginBean currentStudent = null;
	private ArrayList<CourseBean> currentCourses = null;
	private String commandCode = "0";

	public LoginBean getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(LoginBean currentStudent) {
		this.currentStudent = currentStudent;
	}

	public ArrayList<CourseBean> getCurrentCourses() {
		return currentCourses;
	}

	public void setCurrentCourses(ArrayList<CourseBean> currentCourses) {
		this.currentCourses = currentCourses;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();

		int counter = 0;
		int creditcounter = 0;
		Collections.sort(currentCourses, CourseBean.CourseComparator);
		switch (commandCode) {
		case "1":
			//Displays Current Courses in MyCourses.jsp
			for (CourseBean cb : currentCourses) {

				if (counter == 0) {
					out.println(
							"<option selected value=\"" + cb.getCourseID() + "\">" + cb.getCourseID() + " </option>");
					counter++;
					creditcounter += cb.getCourseCredNum();
				} else {
					out.println("<option value=\"" + cb.getCourseID() + "\">" + cb.getCourseID() + "</option>");
					creditcounter += cb.getCourseCredNum();

				}
			}
			out.println("</select>");

			out.println("<br>Total Credits:" + creditcounter);
			break;

		case "2":
			for (CourseBean cb : currentCourses) {
				if (counter == 0) {
					out.println(
							"<option selected value=\"" + cb.getCourseID() + "\">" + cb.getCourseID() + " </option>");
					counter++;
				} else {
					out.println("<option value=\"" + cb.getCourseID() + "\">" + cb.getCourseID() + "</option>");
				}
			}
			out.println("</select>");
			break;
		default:
			break;
		}
	}

}
