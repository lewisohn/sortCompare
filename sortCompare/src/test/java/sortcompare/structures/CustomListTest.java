/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcompare.structures;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oliver Lewisohn
 */
public class CustomListTest {

	private final Random rand;
	private CustomList<Integer> list;

	public CustomListTest() {
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
		list = new CustomList<>();
	}

	@After
	public void tearDown() {
	}

	private CustomList<Integer> fill(CustomList<Integer> clp, int n) {
		for (int i = 0; i < n; i++) {
			clp.add(rand.nextInt(100000));
		}
		return clp;
	}

	@Test
	public void testAdd() {
		int add;
		for (int i = 0; i < 1000; i++) {
			add = rand.nextInt(1000 * (i + 1));
			list.add(add);
			assertTrue((Integer) list.getArray()[i] == add);
		}
	}

	@Test
	public void testAppend() {
		fill(list, 1000);
		CustomList<Integer> list2 = new CustomList<>();
		fill(list2, 1000);
		list.append(list2);
		for (int i = 0; i < 1000; i++) {
			assertEquals(list.get(1000 + i), list2.get(i));
		}
	}

	@Test
	public void testClear() {
		fill(list, 1000);
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testContains() {
		int add;
		for (int i = 0; i < 1000; i++) {
			add = rand.nextInt(1000 * (i + 1));
			list.add(add);
			assertTrue(list.contains(add));
		}
	}

	@Test
	public void testCopy() {
		fill(list, 1000);
		CustomList<Integer> list2 = list.copy();
		for (int i = 0; i < 1000; i++) {
			assertEquals(list.get(i), list2.get(i));
		}
	}

	@Test
	public void testGet() {
		fill(list, 1000);
		for (int i = 0; i < 1000; i++) {
			assertEquals((Integer) list.getArray()[i], list.get(i));
		}
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		fill(list, 1000);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testPoll() {
		assertNull(list.poll());
		fill(list, 1000);
		for (int i = 0; i < 1000; i++) {
			assertEquals((Integer) list.getArray()[0], list.poll());
		}
	}

	@Test
	public void testSet() {
		fill(list, 1000);
		Integer temp;
		for (int i = 0; i < 1000; i++) {
			temp = list.get(i);
			temp++;
			list.set(i, temp);
			assertEquals(temp, list.get(i));
		}
	}

	@Test
	public void testSize() {
		assertEquals(0, list.size());
		fill(list, 1000);
		assertEquals(1000, list.size());
		for (int i = 0; i < 1000; i++) {
			list.poll();
			assertEquals(999 - i, list.size());
		}
	}

	@Test
	public void testRemove_index() {
		fill(list, 1000);
		Integer temp = list.get(501);
		list.remove(500);
		assertEquals(list.get(500), temp);
	}

	@Test
	public void testRemove_object() {
		fill(list, 1000);
		assertFalse(list.remove(new Integer(-1)));
		Integer temp = list.get(501);
		Integer remove = list.get(500);
		list.remove(remove);
		assertEquals(list.get(500), temp);
	}

	@Test
	public void testIterator() {
		fill(list, 1000);
		int i = 0;
		for (Integer integer : list) {
			assertEquals((Integer) list.getArray()[i++], integer);
		}
	}
}
