package org.dynocloud.analyzer.domain.elements;

import static org.junit.Assert.*;

import org.junit.Test;

public class RootElementTest {

	@Test
	public void testClone() {
		RootElement element = new RootElement() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 7959718234679666827L;				
			
		};
		element.setId("Test-ID");
		element.setName("Test-Name");
		element.setResourceId("Test-ResourceId");
		RootElement clone = element.clone();
		assertEquals("Test-ID", clone.getId());
		assertEquals("Test-Name", clone.getName());
		assertEquals("Test-ResourceId", clone.getResourceId());
	}
	
	@Test
	public void testCloneIsReal() {
		RootElement element = new RootElement() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 7959718234679666827L;				
			
		};
		element.setId("ID");
		element.setName("Name");
		element.setResourceId("ResourceId");
		RootElement clone = element.clone();
		assertFalse(clone == element);
		element.setId("NewID");
		element.setName("NewName");
		element.setResourceId("newResourceId");
		assertFalse(element.getId().equals(clone.getId()));
		assertFalse(element.getName().equals(clone.getName()));
		assertFalse(element.getResourceId().equals(clone.getResourceId()));
	}

}
