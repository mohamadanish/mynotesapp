import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminTest {
	private Admin admin;
	private int id;
	private int ids;
	@BeforeEach
	void setUp() throws Exception {
		admin = new Admin(0, null,null,null,null,null);
		id = 3;
		ids = 9;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testGetConnection() {
//		fail("Not yet implemented");
//	}
	
	@Test
	void testShowEditForm() {
		assertTrue(admin.showEditForm(ids));
	}

	@Test
	void testDeletUser() {
		assertTrue(admin.deletUser(id));

	}
	
	@Test
	void testUpdateUser() {
		assertTrue(admin.updateUser(id));
	}
	
	@Test
	void testUpdateProfile() {
		assertTrue(admin.updateProfile(id));
	}
	
	@Test
	void testShowUpdateForm() {
		assertTrue(admin.showUpdateForm(ids));
	}
	
	@Test
	void testListUsers() {
		assertTrue(admin.listUsers());
	}
	

}
