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
	
	@Test
	public void testGetCurrentEarnedCr()
	{
		int credits = 45;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
	}
	
	@Test
	public void testNotReadyToGraduate1()
	{
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(false);
		assertFalse(student1.readyToGraduate());
	}
	
	@Test
	public void testAnticipatedRemaingCredits()
	{
		student1.setAnticipatedAdditionalCr(50);
		assertEquals(70, student1.getAnticipatedRemainingCr());
	}
	
	@Test
	public void testNotReadyToGraduate2()
	{
		student2.setCurrentEarnedCr(50);
		student2.setGpa(3.4);
		student2.setMajorComplete(true);
		student2.setLascComplete(true);
		assertFalse(student2.readyToGraduate());
	}
	
	@Test
	public void testReadyToGraduate2()
	{
		student2.setCurrentEarnedCr(120);
		student2.setGpa(4.8);
		student2.setMajorComplete(true);
		student2.setLascComplete(true);
		assertTrue(student2.readyToGraduate());
	}
	
	@Test
	public void testGetCurrentRemainingCr()
	{
		student2.setCurrentEarnedCr(50);
		assertEquals(70, student2.getCurrentRemainingCr());
	}
	
	@Test
	public void testGetLascComplete()
	{
		student2.setLascComplete(true);
		assertTrue(student2.getLascComplete());
	}
	
	@Test
	public void testGetLascComplete2()
	{
		student2.setLascComplete(false);
		assertFalse(student2.getLascComplete());
	}
}