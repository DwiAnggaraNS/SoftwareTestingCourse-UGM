import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {
    static Stream<Arguments> provideAdditionData() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(5, 5, 10),
                Arguments.of(-5, 5, 0),
                Arguments.of(-5, -5, -10)
        );
    }
}
