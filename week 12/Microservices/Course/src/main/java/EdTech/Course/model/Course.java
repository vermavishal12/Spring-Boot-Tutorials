package EdTech.Course.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String instructor;
    private Long amount;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<Enrollment> enrollment = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<CourseMaterial> courseMaterial = new ArrayList<>();
    
}
