package net.lalotech.lib.maps.direction;

import java.util.List;
/**
 * 
 * @author lalotech
 *
 */
public class Route {
	
	private Bound bounds;
	private String copyrights;
	private List<Leg> legs;
	private String summary;
	
	//TODO: falta warnings y waypoint_order
	
	public Bound getBounds() {
		return bounds;
	}
	public void setBounds(Bound bounds) {
		this.bounds = bounds;
	}
	public String getCopyrights() {
		return copyrights;
	}
	public void setCopyrights(String copyrights) {
		this.copyrights = copyrights;
	}
	public List<Leg> getLegs() {
		return legs;
	}
	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
