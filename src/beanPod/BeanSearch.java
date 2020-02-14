package beanPod;

import java.util.ArrayList;
import java.util.Hashtable;

public interface BeanSearch {
	public abstract boolean findStudent(String studentID, Hashtable<String, ArrayList<CourseBean>> enrollmentLog);

}
