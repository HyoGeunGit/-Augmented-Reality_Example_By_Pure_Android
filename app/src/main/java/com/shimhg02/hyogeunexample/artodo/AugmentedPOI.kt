package com.shimhg02.hyogeunexample.artodo
/**
 * Created by Shimhg02.
 */
class AugmentedPOI(newName:String, newDescription:String,
				   newLatitude:Double, newLongitude:Double) {
	var poiId:Int = 0
	var poiName:String
	var poiDescription:String
	var poiLatitude:Double = 0.toDouble()
	var poiLongitude:Double = 0.toDouble()
	init{
		this.poiName = newName
		this.poiDescription = newDescription
		this.poiLatitude = newLatitude
		this.poiLongitude = newLongitude
	}
}