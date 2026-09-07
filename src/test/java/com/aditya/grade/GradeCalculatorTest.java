package com.aditya.grade;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    private GradeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new GradeCalculator();
    }

    @Test
    @DisplayName("Should calculate total marks correctly")
    void shouldCalculateTotalMarks() {
        int[] marks = {80, 90, 70, 60, 100};

        int result = calculator.calculateTotal(marks);

        assertEquals(400, result);
    }

    @Test
    @DisplayName("Should calculate percentage correctly")
    void shouldCalculatePercentage() {
        int[] marks = {80, 90, 70, 60, 100};

        double result = calculator.calculatePercentage(marks);

        assertEquals(80.0, result);
    }

    @Test
    @DisplayName("Should return correct grade")
    void shouldReturnCorrectGrade() {

        assertAll(
                () -> assertEquals("A", calculator.calculateGrade(95)),
                () -> assertEquals("B", calculator.calculateGrade(85)),
                () -> assertEquals("C", calculator.calculateGrade(75)),
                () -> assertEquals("D", calculator.calculateGrade(65)),
                () -> assertEquals("F", calculator.calculateGrade(35))
        );
    }

    @Test
    @DisplayName("Should correctly determine pass or fail")
    void shouldCheckIfStudentPassed() {

        assertAll(
                () -> assertTrue(calculator.isPassed(50)),
                () -> assertFalse(calculator.isPassed(30))
        );
    }

    @Test
    @DisplayName("Should throw exception for invalid marks")
    void shouldThrowExceptionForInvalidMarks() {

        int[] marks = {80, 105, 70};

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotal(marks)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "35, F"
    })
    @DisplayName("Should return correct grade for percentage")
    void shouldReturnCorrectGrade(double percentage, String expectedGrade) {

        assertEquals(expectedGrade, calculator.calculateGrade(percentage));
    }

    @ParameterizedTest
    @ValueSource(doubles = {40, 50, 60, 75, 90})
    @DisplayName("Should pass students with percentage 40 or above")
    void shouldPassStudent(double percentage) {

        assertTrue(calculator.isPassed(percentage));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 20, 30, 39.9})
    @DisplayName("Should fail students below 40 percent")
    void shouldFailStudent(double percentage) {

        assertFalse(calculator.isPassed(percentage));
    }
    @Test
    @DisplayName("Should calculate total without throwing exception")
    void shouldCalculateWithoutException() {

        int[] marks = {80, 90, 70};

        assertDoesNotThrow(() -> calculator.calculateTotal(marks));
    }

    @Test
    @DisplayName("Should calculate total within time limit")
    void shouldCalculateWithinTimeLimit() {

        int[] marks = {80, 90, 70};

        assertTimeout(
                java.time.Duration.ofMillis(100),
                () -> calculator.calculateTotal(marks)
        );
    }
    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Grade Calculator tests...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished Grade Calculator tests.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @Test
    @Disabled("Demonstration of @Disabled")
    @DisplayName("Disabled test example")
    void disabledTestExample() {

        assertEquals("A", calculator.calculateGrade(95));
    }

    @Test
    @DisplayName("Should calculate total for zero marks")
    void shouldCalculateTotalForZeroMarks() {
        assertEquals(0, calculator.calculateTotal(new int[]{0, 0, 0}));
    }

    @Test
    @DisplayName("Should accept boundary mark values")
    void shouldAcceptBoundaryMarks() {
        assertAll(
                () -> assertDoesNotThrow(() -> calculator.calculateTotal(new int[]{0})),
                () -> assertDoesNotThrow(() -> calculator.calculateTotal(new int[]{100}))
        );
    }

    @Test
    @DisplayName("Should reject negative marks")
    void shouldRejectNegativeMarks() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotal(new int[]{80, -10, 70})
        );
    }
}