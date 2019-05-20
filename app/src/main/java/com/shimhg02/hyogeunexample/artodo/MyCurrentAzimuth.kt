package com.shimhg02.hyogeunexample.artodo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

/**
 * Created by Shimhg02.
 */
class MyCurrentAzimuth(private var mAzimuthListener: OnAzimuthChangedListener?, internal var mContext: Context) : SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null
    private var azimuthFrom = 0
    private var azimuthTo = 0

    fun start() {
        sensorManager = mContext.getSystemService(mContext.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        sensorManager!!.registerListener(this, sensor,
                SensorManager.SENSOR_DELAY_UI)
    }

    fun stop() {
        sensorManager!!.unregisterListener(this)
    }

    fun setOnShakeListener(listener: OnAzimuthChangedListener) {
        mAzimuthListener = listener
    }

    override fun onSensorChanged(event: SensorEvent) {
        azimuthFrom = azimuthTo

        val orientation = FloatArray(3)
        val rMat = FloatArray(9)
        SensorManager.getRotationMatrixFromVector(rMat, event.values)
        azimuthTo = (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0].toDouble()) + 360).toInt() % 360

        mAzimuthListener!!.onAzimuthChanged(azimuthFrom, azimuthTo)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

    }
}