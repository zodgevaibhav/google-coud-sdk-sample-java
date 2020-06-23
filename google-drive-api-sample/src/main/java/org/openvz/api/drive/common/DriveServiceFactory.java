package org.openvz.api.drive.common;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;

public class DriveServiceFactory {

	public static Drive getDriveService() {
		try {
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			return new Drive.Builder(HTTP_TRANSPORT, JsonFactoryHolder.JSON_FACTORY,
					Authentication.getCredentials(HTTP_TRANSPORT)).setApplicationName("GoogleDrive").build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
