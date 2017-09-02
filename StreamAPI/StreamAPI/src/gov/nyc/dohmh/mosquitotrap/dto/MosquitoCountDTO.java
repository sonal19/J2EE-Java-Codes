package gov.nyc.dohmh.mosquitotrap.dto;

import java.io.Serializable;

/**
 * The Class MosquitoCountDTO.
 */
public class MosquitoCountDTO implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The device id. */
	private int deviceId;
	
	/** The interval begin time. */
	private long intervalBeginTime;
	
	/** The interval end time. */
	private long intervalEndTime;
	
	/** The num mosquitoes. */
	private int numMosquitoes;
	
	/** The temp. */
	private double temp;
	
	/** The humidity. */
	private double humidity;
	
	/** The light. */
	private double light;
	
	/**
	 * Gets the device id.
	 *
	 * @return the device id
	 */
	public int getDeviceId() {
		return deviceId;
	}
	
	/**
	 * Sets the device id.
	 *
	 * @param deviceId the new device id
	 */
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * Gets the interval begin time.
	 *
	 * @return the interval begin time
	 */
	public long getIntervalBeginTime() {
		return intervalBeginTime;
	}
	
	/**
	 * Sets the interval begin time.
	 *
	 * @param intervalBeginTime the new interval begin time
	 */
	public void setIntervalBeginTime(long intervalBeginTime) {
		this.intervalBeginTime = intervalBeginTime;
	}
	
	/**
	 * Gets the interval end time.
	 *
	 * @return the interval end time
	 */
	public long getIntervalEndTime() {
		return intervalEndTime;
	}
	
	/**
	 * Sets the interval end time.
	 *
	 * @param intervalEndTime the new interval end time
	 */
	public void setIntervalEndTime(long intervalEndTime) {
		this.intervalEndTime = intervalEndTime;
	}
	
	/**
	 * Gets the num mosquitoes.
	 *
	 * @return the num mosquitoes
	 */
	public int getNumMosquitoes() {
		return numMosquitoes;
	}
	
	/**
	 * Sets the num mosquitoes.
	 *
	 * @param numMosquitoes the new num mosquitoes
	 */
	public void setNumMosquitoes(int numMosquitoes) {
		this.numMosquitoes = numMosquitoes;
	}
	
	/**
	 * Gets the temp.
	 *
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}
	
	/**
	 * Sets the temp.
	 *
	 * @param temp the new temp
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	/**
	 * Gets the humidity.
	 *
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}
	
	/**
	 * Sets the humidity.
	 *
	 * @param humidity the new humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	/**
	 * Gets the light.
	 *
	 * @return the light
	 */
	public double getLight() {
		return light;
	}
	
	/**
	 * Sets the light.
	 *
	 * @param light the new light
	 */
	public void setLight(double light) {
		this.light = light;
	}
	
	
}
