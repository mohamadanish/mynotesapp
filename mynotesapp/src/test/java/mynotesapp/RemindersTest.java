/**
 * 
 */
package mynotesapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author User
 *
 */
class RemindersTest {
	private Reminders reminder;
	private int id;
	private int ids;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		reminder = new Reminders(0, "13 Feb" , "20 Feb" , "Test");
		id = 3;
		ids = 9;
	}

	@Test
	void testCreateReminder() {
		assertTrue(reminder.createReminder(id));
	}
	@Test
	void testGetReminder() {
		assertTrue(reminder.getReminder(id));
	}
	@Test
	void testUpdateReminder() {
		assertTrue(reminder.updateReminder(id));
	}
	@Test
	void testDeleteReminder() {
		assertTrue(reminder.deleteReminder(id));
	}

}
