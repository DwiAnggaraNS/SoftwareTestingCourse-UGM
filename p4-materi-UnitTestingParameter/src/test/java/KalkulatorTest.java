import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KalkulatorTest {

    // Ini kalau parameter di test method nya lebih dari satu
    @Order(1)
    @ParameterizedTest
    @CsvSource
            ({
                    "2, 3, 5",
                    "5, 5, 10",
                    "-5, 5, 0",
                    "-5, -5, -10"
            })
    void testTambah(int a, int b, int expected) {
        Kalkulator kalkulator = new Kalkulator();
        assertEquals(expected, kalkulator.tambah(a, b));
    }


    // Ini khusus satu parameter saja
    @Order(2)
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEven(int number) {
        Kalkulator kalkulator = new Kalkulator();
        assertTrue(kalkulator.isEven(number));
    }

    // Ini redundan assert equalnya karena ga pake anotasi parameterized test
    @Test
    void testTambah() {
        Kalkulator kalkulator = new Kalkulator();

        assertEquals(5, kalkulator.tambah(2, 3));
        assertEquals(10, kalkulator.tambah(5, 5));
        assertEquals(0, kalkulator.tambah(-5, 5));
        assertEquals(-10, kalkulator.tambah(-5, -5));

    }

    @ParameterizedTest
    @MethodSource("DataProvider#provideAdditionData")
    void testTambahData(int a, int b, int expected) {
        Kalkulator kalkulator = new Kalkulator();

        assertEquals(expected, kalkulator.tambah(a, b));
    }

    static Stream<List<String>> provideArrayData(){
        return Stream.of(
                Arrays.asList("abc", "def", "ghi"),
                Arrays.asList("jkl", "mno", "pqr"),
                Arrays.asList("stu", "vwx", "yz")
        );
    }

    // Static stream of arguments itu method yang akan dipanggil oleh test function saat dijalankan
    // Jadi, method yang dipanggil harus static. Sedangkan @ValueSource itu langsung diambil value nya
    // Sama seperti @CsvSource


    // Kalau stream of arguments itu buat parameter yang lebih dari satu


    // Anotasi order digunakan untuk mengatur urutan eksekusi test function
    // Jika tidak ada anotasi order, maka test function akan dijalankan secara random

    @Test
    void kurang() {
    }

    @Test
    void kali() {
    }

    @Test
    void bagi() {
    }

    @Test
    void isEven() {
    }
}