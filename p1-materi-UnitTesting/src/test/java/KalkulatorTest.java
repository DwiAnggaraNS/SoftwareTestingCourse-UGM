import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorTest {

    @Test
    void testTambahValues() {
        Kalkulator kalkulator = new Kalkulator(1, 2);
        int hasil = kalkulator.tambah();
        assertEquals(3, hasil, "Hasil penjumlahan 1 + 2 seharusnya 3");
    }

    @Test
    void testTambahNotNull() {
        Kalkulator kalkulator = new Kalkulator(1, 2);
        int hasil = kalkulator.tambah();
        assertNotNull(hasil, "Hasil penjumlahan tidak boleh null");
    }

    @Test
    void testTambahComplete() {
        Kalkulator kalkulator = new Kalkulator(1, 2);
        assertAll(
                () -> assertEquals(1, kalkulator.a),
                () -> assertEquals(2, kalkulator.b),
                () -> assertEquals(3, kalkulator.tambah(), "Hasil penjumlahan 1 + 2 seharusnya 3"),
                () -> assertNotNull(kalkulator.tambah(), "Hasil penjumlahan tidak boleh null")
        );
    }


    @Test
    void testKurang() {
    }

    @Test
    void testKali() {
    }

    @Test
    void testBagi() {
    }
}