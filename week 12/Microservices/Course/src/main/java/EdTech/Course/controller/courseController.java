package EdTech.Course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import EdTech.Course.dto.CourseDto;
import EdTech.Course.dto.ResponseMessage;
import EdTech.Course.model.Course;
import EdTech.Course.model.CourseMaterial;
import EdTech.Course.service.CourseService;

/*
 * 1. GET /courses: Get all courses.
2. GET /courses/{id}: Get a course by its ID.
3. GET /courses/name/{name]: Get the course by its name.
4. GET /courses/courseMaterial/[id}: Get all course materials using course id.
5. GET /courses/instructor/{name]: GET course by instructor name
6. POST /courses: Create a new course.
7. PUT /courses/{id}: Update a course by its ID.
8. DELETE /courses/{id}: Delete a course by its ID.
4. The controller method names for the APIs should be as follows:
1. GET /courses: getAllCourses()
2. GET /courses/{id}: getCourseByld()
3. GET /courses/name/{name}: getCourseByName()
4. GET /courses/courseMaterial/[id}: getCourseMaterialByCourseld()
5. GET /courses/instructor/{name}: getCourseBylnstructor()
6. POST /courses:createCourse()
7. PUT /courses/{id}: updateCourse()
8. DELETE /courses/{id}: deleteCourse()
 */

@RestController
@RequestMapping("/courses")
public class courseController {

	@Autowired
	CourseService courseService;

	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Course getCourseById(@PathVariable Long id) {
		
		return courseService.getCourseById(id);
	}
	
	@GetMapping("/name")
	@ResponseStatus(HttpStatus.OK)
	public Course getCourseByName(@RequestParam String name) {
		return courseService.getCourseByName(name);
	}
	
	@GetMapping("/courseMaterial")
	@ResponseStatus(HttpStatus.OK)
	public List<CourseMaterial>getCourseMaterialByCourseId(@RequestParam Long id){
		return courseService.getCourseMaterialByCourseId(id);
	}
	
	@GetMapping("/instructor")
	@ResponseStatus(HttpStatus.OK)
	public Course getCourseByInstructor(@RequestParam String instructor) {
		return courseService.getCourseByInstructor(instructor);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage createCourse(@RequestBody CourseDto courseDto) {
		courseService.createCourse(courseDto);
		ResponseMessage response = new ResponseMessage();
		response.setMessage("Course created successfully");
		return response;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage updateCourse(@PathVariable Long id,@RequestBody CourseDto courseDto) {
		courseService.updateCourse(id, courseDto);
		ResponseMessage response = new ResponseMessage();
		response.setMessage("Course updated successfully");
		return response;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseMessage deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		ResponseMessage response = new ResponseMessage();
		response.setMessage("Course deleted successfully");
		return response;
	}
	
	
	
	
}
