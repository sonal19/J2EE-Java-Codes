package gov.nyc.dohmh.mosquitotrap.dto;

import java.io.Serializable;

/**
 * The Class MosquitoTypeDTO.
 */
public class MosquitoTypeDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The device id. */
	private int deviceId;
	
	/** The interval begin time. */
	private long intervalBeginTime;
	
	/** The interval end time. */
	private long intervalEndTime;
	
	/** The type. */
	private String type;
	
	/** The detection time. */
	private long detectionTime;
	
	/** The sequence num. */
	private int sequenceNum;
	
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the detection time.
	 *
	 * @return the detection time
	 */
	public long getDetectionTime() {
		return detectionTime;
	}
	
	/**
	 * Sets the detection time.
	 *
	 * @param detectionTime the new detection time
	 */
	public void setDetectionTime(long detectionTime) {
		this.detectionTime = detectionTime;
	}
	
	/**
	 * Gets the sequence num.
	 *
	 * @return the sequence num
	 */
	public int getSequenceNum() {
		return sequenceNum;
	}
	
	/**
	 * Sets the sequence num.
	 *
	 * @param sequenceNum the new sequence num
	 */
	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
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
