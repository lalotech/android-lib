package net.lalotech.lib.maps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import net.lalotech.lib.util.Util;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.os.AsyncTask;

public class JsonTask extends AsyncTask<String, Void, String> {

	String result = null;
	HttpCompleteHandler r;
	String linea;

	public JsonTask(HttpCompleteHandler response) {
		this.r = response;
	}

	@Override
	protected String doInBackground(String... params) {
		Util.log("doBackground call json task");
		result = "EXCEPTION";		
		HttpClient client = new DefaultHttpClient();
		HttpParams httpParameters = new BasicHttpParams();
		// Set the timeout in milliseconds until a connection is established.
		// The default value is zero, that means the timeout is not used.
		int timeoutConnection = 3000;
		HttpConnectionParams.setConnectionTimeout(httpParameters,
				timeoutConnection);
		// Set the default socket timeout (SO_TIMEOUT)
		// in milliseconds which is the timeout for waiting for data.
		int timeoutSocket = 5000;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		HttpGet get = new HttpGet(params[0]);
		try {
			HttpResponse response = client.execute(get);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				result = ""; //flush
				Util.log("HTTP OK!!");
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				while ((linea = rd.readLine()) != null) {
					result += linea;
				}
			}
		} catch (Exception e) {
			Util.log("Error http: " + e.getMessage());
			//e.printStackTrace();
		}
		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		Util.log("onPostExecute call json task");
		// callback response
		r.onHttpFinish(result);
	}
}
