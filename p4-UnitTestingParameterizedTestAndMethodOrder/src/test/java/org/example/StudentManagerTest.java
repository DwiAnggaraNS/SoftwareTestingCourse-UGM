package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {
    private static StudentManager studentManager;

    @BeforeAll
    static void initAll() {
        System.out.println("Initializing all tests");
        studentManager = new StudentManager();
    }

    @AfterEach
    void tearDown() {
        studentManager.clearAllStudents();
    }

    @AfterAll
    static void tearDownAll() {
        studentManager = null;
        System.out.println("Cleaning up all tests");
    }

    // ------------------------------------------------------------------------
    // 1. Implementasi @ParameterizedTest dengan berbagai source
    // ------------------------------------------------------------------------

    // 1.1 Penggunaan @CsvSource
    @Order(1)
    @ParameterizedTest(name = "Test #{index} - Grade {0} should return status {1}")
    @CsvSource({
            "90, A",
            "75, B",
            "65, C",
            "55, D",
            "45, E",
            "-10, Invalid Grade",
            "110, Invalid Grade"
    })
    void testCheckGradeStatus(double grade, String expectedStatus) {
        String actualStatus = studentManager.checkGradeStatus(grade);
        assertEquals(expectedStatus, actualStatus,
                "The grade status for " + grade + " should be " + expectedStatus);
    }

    // 1.2 Penggunaan @ValueSource
    @Order(2)
    @ParameterizedTest(name = "Major {0} should return valid subjects")
    @ValueSource(strings = {"Computer Science", "Mathematics", "Physics"})
    void testGetSubjectsForValidMajor(String major) {
        List<String> subjects = studentManager.getSubjectsByMajor(major);
        assertNotNull(subjects);
        assertEquals(4, subjects.size(), "Should return 4 subjects for " + major);
        assertFalse(subjects.contains("No specific subjects found"));
    }

    // 1.3 Penggunaan @MethodSource dari kelas test yang sama
    @Order(3)
    @ParameterizedTest(name = "Test #{index} - Acceptance with scores: math={0}, english={1}, science={2} should be {3}")
    @MethodSource("provideTestScores")
    void testStudentAcceptance(int mathScore, int englishScore, int scienceScore, boolean expectedResult) {
        boolean isAccepted = studentManager.isAccepted(mathScore, englishScore, scienceScore);
        assertEquals(expectedResult, isAccepted);
    }

    static Stream<Arguments> provideTestScores() {
        return Stream.of(
                Arguments.of(80, 75, 70, true),  // All above 60, average above 70
                Arguments.of(90, 90, 90, true),  // All high scores
                Arguments.of(60, 60, 60, false), // All 60, but average is 60
                Arguments.of(90, 90, 50, false), // One below 60
                Arguments.of(40, 80, 90, false)  // One below 60
        );
    }

    // 1.4 Penggunaan @MethodSource dari kelas eksternal
    @Order(4)
    @ParameterizedTest(name = "Test #{index} - Adding student: {0}, {1}, {2}")
    @MethodSource("org.example.TestDataProvider#provideStudentData")
    void testAddStudent(String name, int age, String major, boolean expectedResult) {
        boolean result = studentManager.addStudent(name, age, major);
        assertEquals(expectedResult, result,
                "Adding student " + name + " with age " + age + " should return " + expectedResult);
    }

    // ------------------------------------------------------------------------
    // 1.5 - 1.6 Eksplorasi Penggunaan Parameterized Test
    // ------------------------------------------------------------------------

    // Enum untuk digunakan dengan @EnumSource
    enum StudentAgeCategory {
        FRESHMAN(18, 17, 19),
        SOPHOMORE(20, 19, 21),
        JUNIOR(22, 21, 23),
        SENIOR(24, 23, 26);

        private final int typicalAge;
        private final int minAge;
        private final int maxAge;

        StudentAgeCategory(int typicalAge, int minAge, int maxAge) {
            this.typicalAge = typicalAge;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public int getTypicalAge() {
            return typicalAge;
        }

        public int getMinAge() {
            return minAge;
        }

        public int getMaxAge() {
            return maxAge;
        }
    }

    // 1.5: @EnumSource
    @Order(5)
    @ParameterizedTest(name = "Test with {0}")
    @EnumSource(StudentAgeCategory.class)
    void testAgeCategories(StudentAgeCategory category) {
        studentManager.addStudent("Test Student", category.getTypicalAge(), "Test Major");
        List<Student> filtered = studentManager.filterStudentsByAgeRange(
                category.getMinAge(), category.getMaxAge());

        assertEquals(1, filtered.size(),
                "Should find one student in age range " + category.name());
    }

    // 1.6 Eksplorasi tambahan: @ParameterizedTest dengan kombinasi ArgumentsSource
    @Order(6)
    @ParameterizedTest(name = "Test #{index} - Explore ArgumentsProvider")
    @ArgumentsSource(StudentDataArgumentsProvider.class)
    void testAddStudentWithCustomProvider(String name, int age, String major, boolean expectedResult) {
        boolean result = studentManager.addStudent(name, age, major);
        assertEquals(expectedResult, result);
    }

    // Custom ArgumentsProvider untuk eksplorasi tambahan
    static class StudentDataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("Maria Garcia", 19, "Computer Science", true),
                    Arguments.of("Siti Aminah", 20, "Mathematics", true),
                    Arguments.of("David Wang", 35, "Physics", true),
                    Arguments.of("", 21, "Chemistry", false),
                    Arguments.of("James Bond", 15, "Secret Service", false)
            );
        }
    }

    // ------------------------------------------------------------------------
    // Eksplorasi tambahan Parameterized Test
    // ------------------------------------------------------------------------

    // Eksplorasi: Kombinasi multiple argument sources dengan @MethodSource
    @Order(7)
    @ParameterizedTest(name = "Subjects test #{index}: Major={0}")
    @MethodSource("provideMajorsAndExpectedSubjects")
    void testGetSubjectsForMajorWithExpectedList(String major, List<String> expectedSubjects) {
        List<String> actualSubjects = studentManager.getSubjectsByMajor(major);
        assertEquals(expectedSubjects.size(), actualSubjects.size(),
                "Should return correct number of subjects for " + major);

        for (String subject : expectedSubjects) {
            assertTrue(actualSubjects.contains(subject),
                    "Subject " + subject + " should be in the list for " + major);
        }
    }

    static Stream<Arguments> provideMajorsAndExpectedSubjects() {
        return Stream.of(
                Arguments.of("Computer Science", Arrays.asList("Programming", "Database", "Algorithm", "Networking")),
                Arguments.of("Mathematics", Arrays.asList("Calculus", "Linear Algebra", "Statistics", "Discrete Mathematics")),
                Arguments.of("Physics", Arrays.asList("Mechanics", "Electricity", "Thermodynamics", "Modern Physics")),
                Arguments.of("Unknown", Arrays.asList("No specific subjects found"))
        );
    }

    // Eksplorasi: Nested testing untuk mengelompokkan test case
    @Nested
    @Order(8)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ScholarshipEligibilityTests {

        @Order(1)
        @Test
        void testHighAchiever() {
            boolean result = studentManager.isEligibleForScholarship(3.9, 5, true);
            assertTrue(result, "High achiever should be eligible");
        }

        @Order(2)
        @Test
        void testBorderlineCase() {
            boolean result = studentManager.isEligibleForScholarship(3.0, 1, true);
            assertTrue(result, "Student at GPA threshold with activities should be eligible");
        }

        @Order(3)
        @Test
        void testIneligibleCase() {
            boolean result = studentManager.isEligibleForScholarship(2.9, 0, false);
            assertFalse(result, "Low performing student should not be eligible");
        }
    }

    // Eksplorasi: Penggunaan @RepeatedTest untuk testing stabilitas
    @Order(9)
    @RepeatedTest(5)
    void repeatedAddAndClearTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());

        // Add three random students
        studentManager.addStudent("Student" + repetitionInfo.getCurrentRepetition() + "A", 18 + repetitionInfo.getCurrentRepetition(), "Major1");
        studentManager.addStudent("Student" + repetitionInfo.getCurrentRepetition() + "B", 20 + repetitionInfo.getCurrentRepetition(), "Major2");
        studentManager.addStudent("Student" + repetitionInfo.getCurrentRepetition() + "C", 22 + repetitionInfo.getCurrentRepetition(), "Major3");

        // Verify count
        assertEquals(3, studentManager.getAllStudents().size(), "Should have 3 students");

        // Clear and verify
        studentManager.clearAllStudents();
        assertEquals(0, studentManager.getAllStudents().size(), "Should have 0 students after clearing");
    }
}