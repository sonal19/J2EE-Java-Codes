package com.nagarro.struts.hrmanager.dto;

import java.io.File;

public class FileUploadDetail {
	private File usersFile;
	private String usersFileContentType;
	private String usersFileName;

	public File getUsersFile() {
		return usersFile;
	}

	public void setUsersFile(File usersFile) {
		this.usersFile = usersFile;
	}

	public String getUsersFileContentType() {
		return usersFileContentType;
	}

	public void setUsersFileContentType(String usersFileContentType) {
		this.usersFileContentType = usersFileContentType;
	}

	public String getUsersFileName() {
		return usersFileName;
	}

	public void setUsersFileName(String usersFileName) {
		this.usersFileName = usersFileName;
	}

}
