package net.lalotech.lib.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class TimeOutAndroid extends Thread {

	private Handler handler;
	private int time;
	private boolean notify = true;

	public TimeOutAndroid(Handler handler, int time_seg) {
		this.handler = handler;
		this.time = time_seg;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		super.run();
		try {
			// esperamos un tiempo
			this.sleep(time * 1000);
			if (notify) {
				Message messageToParent = new Message();
				Bundle messageData = new Bundle();
				messageToParent.what = 0;
				messageToParent.setData(messageData);
				handler.sendMessage(messageToParent);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	/**
	 * para desactivar la notificacion del timeout en logica
	 * @param notify
	 */
	public void setNotify(boolean notify) {
		this.notify = notify;
	}
}
