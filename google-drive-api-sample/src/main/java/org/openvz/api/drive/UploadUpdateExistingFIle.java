package org.openvz.api.drive;

import java.io.IOException;

import org.openvz.api.drive.common.DriveServiceFactory;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.model.File;

public class UploadUpdateExistingFIle {

	public static void main(String[] args) {
		java.io.File newFilePath = new java.io.File("/Users/vaibhavzodge/Downloads/WhatsApp Image 2020-04-26 at 12.01.50 AM.jpeg");
		FileContent newFileContent = new FileContent("image/jpeg", newFilePath);
		try {
			File fileToUpdate = new File();

			File file = DriveServiceFactory.getDriveService()
											.files()
											.update("1LciLpelQkpQhpSYrlbl_CB_5qizl3018", fileToUpdate,newFileContent)
											.execute();
			System.out.println(file.getId());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
