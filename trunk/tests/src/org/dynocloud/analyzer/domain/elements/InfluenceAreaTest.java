package org.dynocloud.analyzer.domain.elements;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfluenceAreaTest {

	@Test(expected=IllegalArgumentException.class)
	public void testActivityCantBePlaced() {
		InfluenceArea influenceArea = new InfluenceArea();
		Nester.addChildNode(influenceArea, new Activity());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testActivityGroupCantBePlaced() {
		InfluenceArea influenceArea = new InfluenceArea();
		Nester.addChildNode(influenceArea, new ActivityGroup());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParentCantBeInfluenceArea() {
		InfluenceArea influenceArea = new InfluenceArea();
		Nester.addChildArea(new InfluenceArea(), influenceArea);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParentCantBeControlArea() {
		InfluenceArea influenceArea = new InfluenceArea();
		Nester.addChildArea(new ControlArea(), influenceArea);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testParentCantBeDivision() {
		InfluenceArea influenceArea = new InfluenceArea();
		Nester.addChildArea(new Division(), influenceArea);
	}
	
	@Test()
	public void testParentCanBeNoiseArea() {
		InfluenceArea influenceArea = new InfluenceArea();
		Nester.addChildArea(new NoiseArea(), influenceArea);
		assertTrue(influenceArea.getParent() instanceof NoiseArea);
	}
	
	@Test
	public void testGatewayCanBeChild(){
		InfluenceArea area = new InfluenceArea();
		Nester.addChildNode(area, new Gateway());
	}
	
	@Test
	public void testParticipantCanBeChild(){
		InfluenceArea area = new InfluenceArea();
		Nester.addChildNode(area, new Participant());
	}
	
	

}
