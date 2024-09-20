import java.util.*;

class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return name + " (" + studentId + ")";
    }
}

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return courseName + " (" + courseId + ")";
    }
}

class EnrollmentSystem {
    private Map<Student, Set<Course>> enrollments = new HashMap<>();

    // Enroll a student in a course
    public void enroll(Student student, Course course) {
        enrollments.computeIfAbsent(student, k -> new HashSet<>()).add(course);
    }

    // Get all courses a student is enrolled in
    public Set<Course> getCourses(Student student) {
        return enrollments.getOrDefault(student, Collections.emptySet());
    }

    // Unenroll a student from a course
    public void unenroll(Student student, Course course) {
        Set<Course> courses = enrollments.get(student);
        if (courses != null) {
            courses.remove(course);
            if (courses.isEmpty()) {
                enrollments.remove(student);
            }
        }
    }

    // Display all students and their enrolled courses
    public void displayEnrollments() {
        for (Map.Entry<Student, Set<Course>> entry : enrollments.entrySet()) {
            System.out.println(entry.getKey() + " enrolled in: " + entry.getValue());
        }
    }
}

public class co2_project {
    public static void main(String[] args) {
        EnrollmentSystem system = new EnrollmentSystem();

        // Create some students
        Student s1 = new Student("S001", "Alice");
        Student s2 = new Student("S002", "Bob");

        // Create some courses
        Course c1 = new Course("C001", "Mathematics");
        Course c2 = new Course("C002", "Physics");
        Course c3 = new Course("C003", "Chemistry");

        // Enroll students in courses
        system.enroll(s1, c1);
        system.enroll(s1, c2);
        system.enroll(s2, c1);
        system.enroll(s2, c3);

        // Display enrollments
        System.out.println("Initial Enrollments:");
        system.displayEnrollments();

        // Unenroll Bob from Chemistry
        system.unenroll(s2, c3);

        // Display enrollments after unenrollment
        System.out.println("\nEnrollments after unenrolling Bob from Chemistry:");
        system.displayEnrollments();
    }
}
