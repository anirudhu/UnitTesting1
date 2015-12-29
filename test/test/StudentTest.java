package test;
import org.junit.*;
import static org.junit.Assert.*;
import edu.worcester.cs.kwurst.*;
public class StudentTest
{
	private Student student1, student2;	
	@Before
	public void setup()
	{
		student1 = new Student("Jane", "Smith");
		student2 = new Student("Steve", "Nash");
	}
	
	/**
	 * testGetCurrentCr check to see if
	 * the setCurrentEarnedCr and getCurrentEarnedCr
	 * works correctly by seeing if the correct number
	 * of credits is returned 
	 */
	
	@Test
	public void testGetCurrentEarnedCr()
	{
		int credits = 45;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
	}
	
	/**
	 * testNotReadyToGraduate1 is used to
	 * try to make sure that the readyToGraduate
	 * method returns false if the requirements
	 * are not met. In this case it returns false
	 * because the LascComplete is false
	 */
	
	@Test
	public void testNotReadyToGraduate1()
	{
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(false);
		assertFalse(student1.readyToGraduate());
	}
	
	/**
	 * testAnticipatedRemaingCredits is used to
	 * validate if the correct number of remaining
	 * credits is returned. You need 120 to graduate
	 * and after completing 50 it validates to see
	 * if 70 credits are needed to graduate
	 */
	
	@Test
	public void testAnticipatedRemaingCredits()
	{
		student1.setAnticipatedAdditionalCr(50);
		assertEquals(70, student1.getAnticipatedRemainingCr());
	}
	
	/**
	 * testNotReadyToGraduate2 is used to
	 * try to make sure that the readyToGraduate
	 * method returns false if the requirements
	 * are not met. In this case it returns false
	 * because the earned credits does not meet
	 * requirements
	 */
	
	@Test
	public void testNotReadyToGraduate2()
	{
		student2.setCurrentEarnedCr(50);
		student2.setGpa(3.4);
		student2.setMajorComplete(true);
		student2.setLascComplete(true);
		assertFalse(student2.readyToGraduate());
	}
	
	/**
	 * testReadyToGraduate is used to
	 * try to make sure that the readyToGraduate
	 * method returns true if the requirements
	 * are met. In this case it returns true
	 * because all the requirements are met
	 */
	
	@Test
	public void testReadyToGraduate()
	{
		student2.setCurrentEarnedCr(120);
		student2.setGpa(4.8);
		student2.setMajorComplete(true);
		student2.setLascComplete(true);
		assertTrue(student2.readyToGraduate());
	}
	
	/**
	 * testGetCurrentRemainingCr is used to
	 * validate if the correct number of remaining
	 * credits is returned. You need 120 to graduate
	 * and after completing 50 it validates to see
	 * if 70 credits are needed to graduate
	 */
	
	@Test
	public void testGetCurrentRemainingCr()
	{
		student2.setCurrentEarnedCr(50);
		assertEquals(70, student2.getCurrentRemainingCr());
	}
	
	/**
	 * testGetLascComplete is used to
	 * check if the Lasc requirements
	 * are met. Returns true if they 
	 * are. Here returns true.
	 */
	
	@Test
	public void testGetLascComplete()
	{
		student2.setLascComplete(true);
		assertTrue(student2.getLascComplete());
	}
	
	/**
	 * testGetLascComplete is used to
	 * check if the Lasc requirements
	 * are met. Returns true if they 
	 * are. Here returns false.
	 */
	
	@Test
	public void testGetLascComplete2()
	{
		student2.setLascComplete(false);
		assertFalse(student2.getLascComplete());
	}
}