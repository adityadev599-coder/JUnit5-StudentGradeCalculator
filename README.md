# JUnit 5 Student Grade Calculator

A simple Java application created to practice **unit testing with JUnit 5 and Maven**.

## Features

- Calculate total marks
- Calculate percentage
- Calculate grade
- Check pass/fail status
- Validate marks
- Handle invalid input using exceptions

## Tech Stack

- Java 17
- Maven
- JUnit 5

## JUnit 5 Concepts

- Test lifecycle: `@BeforeAll`, `@BeforeEach`, `@AfterEach`, `@AfterAll`
- `@Test` and `@DisplayName`
- `@Disabled`
- Assertions: `assertEquals`, `assertTrue`, `assertFalse`, `assertAll`
- Exception testing: `assertThrows`, `assertDoesNotThrow`
- Timeout testing: `assertTimeout`
- Parameterized tests: `@ParameterizedTest`, `@ValueSource`, `@CsvSource`

## Project Structure

```text
src/
├── main/java/com/aditya/grade/
│   └── GradeCalculator.java
│
└── test/java/com/aditya/grade/
    └── GradeCalculatorTest.java
