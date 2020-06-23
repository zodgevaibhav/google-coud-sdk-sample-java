package org.openvz.api.drive;

import java.io.IOException;
import java.util.Collections;

import org.openvz.api.drive.common.DriveServiceFactory;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

public class UploadNewFileAndConvertToGoogleSheet {

	public static void main(String[] args) {
		File fileMetaData = new File();
		fileMetaData.setName("LoginTest");
		fileMetaData.setParents(Collections.singletonList("1DWWCyg6lX6w75tn5if6JnoxHNBdFVoGn"));
		
		fileMetaData.setMimeType("application/vnd.google-apps.spreadsheet");
		/*
		  Common Google mime type URL :https://developers.google.com/drive/api/v3/mime-types
		 */

		java.io.File filePath = new java.io.File("/Users/vaibhavzodge/eclipse-workspace/google-api-sample/LoginTest.xlsx");

		FileContent fileContent = new FileContent("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", filePath);
		/*
		  Common mime type URL https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		 */
		try {
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
