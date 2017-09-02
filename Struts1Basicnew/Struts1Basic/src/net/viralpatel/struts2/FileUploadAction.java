package net.viralpatel.struts2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.CharBuffer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements
		ServletRequestAware {
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	private HttpServletRequest servletRequest;

	public String execute() {
		try {
			
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userFile");  
            
	        System.out.println("Image Location:" + filePath);//see the server console for actual location  
	        File fileToCreate = new File(filePath,userImageFileName);  
	        FileUtils.copyFile(userImage, fileToCreate);//copying source file to new file  
			
			
			final InputStream filecontent = new FileInputStream(this.userImage);
			final byte[] fileBytes = new byte[(int) this.userImage.length()];
			filecontent.read(fileBytes);
			filecontent.close();
			

			 //create a temp file
		    File temp = File.createTempFile("tempfile.csv", ".tmp");

	    //write it
		    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		   
		    //String s = null;
		  // char ch[] = null;
		   CharBuffer chbuff = CharBuffer.allocate(1024);
			for (int i = 0; i < fileBytes.length; i++) {
				//chbuff.append(c)
				//chbuff.append((char)fileBytes[i]);
				chbuff.put(i, (char)fileBytes[i]);
				//ch[i]=((char)fileBytes[i]);
				 bw.write((char)fileBytes[i]);
		       	System.out.print((char)fileBytes[i]);
	            }
			 bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());

			return INPUT;
		}
		return SUCCESS;
	}
	

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}
}
