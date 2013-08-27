package net.lalotech.lib.maps.direction;

import java.util.List;
/**
 * 
 * @author lalotech
 *
 */
public class Direction {	
	
	public static final String STATUS_OK = "OK"; 
	public static final String STATUS_NOT_FOUND = "NOT_FOUND";
	public static final String STATUS_ZERO_RESULTS = "ZERO_RESULTS";
	public static final String STATUS_MAX_WAYPOINTS_EXCEEDED = "MAX_WAYPOINTS_EXCEEDED"; //son 8 los maximos para business son 23 
	public static final String STATUS_INVALID_REQUEST = "INVALID_REQUEST";
	public static final String STATUS_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
	public static final String STATUS_REQUEST_DENIED = "REQUEST_DENIED";
	public static final String STATUS_UNKNOWN_ERROR = "UNKNOWN_ERROR";
	
	private String status;
	private List<Route> routes;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}	
}
