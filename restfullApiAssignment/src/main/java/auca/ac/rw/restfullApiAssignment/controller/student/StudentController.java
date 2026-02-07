package auca.ac.rw.restfullApiAssignment.controller.student;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gwt.editor.client.Editor.Path;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class StudentController {
    

    public static class Student{

        public Long id;
        public String firstname;
        public String lastname;
        public String email;
        public String major;
        public Double gpa;

        public Student(Long id, String firstname, String lastname, String email, String major, Double gpa) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.major = major;
            this.gpa = gpa;
        }
    }
    public List<Long> id = new ArrayList<>(Arrays.asList(1L,2L,3L));
    public List<String> firstname = new ArrayList<>(Arrays.asList("John","Jane","Kevin"));
    public List<String> lastname = new ArrayList<>(Arrays.asList("Smith","Doe","Johnson"));
    public List<String> email = new ArrayList<>(Arrays.asList("john.smith@auca.edu.bi", "jane.doe@auca.edu.bi", "doe.john@auca.edu.bi"));
    public List<String> major = new ArrayList<>(Arrays.asList("Computer Science", "Business Administration", "Engineering"));
    public List<Double> gpa = new ArrayList<>(Arrays.asList(3.5, 3.8, 3.2));

    @GetMapping(value="/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        for(int i=0; i<firstname.size(); i++){
            students.add(new Student(
                id.get(i),
                firstname.get(i),
                lastname.get(i),
                email.get(i),
                major.get(i),
                gpa.get(i)
            ));
        }
        return students;
    } 
    @GetMapping(value="/students/{id}")
    public List<Student> getStudentById(@PathVariable Long id){
        for(int i=0; i<firstname.size(); i++){
            if(this.id.get(i).equals(id)){
                List<Student> student = new ArrayList<>();
                student.add(new Student(
                    this.id.get(i),
                    firstname.get(i),
                    lastname.get(i),
                    email.get(i),
                    major.get(i),
                    gpa.get(i)
                ));
                return student;
            }
        }
        return null;
    }

    @GetMapping(value="/students/major/{major}")
    public List<Student> getStudentbyMajor(@PathVariable String major){
        List<Student> students = new ArrayList<>();
        for(int i=0; i<firstname.size(); i++){
            if(this.major.get(i).equals(major)){
                students.add(new Student(
                    this.id.get(i),
                    firstname.get(i),
                    lastname.get(i),
                    email.get(i),
                    this.major.get(i),
                    this.gpa.get(i)
                ));
            }
        }
        return students;
    }

    @GetMapping(value="/students/filter")
    public List<Student> getStudentsAbove(@RequestParam double gpa){
         List<Student> students = new ArrayList<>();
        for(int i=0; i<firstname.size(); i++){
            if(this.gpa.get(i) >= gpa){
                students.add(
                    new Student(
                    this.id.get(i),
                    firstname.get(i),
                    lastname.get(i),
                    email.get(i),
                    major.get(i),
                    this.gpa.get(i)
            ));
            }
    }
    return students;
    
    }

    @PostMapping(value="/students")
    public String addStudent(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String major, @RequestParam double gpa){
        this.id.add((long) (this.id.size() + 1));
        this.firstname.add(firstname);
        this.lastname.add(lastname);
        this.email.add(email);
        this.major.add(major);
        this.gpa.add(gpa);
        return "Student added successfully";
    }
    @PutMapping(value="/students/{id}")
    public String updateStudent(@PathVariable Long id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String major, @RequestParam double gpa){
        for(int i=0; i<this.id.size(); i++){
            if(this.id.get(i).equals(id)){
                this.firstname.set(i, firstname);
                this.lastname.set(i, lastname);
                this.email.set(i, email);
                this.major.set(i, major);
                this.gpa.set(i, gpa);
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }
}   