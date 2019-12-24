/**
 * 
 */
package Check;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wuzhuoying
 *
 */
public class SortScoreTest {
	SortScore s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new SortScore("test/ScoreTest.txt");
	}

	/**
	 * Test method for {@link Check.SortScore#sortArray()}.
	 * @throws IOException 
	 */
	@Test
	public void testSortArray() throws IOException {
		int[] test_array = s.sortArray();
		int [] except = {88,79,34,26,24};
		assertArrayEquals(except, test_array);
	}

	/**
	 * Test method for {@link Check.SortScore#getSize()}.
	 */
	@Test
	public void testGetSize() {
		int test_size = s.getSize();
		assertEquals(5, test_size);
	}

}
