import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    private static UserManager userManager;

    @BeforeAll
    static void setUpClass(){
        userManager = new UserManager();
    }

    @BeforeEach
    void setUpMethod(){
        userManager.users.clear();
        System.out.println("Isi users setelah dibersihkan: " + userManager.users);
    }

    @Test
    void testAddUser_Size() {
        assertEquals(0, userManager.users.size());

        userManager.addUser("Agus");
        assertEquals(1, userManager.users.size());

        userManager.addUser("Budi");
        userManager.addUser("Citra");
        userManager.addUser("Dewi");
        assertEquals(4, userManager.users.size());
    }

    @Test
    void testIsUserExist_True() {
        userManager.addUser("Bob");
        assertTrue(userManager.isUserExist("Bob"));
    }

    @Test
    void testAddUser_SetValuesComparasion(){
        userManager.addUser("Agus");
        userManager.addUser("Budi");
        userManager.addUser("Citra");
        userManager.addUser("Dewi");

        assertAll(
                () -> assertTrue( userManager.isUserExist("Agus")),
                () -> assertTrue( userManager.isUserExist("Budi")),
                () -> assertTrue( userManager.isUserExist("Citra")),
                () -> assertTrue( userManager.isUserExist("Dewi"))
        );
    }

    @Test
    void testDuplicateUser(){
        userManager.addUser("Agus");
        userManager.addUser("Agus");
        assertEquals(1, userManager.users.size());
    }

    @Test
    void testIsUserExist_False() {
        assertFalse(userManager.isUserExist("Alice"));
        assertFalse(userManager.isUserExist("Bob"));
        assertFalse(userManager.isUserExist("Agus"));
    }

    @Test
    void testRemoveUser() {
        userManager.addUser("Alice");
        userManager.removeUser("Alice");
        assertFalse(userManager.isUserExist("Alice"));
        assertEquals(0, userManager.users.size());
    }


    @Test
    void testClearUsers() {
        userManager.addUser("User1");
        userManager.addUser("User2");
        userManager.clearUsers();
        assertEquals(0, userManager.users.size());
    }

    @AfterEach
    void tearDownMethod(){
        // Print isi saat ini
        System.out.println("Isi users setelah testFunction dijalankan: " + userManager.users);
        System.out.println("Cleaning up...");
        System.out.println();
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("Finalizing test class...");
        userManager.clearUsers();
        userManager = null;
    }
}