package lk.ac.vau.fas.ict.model;

public class Course {

	private int CourseId;
	private String CourseName;
	public Course(int courseId, String courseName) {
		super();
		CourseId = courseId;
		CourseName = courseName;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
}
