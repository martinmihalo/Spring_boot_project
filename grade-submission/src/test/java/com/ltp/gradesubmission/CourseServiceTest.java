package com.ltp.gradesubmission;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.CourseService;
import com.ltp.gradesubmission.service.CourseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private CourseServiceImpl courseServiceImpl;

    @Test
    public void getCoursesFromRepoTest(){
        when(courseServiceImpl.getCourses()).thenReturn(Arrays.asList(
                new Course("Logistics", "Log1", "about iternational logistics"),
                new Course("Math", "Mat1", "teaches students algebra")

        ));

        List<Course> result = courseServiceImpl.getCourses();

        assertEquals("Logistics", result.get(0).getSubject());
        assertEquals("Mat1", result.get(1).getCode());
    }





}
