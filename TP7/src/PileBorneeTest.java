import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PileBorneeTest {
	
	@Test
	public void Test1() {
		PileBornee p = new PileBornee(1);
		assertEquals(true, p.isEmpty());
	}
	
	
	@Test
	public void Test2() throws FullStackException {
		PileBornee p = new PileBornee(1);
		p.push(4);
		assertEquals(false, p.isEmpty());
	}
	
	@Test
	public void Test3() {
		int maxSize = 4;
		PileBornee p = new PileBornee(maxSize);
		assertEquals(maxSize, p.getMaxSize());
	}
	
	@Test
	public void Test4() throws FullStackException {
		int maxSize = 4;
		PileBornee p = new PileBornee(maxSize);
		p.push(4);
		assertEquals(maxSize, p.getMaxSize());
	}
	
	@Test
	public void Test5() {
		PileBornee p = new PileBornee(4);
		assertEquals(0, p.getSize());
	}
	
	@Test
	public void Test6() throws FullStackException {
		PileBornee p = new PileBornee(2);
		p.push(4);
		assertEquals(1, p.getSize());
		
		p.push(21);
		assertEquals(2, p.getSize());
	}
	
	@Test
	public void Test7() throws FullStackException {
		PileBornee p = new PileBornee(4);
		p.push(44);
		assertEquals(false, p.isFull());
	}
	
	@Test
	public void Test8() throws FullStackException {
		PileBornee p = new PileBornee(2);
		p.push(4);
		assertEquals(false, p.isFull());
		p.push(0);
		assertEquals(true, p.isFull());
	}
	
	
	@Test
	public void Test9() throws EmptyStackException, FullStackException {
		PileBornee p = new PileBornee(2);
		p.push(444);
		assertEquals(444, p.top());
		
		p.push(12);
		assertEquals(12, p.top());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Test10() {
		PileBornee p = new PileBornee(2);
		assertEquals(2, p.getMaxSize());
		assertEquals(0, p.getSize());
		
		p.pop();
		assertEquals(2, p.getMaxSize());
		assertEquals(0, p.getSize());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Test11() throws EmptyStackException, FullStackException {
		PileBornee p = new PileBornee(2);
		p.push(0);
		p.pop();
		p.pop();

		
		int premiereValeurEmpilé = 6;
		p.push(premiereValeurEmpilé);
		p.push(5);
		p.pop();
		assertEquals(premiereValeurEmpilé, p.top());
	}
	
	@Test(expected = FullStackException.class)
	public void Test12() throws FullStackException {
		PileBornee p = new PileBornee(1);
		p.push(0);
		p.push(1);
	}
}
