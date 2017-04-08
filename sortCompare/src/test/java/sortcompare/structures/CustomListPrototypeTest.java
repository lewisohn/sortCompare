package sortcompare.structures;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the CustomList prototype. Work-in-progress.
 * @author Oliver Lewisohn
 */
public class CustomListPrototypeTest {

	private CustomListPrototype<Integer> list;
	private final Random rand;

	public CustomListPrototypeTest() {
		rand = new Random();
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		list = new CustomListPrototype<>();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testAdd() {
		int add;
		for (int i = 0; i < 100; i++) {
			add = rand.nextInt(100 * (i + 1));
			list.add(add);
			assertTrue((Integer) list.getArray()[i] == add);
		}
	}

//	@Test
//	public void testAppend_CustomList() {
//		CustomList<Integer> list2 = new CustomList<Integer>();
//	}
//
//	@Test
//	public void testAppend_GenericType() {
//		System.out.println("append");
//		Object[] source = null;
//		CustomList instance = new CustomList();
//		boolean expResult = false;
//		boolean result = instance.append(source);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testPoll() {
//		System.out.println("poll");
//		CustomList instance = new CustomList();
//		Object expResult = null;
//		Object result = instance.poll();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testToString() {
//		System.out.println("toString");
//		CustomList instance = new CustomList();
//		String expResult = "";
//		String result = instance.toString();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testIsEmpty() {
//		System.out.println("isEmpty");
//		CustomList instance = new CustomList();
//		boolean expResult = false;
//		boolean result = instance.isEmpty();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testSize() {
//		System.out.println("size");
//		CustomList instance = new CustomList();
//		int expResult = 0;
//		int result = instance.size();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testGet() {
//		System.out.println("get");
//		int index = 0;
//		CustomList instance = new CustomList();
//		Object expResult = null;
//		Object result = instance.get(index);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testSet() {
//		System.out.println("set");
//		int index = 0;
//		Object e = null;
//		CustomList instance = new CustomList();
//		instance.set(index, e);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testRemove_int() {
//		System.out.println("remove");
//		int index = 0;
//		CustomList instance = new CustomList();
//		instance.remove(index);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testRemove_GenericType() {
//		System.out.println("remove");
//		Object e = null;
//		CustomList instance = new CustomList();
//		boolean expResult = false;
//		boolean result = instance.remove(e);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testClear() {
//		System.out.println("clear");
//		CustomList instance = new CustomList();
//		instance.clear();
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testContains() {
//		System.out.println("contains");
//		Object e = null;
//		CustomList instance = new CustomList();
//		boolean expResult = false;
//		boolean result = instance.contains(e);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testCopy() {
//		System.out.println("copy");
//		CustomList instance = new CustomList();
//		CustomList expResult = null;
//		CustomList result = instance.copy();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	@Test
//	public void testIterator() {
//		System.out.println("iterator");
//		CustomList instance = new CustomList();
//		Iterator expResult = null;
//		Iterator result = instance.iterator();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
}
