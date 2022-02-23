
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author User
 *
 */
class RegisterServletTest {

	private RegisterServlet rs;
	private Admin a1;
	private Admin a2;
	private Admin a3;
	private Admin a4;
	private final int ADMIN_SIZE = 4;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//arrange
		rs  = new RegisterServlet();
		a1 = new Admin(1,"Nigel1","Nigel@2000","1nigelhow2k@gmail.com","hi1", "97538885");
		a2 = new Admin(2,"Nigel2","Nigel@2000","2nigelhow2k@gmail.com","hi2", "97538885");
		a3 = new Admin(3,"Nigel3","Nigel@2000","3nigelhow2k@gmail.com","hi3", "97538885");
		a4 = new Admin(4,"Nigel4","Nigel@2000","4nigelhow2k@gmail.com","hi4", "97538885");
		
		rs.doPost(null, null);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link RegisterServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link RegisterServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
