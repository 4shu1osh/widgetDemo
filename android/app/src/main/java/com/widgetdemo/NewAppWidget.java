package com.widgetdemo;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    private static JSONObject newObj;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
 
 try {
  SharedPreferences sharedPref = context.getSharedPreferences("DATA", Context.MODE_PRIVATE);
  String appString = sharedPref.getString("appData", "{\"text\":'no data'}");
  JSONObject appData = new JSONObject(appString);
  newObj = appData;
  // Construct the RemoteViews object
     Log.e("heloooo", appData.getString("text"));



  RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
  views.setTextViewText(R.id.appwidget_text, appData.getString("text"));

  // Instruct the widget manager to update the widget
  appWidgetManager.updateAppWidget(appWidgetId, views);
 }catch (JSONException e) {
  e.printStackTrace();
 }
}

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Log.e("update" , "update: ");
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
//        Log.e("on enable", newObj.toString());
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
        Log.e("hello" , "onDisabled: ");
//        Log.e("ondisable", newObj.toString());
    }
}