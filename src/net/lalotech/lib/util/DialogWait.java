package net.lalotech.lib.util;

import net.lalotech.lib.R;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;

public class DialogWait extends Dialog{

	public DialogWait(Context context) {
		super(context,android.R.style.Theme_Translucent);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_wait);
	}
	
}
