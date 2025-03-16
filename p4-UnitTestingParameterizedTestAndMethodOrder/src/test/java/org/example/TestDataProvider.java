package org.example;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestDataProvider {
    public static Stream<Arguments> provideStudentData() {
        return Stream.of(
                Arguments.of("John Doe", 20, "Computer Science", true),
                Arguments.of("Jane Smith", 22, "Mathematics", true),
                Arguments.of("", 18, "Physics", false),
                Arguments.of("Bob Martin", 15, "Chemistry", false),
                Arguments.of("Alice Johnson", 61, "Biology", false)
        );
    }
}