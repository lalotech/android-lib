package net.lalotech.lib.util;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class Util {
	
	public static void log(String msj){
		Log.d("Library",""+msj);
	}	
	public static List<String> distinct(List<String> src){
		List<String> res = new ArrayList<String>();
		for (String s : src) {
			if(!res.contains(s))
				res.add(s);
		}
		return res;
	}
}
