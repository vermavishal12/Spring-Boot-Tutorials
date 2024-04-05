package EdTech.Course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EdTech.Course.dto.CourseDto;
import EdTech.Course.dto.ResponseMessage;
import EdTech.Course.model.Course;
import EdTech.Course.model.CourseMaterial;
import EdTech.Course.repository.CourseRepository;
import EdTech.Course.repository.EnrollmentRepository;

/*
 *The service class method names should be as follows:
1. GET /courses: getAllCourses()
2. GET /courses/{id}: getCourseByld()
3. GET /courses/name/{name}: getCourseByName()
4. GET /courses/courseMaterial/{id}: getCourseMaterialByCourseld()
5. GET /courses/instructor/{name}: getCourseByInstructor()
6. POST /courses:createCourse()
7. PUT /courses/[id}: updateCourse()
8. DELETE /courses/{id}: deleteCourse()
 */

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course getCourseById(Long courseId) {
		Course course = courseRepository.findById(courseId).orElse(null);
		if(course == null) {
			
		}
		return course;
	}
	
	public Course getCourseByName(String name) {
		Course course = courseRepository.findByName(name);
		if(course == null) {
			
		}
		return course;
	}
	
	public List<CourseMaterial> getCourseMaterialByCourseId(Long CourseId) {
		Course course = courseRepository.findById(CourseId).orElse(null);
		if(course == null) {
			
		}
		
		
		List<CourseMaterial> courseMaterials = course.getCourseMaterial();
		return courseMaterials;
	}
	
	public Course getCourseByInstructor(String name) {
		Course course = courseRepository.findByInstructor(name);
		if(course == null) {
			
		}
		return course;
	}
	
	public void createCourse(CourseDto courseDto) {
		Course course = new Course();
		course.setAmount(courseDto.getAmount());
		course.setDescription(course.getDescription());
		course.setInstructor(courseDto.getInstructor());
		course.setName(courseDto.getName());
		if(courseDto.getCourseMaterial() != null) {
			
			course.setCourseMaterial(courseDto.getCourseMaterial());
		}
		if(courseDto.getEnrollments() != null) {
//			enrollmentRepository.saveAll(courseDto.getEnrollments());
			course.setEnrollment(courseDto.getEnrollments());
		}
		
		courseRepository.save(course);
		
	}
	
	public void updateCourse(Long id , CourseDto courseDto) {
		Course course = courseRepository.findById(id).orElse(null);
		
		if(course == null) {
			
		}
		
		course.setAmount(courseDto.getAmount());
		if(courseDto.getCourseMaterial() != null) {
			course.setCourseMaterial(courseDto.getCourseMaterial());
		}
		
		course.setDescription(courseDto.getDescription());
		course.setInstructor(courseDto.getInstructor());
		course.setName(courseDto.getName());
		
		if(courseDto.getEnrollments() != null) {
			enrollmentRepository.saveAll(courseDto.getEnrollments());
			course.setEnrollment(courseDto.getEnrollments());
		}
		
		courseRepository.save(course);
		
	}
	
	public void deleteCourse(Long id) {
		Course course = courseRepository.findById(id).orElse(null);
		
		if(course == null) {
			
		}
		
		courseRepository.deleteById(id);
		
	}
}
