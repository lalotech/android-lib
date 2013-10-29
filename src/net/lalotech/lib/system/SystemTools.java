package net.lalotech.lib.system;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Patterns;

/**
 * Clase que sirve de interface entre el API del sistema y acceso a datos y/o
 * informacion importante del sistema.
 * 
 * @author lalotech
 *
 */
public class SystemTools {
	static TelephonyManager mTelephonyMgr = null;
	static Context ctx = null;
	/**
	 * Este metodo se debe de usar en el inicio del systema, donde de extiende de 
	 * Application para obtener el contexto global de la applicacion y ser usado
	 * en todo los metodos.
	 * 
	 * @param ctx
	 */
	public static void initApplication(Context c) {
		ctx = c;
	}
	/**
	 * Metodo que obtiene el numero celular de la linea principal.
	 * @return
	 */
	public static String getPhoneNumber() {		
		return getInstance().getLine1Number();
	}
	/**
	 * Regresa el IMEI en GSM o el MEID/ESN en CDMA
	 * 
	 * @return
	 */
	public static String getIMEIorMEIDorESN(){
		return getInstance().getDeviceId();
	}
	/**
	 * Software version
	 * 
	 * @return
	 */
	public static String getDeviceSoftwareVersion(){
		return getInstance().getDeviceSoftwareVersion();
	}
	/**
	 * Network Operator
	 * 
	 * @return
	 */	
	public static String getNetworkOperatorName(){
		return getInstance().getNetworkOperatorName();
	}	
	/**
	 * Model device.
	 * 
	 * @return
	 */
	public static String getModel(){
		return android.os.Build.MODEL;
	}
	/**
	 * Software version.
	 * @return
	 */
	public static String getOSversion(){
		return android.os.Build.VERSION.RELEASE;
	}
	/**
	 * Manufacturer
	 * 
	 * @return
	 */
	public static String getManufacturer(){
		return android.os.Build.MANUFACTURER;	
	}
	/**
	 * Lista de las cuentas en el sistema 
	 * @return
	 */
	public static List<String> getAccounts(){
		Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
		List<String> l = new ArrayList<String>();
		Account[] accounts = AccountManager.get(ctx).getAccounts();
		for (Account account : accounts) {
		    if (emailPattern.matcher(account.name).matches()) {
		       l.add(account.name);		        
		    }
		}
		return l;
	}
	private static TelephonyManager getInstance(){
		if(ctx == null){
			throw new RuntimeException("Context null for SystemTools.");
		}
		if(mTelephonyMgr == null){
			mTelephonyMgr = (TelephonyManager) ctx
					.getSystemService(Context.TELEPHONY_SERVICE);
			return mTelephonyMgr;
		}else{
			return mTelephonyMgr;
		}
	}
}
