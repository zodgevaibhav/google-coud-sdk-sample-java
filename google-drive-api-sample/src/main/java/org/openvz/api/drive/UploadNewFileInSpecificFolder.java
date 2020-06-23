package org.openvz.api.drive;

import java.io.IOException;
import java.util.Collections;

import org.openvz.api.drive.common.DriveServiceFactory;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

public class UploadNewFileInSpecificFolder {

	public static void main(String[] args) {
		
		File fileMetaData = new File();
		fileMetaData.setName("myfileViaApi.jpg");
		fileMetaData.setParents(Collections.singletonList("1DWWCyg6lX6w75tn5if6JnoxHNBdFVoGn"));
		
		java.io.File filePath = new java.io.File("/Users/vaibhavzodge/Downloads/UDFT.jpeg");
		
		FileContent fileContent = new FileContent("image/jpeg", filePath);
		
		try {
			Drive service = DriveServiceFactory.getDriveService();
			File file = DriveServiceFactory.getDriveService()
											.files()
											.create(fileMetaData, fileContent)
											.setFields("id")
											.execute();
			System.out.println(file.getId());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
