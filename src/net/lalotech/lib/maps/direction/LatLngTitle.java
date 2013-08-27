package net.lalotech.lib.maps.direction;

import com.google.android.gms.maps.model.LatLng;

public class LatLngTitle {
	private LatLng latlng;
	private String title;
	public LatLngTitle(LatLng latlng,String title) {
		this.latlng = latlng;
		this.title = title;
	}
	
	public LatLng getLatlng() {
		return latlng;
	}
	public void setLatlng(LatLng latlng) {
		this.latlng = latlng;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
