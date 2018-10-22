/**
 * "Dark Triangles" demonstrates black box testing for educational purposes.
 * Copyright (C) 2010-2013 Daniel Speicher and University of Bonn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geometry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import geometry.basic.Point;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleTest {

	/*
	 * The following methods make sure that the test is run for all Triangle
	 * classes we are interested in. You don't need to understand the mechanics, 
	 * just make sure that you never create a triangle directly, but use one of 
	 * the methods createTriangle(...).
	 */
	private Class<Triangle> classUnderTest;

	@SuppressWarnings("unchecked")
	public TriangleTest(Object classUnderTest) {
		this.classUnderTest = (Class<Triangle>) classUnderTest;
	}

	@Parameters
	public static Collection<Object[]> triangleClassesUnderTest() {
		Object[][] classes = { 
				{ Triangle00.class },
				{ Triangle01.class },
				{ Triangle02.class },
				{ Triangle03.class }, 
				{ Triangle04.class },
				{ Triangle05.class },
				{ Triangle06.class },
				{ Triangle07.class },
				{ Triangle08.class },
				{ Triangle09.class },
				{ Triangle10.class },
				{ Triangle11.class },	
				{ Triangle12.class },
				{ Triangle13.class },
				{ Triangle14.class },
				{ Triangle15.class } ,
				{ Triangle16.class }
		};
		return Arrays.asList(classes);
	}

	private Triangle createTriangle(Point a, Point b, Point c) throws Exception {
		Constructor<Triangle> constructor = classUnderTest.getConstructor(
				Point.class, Point.class, Point.class);
		return constructor.newInstance(a, b, c);
	}

	private Triangle createTriangle(double ax, double ay, double bx, double by,
			double cx, double cy) throws Exception {
		Point a = new Point(ax, ay);
		Point b = new Point(bx, by);
		Point c = new Point(cx, cy);
		return createTriangle(a, b, c);
	}

	/*
	 * Create some triangles for the test.
	 * 
	 * Remember to always use createTriangle(...) to create a triangle. Never
	 * call the constructor directly. This allows us to run the test for all the
	 * classes one after another.
	 */
	private Triangle triangle;
	private Triangle equalToTriangle;
	private Triangle veryLargeTriangle;
	private Triangle verySmallTriangle;
	
	private Triangle sourceTriangle;
	private Triangle containedTriangle;
	private Triangle sourceTriangle9;
	private Triangle containedTriangle9;
	private Triangle sourceTriangle1;
	private Triangle containedTriangle1;
	private Triangle sourceTriangle2;
	private Triangle containedTriangle2;
	private Triangle sourceTriangle8;
	private Triangle containedTriangle8;
	private Triangle sourceTrianglex;
	private Triangle containedTriangley;
	private Triangle sourceTriangle036;
	private Triangle containedTriangle036;
	private Triangle sourceTriangle6;
	private Triangle containedTriangle6;
	private Triangle c_outer;
	private Triangle c_out;

	@Before
	public void setUpBefore() throws Exception {
		Point a = new Point(1, 7);
		Point b = new Point(7, 14);
		Point c = new Point(7, 2);
		
		Point x = new Point(14, 7);
		Point y = new Point(5, 8);
		Point z = new Point(5, 7);
		
		
		
		/* Coordinates of One Coordinate of smaller triangle lies outside the Larger triangle5*/
		Point a5 = new Point(1, 7);
		Point b5 = new Point(7, 14);
		Point c5 = new Point(7, 2);
		
		Point x5 = new Point(14, 7);
		Point y5 = new Point(5, 8);
		Point z5 = new Point(5, 7);
		

		triangle = createTriangle(a, b, c);
		equalToTriangle = createTriangle(c, b, a);
		veryLargeTriangle = createTriangle(-10000.0, -10000.0, +10000.0,
				-10000.0, 0.0, +20000.0);
		verySmallTriangle = createTriangle(-0.00001, -0.00001, +0.00001,
				-0.00001, 0.0, +0.00002);
		sourceTriangle = createTriangle(a,b,c);
		containedTriangle = createTriangle(x,y,z);
		sourceTrianglex = createTriangle(a5,b5,c5);
		containedTriangley = createTriangle(x5,y5,z5);
		
		
		/*  Coordinates where smaller triangle lies inside the Larger triangle8*/
	
		Point a8 = new Point(15, 15);
		Point b8 = new Point(23, 30);
		Point c8 = new Point(50, 25);
		
		Point x8 = new Point(20, 20);
		Point y8 = new Point(25, 25);
		Point z8 = new Point(35, 25);
		
		sourceTriangle8 = createTriangle(a8,b8,c8);
		containedTriangle8 = createTriangle(x8,y8,z8);
		
		/* Symmetric Case9*/
		Point a9 = new Point(25, 15);
		Point b9 = new Point(35, 15);
		Point c9 = new Point(5, 10);
		
		Point x9 = new Point(-25, -15);
		Point y9 = new Point(-35, -15);
		Point z9 = new Point(-5, -10);
		
		sourceTriangle9 = createTriangle(a9,b9,c9);
		containedTriangle9 = createTriangle(x9,y9,z9);
		
		/*One co-ordinate of smaller triangle is inside and second case is one point of the smaller triangle is outside and the rest of the two points are same as sourceTriangle*/
		Point a1 = new Point(15, 15);
		Point b1 = new Point(15,35);
		Point c1 = new Point(34,27);
		
		Point b12 = new Point(18,27);
		Point y12 = new Point(10, 40);
		
		sourceTriangle1 = createTriangle(a1,b1,c1);
		containedTriangle1 = createTriangle(a1,b12,c1);
		sourceTriangle2 = createTriangle(a1,b1,c1);
		containedTriangle2	= createTriangle(a1,y12,c1);				
		/*One co-ordinate of smaller triangle is inside and second case is one point of the smaller triangle is outside and the rest of the two points are same as sourceTriangle*/

		sourceTriangle036 = createTriangle(2,3,6,3,4,8);
		containedTriangle036 = createTriangle(7,10,11,10,9,15);
		
		
		sourceTriangle6 = createTriangle(10,30,50,30,30,10);
		containedTriangle6 = createTriangle(-10,50,70,50,30,10);	
		
		
		
		Point a0 = new Point(-1,-1);
		Point b0 = new Point(1, 2);
		Point c0 = new Point(1,-0.3);
		c_outer = createTriangle(a0, b0, c0);
        c_out = createTriangle(0,0, 0,1, 1,0);
	}
	
	/*Case 0*/
	
	@Test
	public void partialouterCheking() throws Exception{
		assertFalse("...  outside", c_outer.contains(c_out));
	}
	/* One Coordinate of smaller triangle lies outside the Larger triangle5*/
	@Test
	public void ifOneCordinateOfSmallTriangleOutsideBiggerTriangle() throws Exception {
		assertFalse("... source triangle will not contain containedTriangle if one cordinate of containedTriangle lies outside.",
				sourceTrianglex.contains(containedTriangley));
	}
	
	/*  Coordinates where smaller triangle lies inside the Larger triangle8*/
	@Test
	public void smalltriangleWithinSourcetriangle() throws Exception {
		assertTrue("... The main triangle contains the other triangle.", sourceTriangle8.contains(containedTriangle8));
	}
	
	/* Symmetric Case9*/
	@Test
	public void isReflectionSymmetricTriangle() throws Exception {
		assertFalse("... they should not contain each other", sourceTriangle9.contains(containedTriangle9));
	}
	/*Two points same as SourceTriangle and one point lying inside the sourceTriangle and for second one ,one point lies outside the sourceTriangle Case1*/
	@Test
	public void sourceTriangleOnePointInside() throws Exception {
	assertTrue("... ", sourceTriangle1.contains(containedTriangle1));
	assertFalse("... partially outside", sourceTriangle2.contains(containedTriangle2));	
	}
	
	/**/
	@Test
	public void triangleOutside() throws Exception {
	assertFalse("... triangle outside eachother", sourceTriangle036.contains(containedTriangle036));	
	}
	@Test
	public void twoPointsOutsideOutside() throws Exception {
	assertFalse("... triangle two points outside other", sourceTriangle6.contains(containedTriangle6));	
	}
	
	@Test
	public void ifATriangleIsComparedWithItself() throws Exception {
		assertTrue("... it should contain itself.", triangle.contains(triangle));
	}
	
	

	@Test
	public void ifTrianglesAreEqualToEachOther() throws Exception {
		assertTrue("... they should contain each other.",
				triangle.contains(equalToTriangle));
		assertTrue("The triangles should actually be equal.",
				triangle.equals(equalToTriangle));
		assertFalse("But not the same.", triangle == equalToTriangle);
	}
	
	

	@Test
	public void ifATriangleIsJustACornerOfAnotherTriangle() throws Exception {
		Point x = new Point(Math.E, Math.E); // Some strange values for this
											 // simple case.
		Point y = new Point(Math.PI, Math.E);
		Point z = new Point(Math.PI, Math.PI);
		Triangle fullTriangle = createTriangle(x, y, z);
		Triangle pointX = createTriangle(x, x, x);
		Triangle pointY = createTriangle(y, y, y);
		Triangle pointZ = createTriangle(z, z, z);
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointX));
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointY));
		assertTrue("... it is part of the triangle",
				fullTriangle.contains(pointZ));
	}

	@Test @Ignore 
	public void ifOneTriangleIsVeryLargeAndTheOtherVerySmall() throws Exception {
		assertTrue("... the large one should contain the small one.",
				veryLargeTriangle.contains(verySmallTriangle));
		assertFalse("... the small one should not contain the large one.",
				verySmallTriangle.contains(veryLargeTriangle));
	}
	
}
