package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Import ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.CourseDAO;
import com.example.demo.DAO.DAO;
import com.example.demo.DAO.ProjectDAO;
import com.example.demo.model.Courses;
import com.example.demo.model.Projects;
import com.example.demo.model.User;

@RestController
@CrossOrigin
public class Controller {
    
    @Autowired
    DAO dao;
    
    @Autowired
    CourseDAO coursedao;
    
    @Autowired
    ProjectDAO projectdao;

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        dao.addUser(user);
        return user;
    }

    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        Optional<User> user = dao.loginUser(email, password);
        Map<String, Object> response = new HashMap<>();
        if (user.isPresent()) {
            response.put("message", "Login successful");
            response.put("user", user.get());
        } else {
            response.put("message", "Invalid email or password");
        }
        return response;
    }

    @PostMapping("/addcourse")
    public void addcourse(@RequestBody Courses courses) {
        coursedao.addCourse(courses);
    }

    @GetMapping("/viewcourses")
    public List<Courses> viewcourses() {
        return coursedao.getall();
    }


    @PostMapping("/addproject")
    public void addProject(@RequestBody Projects projects) {
        projectdao.saveProject(projects);
    }

    @GetMapping("/view-projects")
    public List<Projects> viewprojects() {
        return projectdao.viewProjects();
    }

    @DeleteMapping("/delete-project")
    public void deletecourse(@RequestParam String name) {
        projectdao.deleteProject(name);
    }

    @PutMapping("/update-project")
    public void updateproject(@RequestParam String name) {
        projectdao.UpdateProject(name);
    }

    @GetMapping("/count-projects")
    public ResponseEntity<Map<String, Long>> getProjectCount() {
        long count = projectdao.count(); // Assuming count method is available in ProjectDAO
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count-courses")
    public ResponseEntity<Map<String, Long>> getCourseCount() {
        long count = coursedao.count(); // Assuming count method is available in CourseDAO
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
