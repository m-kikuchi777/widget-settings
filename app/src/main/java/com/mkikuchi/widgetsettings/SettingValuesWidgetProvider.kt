package com.mkikuchi.widgetsettings

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class SettingValuesWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        context ?: return

        appWidgetIds?.forEach { appWidgetId ->
            val address = NetworkInfoUtil.getWifiIpAddress(context)
            val views = getRemoteViews(context) ?: return
            views.setTextViewText(R.id.widget_ip_address, address)
            // WidgetのViewの更新
            appWidgetManager?.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)

        getRemoteViews(context)
    }

    private fun getRemoteViews(context: Context?): RemoteViews? {
        context ?: return null
        return RemoteViews(
            context.applicationContext.packageName,
            R.layout.layout_setting_values_widget
        )
    }
}