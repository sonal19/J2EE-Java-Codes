package gov.nyc.dohmh.mosquitotrap.dto;

import java.io.Serializable;

/**
 * The Class DevicesDTO.
 */
public class DevicesDTO implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The device id. */
	private int deviceId;
	
	/** The registration time. */
	private long registrationTime;
	
	/** The gps longitude. */
	private double gpsLongitude;
	
	/** The gps lattitude. */
	private double gpsLattitude;
	
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
	 * Gets the registration time.
	 *
	 * @return the registration time
	 */
	public long getRegistrationTime() {
		return registrationTime;
	}
	
	/**
	 * Sets the registration time.
	 *
	 * @param registrationTime the new registration time
	 */
	public void setRegistrationTime(long registrationTime) {
		this.registrationTime = registrationTime;
	}
	
	/**
	 * Gets the gps longitude.
	 *
	 * @return the gps longitude
	 */
	public double getGpsLongitude() {
		return gpsLongitude;
	}
	
	/**
	 * Sets the gps longitude.
	 *
	 * @param gpsLongitude the new gps longitude
	 */
	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	
	/**
	 * Gets the gps lattitude.
	 *
	 * @return the gps lattitude
	 */
	public double getGpsLattitude() {
		return gpsLattitude;
	}
	
	/**
	 * Sets the gps lattitude.
	 *
	 * @param gpsLattitude the new gps lattitude
	 */
	public void setGpsLattitude(double gpsLattitude) {
		this.gpsLattitude = gpsLattitude;
	}
	
	
}
