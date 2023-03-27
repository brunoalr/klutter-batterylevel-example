package com.example.batterylevel.platform

import dev.buijs.klutter.annotations.AndroidContext
import dev.buijs.klutter.annotations.KlutterAdaptee

class Platform {

    @AndroidContext
    @KlutterAdaptee(name = "getBatteryLevel")
    fun getBatteryLevel(context: Any): Double? {
        return BatteryLevel(context).level?.toDouble()
    }

}
