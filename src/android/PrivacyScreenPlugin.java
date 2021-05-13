/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 * private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		enable(this.cordova.getActivity());
	}

	@Override
	public boolean execute(String action, JSONArray data, final CallbackContext callbackContext) throws JSONException {
		final Activity activity = this.cordova.getActivity();

		if (action.equals("enable")) {
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					enable(activity);
					callbackContext.success();
				}
			});

			return true;
		}
		
		if (action.equals("disable")) {
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					disable(activity);
					callbackContext.success();
				}
			});

			return true;
		}


		return false;
	}
	
	
	private void enable(Activity activity) {
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
	}
	
	private void disable(Activity activity) {
		activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
	}

}
