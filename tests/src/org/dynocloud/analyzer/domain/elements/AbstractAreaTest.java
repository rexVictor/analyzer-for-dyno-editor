package org.dynocloud.analyzer.domain.elements;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractAreaTest {

	@Test
	public void testClone() {
		AbstractArea area = new AbstractArea() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -8465558947173763919L;
		};
		AbstractArea clone = area.clone();
		System.out.println(clone);
		fail();
	}

}
