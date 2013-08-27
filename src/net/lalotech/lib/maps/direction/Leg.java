package net.lalotech.lib.maps.direction;

import java.util.List;
/**
 * 
 * @author lalotech
 *
 */
public class Leg {
	private Label distance;
	private Label duration;
	private String start_address;
	private String end_address;
	private Point start_location;
	private Point end_location;
	private List<Step> steps;
	
	//TODO: faltan via_points se desconoce el modelo.
	
	public Label getDistance() {
		return distance;
	}
	public void setDistance(Label distance) {
		this.distance = distance;
	}
	public Label getDuration() {
		return duration;
	}
	public void setDuration(Label duration) {
		this.duration = duration;
	}
	public String getStart_address() {
		return start_address;
	}
	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}
	public String getEnd_address() {
		return end_address;
	}
	public void setEnd_address(String end_address) {
		this.end_address = end_address;
	}
	public Point getStart_location() {
		return start_location;
	}
	public void setStart_location(Point start_location) {
		this.start_location = start_location;
	}
	public Point getEnd_location() {
		return end_location;
	}
	public void setEnd_location(Point end_location) {
		this.end_location = end_location;
	}
	public List<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}	
	
}
