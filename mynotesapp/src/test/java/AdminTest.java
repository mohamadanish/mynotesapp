import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminTest {
	private Admin admin;
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
	private int ids;
	@BeforeEach
	void setUp() throws Exception {
		admin = new Admin(0, null,null,null,null,null);
		id = 40;
		username = "test";
		password = "test";
		email = "test";
		address = "test";
		phone = "11111111";
		ids = 90;
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
		assertTrue(admin.updateUser(ids,username, password, email, address, phone));
	}
	
	@Test
	void testUpdateProfile() {
		assertTrue(admin.updateProfile(ids,username, password, email, address, phone));
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
