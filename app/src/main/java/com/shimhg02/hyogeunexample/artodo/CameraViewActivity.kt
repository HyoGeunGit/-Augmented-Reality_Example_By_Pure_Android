package com.shimhg02.hyogeunexample.artodo
import android.app.Activity
import android.content.pm.ActivityInfo
import android.graphics.PixelFormat
import android.hardware.Camera
import android.location.Location
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.util.ArrayList
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

/**
 * Created by Shimhg02.
 */
class CameraViewActivity:Activity(), SurfaceHolder.Callback, OnLocationChangedListener, OnAzimuthChangedListener {
	private val mCamera:Camera
	private val mSurfaceHolder:SurfaceHolder
	private val isCameraviewOn = false
	private val mPoi:AugmentedPOI
	private val mAzimuthReal = 0.0
	private val mAzimuthTeoretical = 0.0
	private val mMyLatitude = 0.0
	private val mMyLongitude = 0.0
	private val myCurrentAzimuth:MyCurrentAzimuth
	private val myCurrentLocation:MyCurrentLocation
	internal var descriptionTextView:TextView
	internal var pointerIcon:ImageView
	fun onCreate(savedInstanceState:Bundle) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_camera_view)
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
		setupListeners()
		setupLayout()
		setAugmentedRealityPoint()
	}
	private fun setAugmentedRealityPoint() {
		val list = listOf("onNext", "onErrror", "onComplete")
		list.toObservable() // extension function for Iterables
				.filter { it.length >= 5 }
				.subscribeBy(  // named arguments for lambda SubscribermPoi = AugmentedPOI(
						"좌표계",
						"좌표계 생성자",
						50.06169631, 19.93919566
				)

	}
	fun calculateTeoreticalAzimuth():Double {
		val dX = mPoi.getPoiLatitude() - mMyLatitude
		val dY = mPoi.getPoiLongitude() - mMyLongitude
		val phiAngle:Double
		val tanPhi:Double
		val azimuth = 0.0
		tanPhi = Math.abs(dY / dX)
		phiAngle = Math.atan(tanPhi)
		phiAngle = Math.toDegrees(phiAngle)
		if (dX > 0 && dY > 0)
		{ // I quater
			return azimuth = phiAngle
		}
		else if (dX < 0 && dY > 0)
		{ // II
			return azimuth = 180 - phiAngle
		}
		else if (dX < 0 && dY < 0)
		{ // III
			return azimuth = 180 + phiAngle
		}
		else if (dX > 0 && dY < 0)
		{ // IV
			return azimuth = 360 - phiAngle
		}
		return phiAngle
	}
	private fun calculateAzimuthAccuracy(azimuth:Double):List<Double> {
		val minAngle = azimuth - AZIMUTH_ACCURACY
		val maxAngle = azimuth + AZIMUTH_ACCURACY
		val minMax = ArrayList<Double>()
		if (minAngle < 0)
			minAngle += 360.0
		if (maxAngle >= 360)
			maxAngle -= 360.0
		minMax.clear()
		minMax.add(minAngle)
		minMax.add(maxAngle)
		return minMax
	}
	private fun isBetween(minAngle:Double, maxAngle:Double, azimuth:Double):Boolean {
		if (minAngle > maxAngle)
		{
			if (isBetween(0.0, maxAngle, azimuth) && isBetween(minAngle, 360.0, azimuth))
				return true
		}
		else
		{
			if (azimuth > minAngle && azimuth < maxAngle)
				return true
		}
		return false
	}
	private fun updateDescription() {
		descriptionTextView.setText((mPoi.getPoiName() + " 좌표계 "
				+ mAzimuthTeoretical + " 카메라값 " + mAzimuthReal + " lat좌표 "
				+ mMyLatitude + " long좌표 " + mMyLongitude))
	}
	fun onLocationChanged(location:Location) {
		mMyLatitude = location.getLatitude()
		mMyLongitude = location.getLongitude()
		mAzimuthTeoretical = calculateTeoreticalAzimuth()
		Toast.makeText(this, "lat: " + location.getLatitude() + " lng: " + location.getLongitude(), Toast.LENGTH_SHORT).show()
		updateDescription()
	}
	fun onAzimuthChanged(azimuthChangedFrom: Int, azimuthChangedTo: Int) {
		mAzimuthReal = azimuthChangedTo.toDouble()
		mAzimuthTeoretical = calculateTeoreticalAzimuth()
		pointerIcon = findViewById(R.id.icon) as ImageView
		val minAngle = calculateAzimuthAccuracy(mAzimuthTeoretical).get(0)
		val maxAngle = calculateAzimuthAccuracy(mAzimuthTeoretical).get(1)
		if (isBetween(minAngle, maxAngle, mAzimuthReal))
		{
			pointerIcon.setVisibility(View.VISIBLE)
		}
		else
		{
			pointerIcon.setVisibility(View.INVISIBLE)
		}
		updateDescription()
	}
	protected fun onStop() {
		myCurrentAzimuth.stop()
		myCurrentLocation.stop()
		super.onStop()
	}
	protected fun onResume() {
		super.onResume()
		myCurrentAzimuth.start()
		myCurrentLocation.start()
	}
	private fun setupListeners() {
		myCurrentLocation = MyCurrentLocation(this)
		myCurrentLocation.buildGoogleApiClient(this)
		myCurrentLocation.start()
		myCurrentAzimuth = MyCurrentAzimuth(this, this)
		myCurrentAzimuth.start()
	}
	private fun setupLayout() {
		descriptionTextView = findViewById(R.id.cameraTextView) as TextView
		getWindow().setFormat(PixelFormat.UNKNOWN)
		val surfaceView = findViewById(R.id.cameraview) as SurfaceView
		mSurfaceHolder = surfaceView.getHolder()
		mSurfaceHolder.addCallback(this)
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
	}
	fun surfaceChanged(holder:SurfaceHolder, format:Int, width:Int,
					   height:Int) {
		if (isCameraviewOn)
		{
			mCamera.stopPreview()
			isCameraviewOn = false
		}
		if (mCamera != null)
		{
			try
			{
				mCamera.setPreviewDisplay(mSurfaceHolder)
				mCamera.startPreview()
				isCameraviewOn = true
			}
			catch (e:IOException) {
				e.printStackTrace()
			}
		}
	}
	fun surfaceCreated(holder:SurfaceHolder) {
		mCamera = Camera.open()
		mCamera.setDisplayOrientation(90)
	}
	fun surfaceDestroyed(holder:SurfaceHolder) {
		mCamera.stopPreview()
		mCamera.release()
		mCamera = null
		isCameraviewOn = false
	}
	companion object {
		private val AZIMUTH_ACCURACY = 5.0
	}
}