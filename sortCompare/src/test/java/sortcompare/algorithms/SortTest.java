package sortcompare.algorithms;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sortcompare.structures.CustomList;

/**
 * Tests sorting algorithms.
 *
 * @author Oliver Lewisohn
 */
public abstract class SortTest {

	private final Random rand;
	CustomList<Integer> data;
	Sort algorithm;

	public SortTest() {
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
		data = new CustomList<>();
	}

	@After
	public void tearDown() {
	}

	private void test(CustomList<Integer> data) {
		data = algorithm.sort(data);
		for (int i = 0; i < data.size() - 1; i++) {
			assertTrue("Data is not sorted correctly.", data.get(i + 1) >= data.get(i));
		}
	}

	/**
	 * Test with very basic data.
	 */
	@Test(timeout = 100)
	public void basicTest() {
		data.append(new Integer[]{5, 2, 3, 4, 1});
		test(data);
	}

	/**
	 * Test with very basic negative data.
	 */
	@Test(timeout = 100)
	public void negativeTest() {
		data.append(new Integer[]{-5, -2, -3, -4, -1});
		test(data);
	}

	/**
	 * Test with data in descending order.
	 */
	@Test(timeout = 1000)
	public void reverseTest() {
		for (int i = 0; i < 1000; i++) {
			data.add(500 - i);
		}
		test(data);
	}

	/**
	 * Test with data already in ascending order.
	 */
	@Test(timeout = 1000)
	public void nullTest() {
		for (int i = 0; i < 1000; i++) {
			data.add(i);
		}
		test(data);
	}

	/**
	 * Test with random positive and negative numbers.
	 */
	@Test(timeout = 1000)
	public void randomTest() {
		for (int i = 0; i < 1000; i++) {
			data.add(rand.nextInt());
		}
		test(data);
	}

	/**
	 * Test with many small numbers and one very large number.
	 */
	@Test(timeout = 1000)
	public void outlierTest() {
		int insert = rand.nextInt(1000);
		for (int i = 0; i < insert; i++) {
			data.add(rand.nextInt(100));
		}
		data.add(Integer.MAX_VALUE - rand.nextInt(100));
		for (int i = insert; i < 1000; i++) {
			data.add(rand.nextInt(100));
		}
		test(data);
	}

	/**
	 * Test to make sure no data is missing and no new data has been added.
	 */
	@Test(timeout = 1000)
	public void exactTest() {
		int size = 1000 + rand.nextInt(1000);
		for (int i = 0; i < size; i++) {
			data.add(rand.nextInt(size));
		}
		CustomList<Integer> copy = algorithm.sort(data.copy());
		for (Integer i : data) {
			assertTrue("Data is missing: " + i, copy.remove(i));
		}
		assertTrue("Data has been added: " + copy.poll(), copy.isEmpty());
	}

	/**
	 * Test with a large data set.
	 */
	@Test(timeout = 5000)
	public void bigTest() {
		for (int i = 0; i < 5000; i++) {
			data.add(rand.nextInt());
		}
		test(data);
	}

	/**
	 * Test with an even larger data set.
	 */
	@Test(timeout = 25000)
	public void biggerTest() {
		for (int i = 0; i < 25000; i++) {
			data.add(rand.nextInt());
		}
		test(data);
	}

}
