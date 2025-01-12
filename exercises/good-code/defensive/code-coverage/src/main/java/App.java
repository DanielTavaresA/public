import model.Course;
import model.Lecturer;
import store.Courses;

import java.util.Optional;

public class App {
  public static void demonstrate() {
    String code = "The code";
    Courses.findByCode(code)
            .flatMap(Course::getLecturer)
            .flatMap(Lecturer::getName)
            .ifPresent(System.out::println);

  }
}