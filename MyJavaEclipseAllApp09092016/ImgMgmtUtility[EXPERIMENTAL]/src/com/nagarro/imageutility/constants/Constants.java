package com.nagarro.imageutility.constants;

/**
 * The Class Constants to store the constant values.
 * 
 * @author ricktamkundu
 */

public class Constants {
	/*
	 * Name of fields that should be used in the string given by user for input
	 * and output
	 */

	/**
	 * The Constant RESOURCE_PATH for accessing the properties file from the
	 * resources.
	 */
	public static final String RESOURCE_PATH = "com/nagarro/j2ee/imageutility/resources/";

	/** The Constant JSP_PATH for getting the path of the jsp files. */
	public static final String JSP_PATH = "/ImgMgmtUtility[EXPERIMENTAL]/jsp/";

	/** The Constant HTML_PATH for getting the path of the html files. */
	public static final String HTML_PATH = "/ImgMgmtUtilityAssgn4/jsp/";

	/**
	 * The Constant SELECT_FULLNAME_QUERY which selects the full name of the
	 * user from the database corresponding to an USERID.
	 */
	public static final String SELECT_FULLNAME_QUERY = "SELECT rd.fullName FROM RegisterDetail rd WHERE userId=?";

	/**
	 * The Constant SELECT_PASSWORD_QUERY which selects the password of the user
	 * from the database corresponding to an emailID.
	 */
	public static final String SELECT_PASSWORD_QUERY = "SELECT regDetail.password FROM RegisterDetail regDetail  WHERE email=?";

	/**
	 * The Constant SELECT_USERID_QUERY which selects the USERID of the user
	 * from the database corresponding to an username and password.
	 */
	public static final String SELECT_USERID_QUERY = "SELECT rd.userId FROM RegisterDetail rd WHERE userName=? and password=?";

	/**
	 * The Constant SELECT_ALLUSER_QUERY which selects everything of the user
	 * from the database corresponding to an username and password.
	 */
	public static final String SELECT_ALLUSER_QUERY = "FROM RegisterDetail WHERE userName=? and password=?";

	/**
	 * The Constant SELECT_USERNAME_QUERY which selects all Username of the user
	 * from the database.
	 */
	public static final String SELECT_USERNAME_QUERY = "SELECT rd.userName FROM RegisterDetail rd";

	/**
	 * The Constant DELETE_IMAGEDETAIL_QUERY which delete image details from the
	 * database corresponding to userId.
	 */
	public static final String DELETE_IMAGEDETAIL_QUERY = "DELETE FROM ImageDetail imgD WHERE imgD.userId=?";

	/**
	 * The Constant UPDATE_IMAGEDETAIL_QUERY which update image details from the
	 * database corresponding to ImageId and set the new Image Name.
	 */
	public static final String UPDATE_IMAGEDETAIL_QUERY = "UPDATE ImageDetail imgD SET imgD.name=? WHERE imgD.userId=?";

	/**
	 * The Constant SELECT_IMAGESTREAM_QUERY which selects the image stream of
	 * bytes from the database corresponding to userId.
	 */
	public static final String SELECT_IMAGESTREAM_QUERY = "SELECT imgD.imageStream FROM ImageDetail imgD WHERE userId=?";

	/**
	 * The Constant COUNT_IMAGES_QUERY which count the total number of images
	 * corrosponding to a particular userId.
	 */
	public static final String COUNT_IMAGES_QUERY = "SELECT count(id.registerDetail) FROM ImageDetail id WHERE registerDetail=? ";

	/**
	 * The Constant SUM_IMAGESIZE_QUERY get the total sum of the images in MB
	 * for every user seperately.
	 */
	public static final String SUM_IMAGESIZE_QUERY = "SELECT sum(id.size) FROM ImageDetail id WHERE registerDetail=? ";

	/**
	 * The Constant SELECT_ALLIMAGE_QUERY will get the all images form the
	 * database and store it in list.
	 */
	public static final String SELECT_ALLIMAGE_QUERY = "FROM ImageDetail WHERE registerDetail=?";

}
