package net.lalotech.lib.maps;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import net.lalotech.lib.R;
import net.lalotech.lib.maps.direction.LatLngTitle;
import net.lalotech.lib.maps.direction.Point;
import net.lalotech.lib.maps.direction.Step;
import net.lalotech.lib.maps.direction.model.Place;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.text.Html;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapService {

	public static final String MODE_TRANSIT = "transit";
	public static final String MODE_CAR = "driving";
	public static final String MODE_WALKING = "walking";
	public static final String MODE_BICYCLING = "bicycling";

	/*
	 * public static Direction getDireccion(String json)throws Exception{
	 * if(json == null) return null;
	 * 
	 * return new Gson().fromJson(json, Direction.class); }
	 */
	public static void showGPSSettingsDialog(final Context mContext) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

		// Setting Dialog Title
		alertDialog.setTitle(mContext.getString(R.string.maps_nogps_message));

		// Setting Dialog Message
		alertDialog.setMessage(mContext.getString(R.string.maps_nogps_message));

		// On pressing Settings button
		alertDialog.setPositiveButton(
				mContext.getString(R.string.maps_nogps_ok),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(
								Settings.ACTION_LOCATION_SOURCE_SETTINGS);
						mContext.startActivity(intent);
					}
				});

		// on pressing cancel button
		alertDialog.setNegativeButton(
				mContext.getString(R.string.maps_nogps_cancel),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		// Showing Alert Message
		alertDialog.show();
	}

	public static boolean isGPSEnable(Context context) {
		LocationManager m = (LocationManager) context
				.getSystemService(android.content.Context.LOCATION_SERVICE);
		return m.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	public static boolean isNetworkEnable(Context context) {
		LocationManager m = (LocationManager) context
				.getSystemService(android.content.Context.LOCATION_SERVICE);
		return m.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	}

	public static double CalculationByDistance(LatLng startP, LatLng endP) {
		int Radius = 6371;// radius of earth in Km
		double lat1 = startP.latitude;
		double lat2 = endP.latitude;
		double lon1 = startP.longitude;
		double lon2 = endP.longitude;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double valueResult = Radius * c;
		double km = valueResult / 1;
		DecimalFormat newFormat = new DecimalFormat("####");
		Integer kmInDec = Integer.valueOf(newFormat.format(km));
		// double meter = valueResult%1000;
		// Integer meterInDec = Integer.valueOf(newFormat.format(meter));
		// Util.log("Radius Value "+valueResult+"   KM  "+kmInDec+" Meter   "+meter*1000);
		// return Radius * c;
		return kmInDec * 1000;
	}

	public static List<LatLng> getListLatLngByStepList(List<Step> s) {
		List<LatLng> l = new ArrayList<LatLng>();
		for (Step t : s) {
			l.add(getLatLngByStep(t));
		}
		return l;
	}

	public static List<LatLngTitle> getListLatLngByStep(List<Step> s) {
		List<LatLngTitle> l = new ArrayList<LatLngTitle>();
		for (Step t : s) {
			l.add(new LatLngTitle(new LatLng(t.getStart_location().getLat(), t
					.getStart_location().getLng()), t.getHtml_instructions()));
			l.add(new LatLngTitle(new LatLng(t.getEnd_location().getLat(), t
					.getEnd_location().getLng()), t.getHtml_instructions()));
		}
		return l;
	}

	public static LatLng getLatLngByStep(Step s) {
		return new LatLng(s.getStart_location().getLat(), s.getStart_location()
				.getLng());
	}

	public static LatLng getLatLngByLocation(Location l) throws Exception {
		return new LatLng(l.getLatitude(), l.getLongitude());
	}

	public static LatLng getLatLngByPlace(Place p) throws Exception {
		// Util.log("coords: " + p.getCoordinates());
		// Double lng = Double.parseDouble(p.getCoordinates().split(",")[0]);
		// Double lat = Double.parseDouble(p.getCoordinates().split(",")[1]);
		Double lng = p.getLatitude();
		Double lat = p.getLongitude();
		return new LatLng(lat, lng);
	}

	public static LatLng getLatLngByPoint(Point p) {
		return new LatLng(p.getLat(), p.getLng());
	}

	public static List<MarkerOptions> getMarkers(List<LatLngTitle> ln,
			String startLocationName, String endLocationName) {
		List<MarkerOptions> mo = new ArrayList<MarkerOptions>();
		for (int i = 0; i < ln.size(); i++) {
			// para el primero
			if (i == 0) {
				mo.add(new MarkerOptions().position(ln.get(i).getLatlng())
						.title(startLocationName));
			} else if ((i + 1) == ln.size()) {
				// ultimo
				mo.add(new MarkerOptions().position(ln.get(i).getLatlng())
						.title(endLocationName));
			} else {
				// para todos los intermedios
				mo.add(new MarkerOptions()
						.position(ln.get(i).getLatlng())
						.title(Html.fromHtml(ln.get(i).getTitle()).toString())
						.icon(BitmapDescriptorFactory
								.fromAsset("icons/dot16.png")));
			}
		}
		return mo;
	}
	// cambiar a objeto estacion
	/*
	 * public static List<MarkerOptions> getMarkersByPlaces(List<Place>
	 * places)throws Exception{ List<MarkerOptions> mo = new
	 * ArrayList<MarkerOptions>(); for(Place p:places){ mo.add(new
	 * MarkerOptions() .position(getLatLngByPlace(p)) .snippet(""+p.getId())
	 * .title(Html.fromHtml(p.getName()).toString())); } return mo; }
	 */

}