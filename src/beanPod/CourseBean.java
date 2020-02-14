package beanPod;

import java.io.Serializable;
import java.util.Comparator;

public class CourseBean implements Serializable, Comparable<CourseBean> {
	
	private String courseID;
	private String subjectID;
	private int courseCredNum;

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public int getCourseCredNum() {
		return courseCredNum;
	}

	public void setCourseCredNum(int courseCredNum) {
		this.courseCredNum = courseCredNum;
	}
	public static Comparator<CourseBean> CourseComparator = new Comparator<CourseBean>() {

		public int compare(CourseBean c1, CourseBean c2) {
		   String Course1 = c1.getCourseID();
		   String Course2 = c2.getCourseID();

		   return Course1.compareTo(Course2);
	    }
		};

	@Override
	public int compareTo(CourseBean o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
