import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student = new Student("John", 7, true);

    @Test
    void test_isStudentDataValid() {
        assertAll(
                () -> assertEquals("John", student.name),
                () -> assertEquals(7, student.semester),
                () -> assertTrue(student.isActive)
        );
    }

    @Test
    void test_isDoingMBKM() {
        assertTrue(student.isDoingMBKM(), "John should do MBKM (Expected: true)");
    }
}