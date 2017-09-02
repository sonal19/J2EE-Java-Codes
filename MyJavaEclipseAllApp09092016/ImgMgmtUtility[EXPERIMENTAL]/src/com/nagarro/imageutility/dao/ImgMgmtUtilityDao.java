package com.nagarro.imageutility.dao;

import java.util.List;

import com.nagarro.imageutility.exceptions.UserExceptionClass;
import com.nagarro.imageutility.models.ImageDetail;

/**
 * The Interface ImgMgmtUtilityDao.It defines all the function which is related
 * to database Image management and server access those database with help of
 * these functions
 */
public interface ImgMgmtUtilityDao {

	/**
	 * Checks if is image deleted from the database or not.
	 *
	 * @param imageId
	 *            the image id
	 * @return true, if is image deleted
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	boolean isImageDeleted(int imageId) throws UserExceptionClass;

	/**
	 * Checks if is image edited from the database after client click or not.
	 *
	 * @param imageId
	 *            the image id
	 * @param editName
	 *            the edit name
	 * @return true, if is image edited
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	boolean isImageEdited(int imageId, String editName) throws UserExceptionClass;

	/**
	 * Gets the image stream and send it to the servlet for showing the image in
	 * the browser.
	 *
	 * @param imageId
	 *            the image id
	 * @return the image stream
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	byte[] getImageStream(int imageId) throws UserExceptionClass;

	/**
	 * Gets the table data count to check the number of entry in the table at
	 * the present so that new entry can be made easily.
	 *
	 * @param userId
	 *            the user id
	 * @return the table data count
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	long getTableDataCount(int userId) throws UserExceptionClass;

	/**
	 * Gets the total img size to get the total image in MB uploaded in the
	 * database.
	 *
	 * @param userId
	 *            the user id
	 * @return the total img size
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	double getTotalImgSize(int userId) throws UserExceptionClass;

	/**
	 * Gets the user image data.It gives the images for each user after the
	 * successful login of the user
	 *
	 * @param userId
	 *            the user id
	 * @return the user image data
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	@SuppressWarnings("rawtypes")
	List getUserImageData(int userId) throws UserExceptionClass;

	/**
	 * Insert image will insert the image into the database in the form of byte
	 * stream and also insert image properties like size name etc.
	 *
	 * @param imageDetails
	 *            the image details
	 * @throws UserExceptionClass
	 *             the user exception class for getting the session exception
	 */
	void insertImage(ImageDetail imageDetails) throws UserExceptionClass;

}
