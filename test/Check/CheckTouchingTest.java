/**
 * 
 */
package Check;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.shape.Rectangle;

/**
 * @author wuzhuoying
 *
 */
public class CheckTouchingTest {
	Rectangle r1;
	Rectangle r2;
	CheckTouching c;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		r1 = new Rectangle(10, 20, 40, 60);
		r2 = new Rectangle(35, 70, 20, 20);
		c = new CheckTouching(r1, r2);
	}

	/**
	 * Test method for {@link Check.CheckTouching#isTouching()}.
	 */
	@Test
	public void testIsTouching() {
		boolean test_touching = c.isTouching();
		assertEquals(true, test_touching);
	}

	/**
	 * Test method for {@link Check.CheckTouching#checkPoint(double, double)}.
	 */
	@Test
	public void testCheckPoint() {
		for(int i = 0; i < 60; i++) {
			for(int j = 15; j < 85; j++) {
				boolean actual = c.checkPoint(i, j);
				if(i >= 10 && i <= 50) {
					if(j >= 20 && j <= 80) {
						assertEquals(true, actual);
						break;
					}
				}
				assertEquals(false, actual);
			}
		}
	}

}
