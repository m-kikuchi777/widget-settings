package com.mkikuchi.widgetsettings

import android.content.Context
import android.net.wifi.WifiManager

class NetworkInfoUtil {
    companion object {
        fun getWifiIpAddress(context: Context): String {
            val manager =
                context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val info = manager.connectionInfo
            val ipAddr = info.ipAddress
            return String.format(
                "%d.%d.%d.%d",
                ipAddr shr 0 and 0xff,
                ipAddr shr 8 and 0xff,
                ipAddr shr 16 and 0xff,
                ipAddr shr 24 and 0xff
            )
        }
    }
}