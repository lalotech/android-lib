package net.lalotech.lib.maps.direction;
/**
 * 
 * @author lalotech
 *
 */
public class Step {
	
	private Label distance;
	private Label dutation;
	private Point end_location;
	private Point start_location;
	private String travel_mode;
	private String html_instructions;
	public Label getDistance() {
		return distance;
	}
	public void setDistance(Label distance) {
		this.distance = distance;
	}
	public Label getDutation() {
		return dutation;
	}
	public void setDutation(Label dutation) {
		this.dutation = dutation;
	}
	public Point getEnd_location() {
		return end_location;
	}
	public void setEnd_location(Point end_location) {
		this.end_location = end_location;
	}
	public Point getStart_location() {
		return start_location;
	}
	public void setStart_location(Point start_location) {
		this.start_location = start_location;
	}
	public String getTravel_mode() {
		return travel_mode;
	}
	public void setTravel_mode(String travel_mode) {
		this.travel_mode = travel_mode;
	}
	public String getHtml_instructions() {
		return html_instructions;
	}
	public void setHtml_instructions(String html_instructions) {
		this.html_instructions = html_instructions;
	}
	
	
}
