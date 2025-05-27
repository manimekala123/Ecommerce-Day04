package lk.ac.vau.fas.ict.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {

	Student st1 = new Student("2020ICT103","Alice",25,"IT",3.8);
	Student st2 = new Student("2020ICT40","Bob",24,"IT",3.4);
	Student st3 = new Student("2020ICT87","Jane",23,"IT",2.9);
	Student st4 = new Student("2020ICT09","Michel",25,"IT",3.1);
	Student st5 = new Student("2020ICT05","Nick",22,"IT",3.0);
	

	
	private Map<String,Student> mstudent = new HashMap<String,Student>();
	
	@GetMapping("/addDetails")
	public void addobjects() {
		mstudent.put(st1.getRegNo(),st1);
		mstudent.put(st2.getRegNo(),st2);
		mstudent.put(st3.getRegNo(),st3);
		mstudent.put(st4.getRegNo(),st4);
	}
	
	@GetMapping("/details")
	public Map<String,Student> getdetails(){
		return mstudent;
	}
	
	
	/*add student*/
	@PostMapping("/add")
	public String addstudent(@RequestBody Student student) {
		mstudent.put(student.getRegNo(),student);
		return "New Student Added";
	}
	
	//Update the student
	   @PutMapping("/update/{id}")
	   public String UpdateStudent(@PathVariable("id") String regNo,@RequestBody Student student)
	   {
		   if(mstudent.get(regNo) != null)
		   {
			mstudent.put(student.getRegNo(), student);
			   return "Update Successfully!";
		   }
		   return "404 Student not found";
	   }
	   
	   //Delete the student
	   @DeleteMapping("/students/{id}")
	   public String DeleteStudent(@PathVariable("id") String regNo)
	   {
		   if(mstudent.get(regNo) != null)
		   {
			mstudent.remove(regNo);
			   return "Student Delete SuccessFully.";
		   }
		   return "404 not found student";
	   }
}
