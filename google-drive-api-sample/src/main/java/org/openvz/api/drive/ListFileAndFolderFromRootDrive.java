package org.openvz.api.drive;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.openvz.api.drive.common.DriveServiceFactory;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class ListFileAndFolderFromRootDrive {
	private static final String APPLICATION_NAME = "List file and folders from drive";

	public static void main(String... args) throws IOException, GeneralSecurityException {

		Drive service = DriveServiceFactory.getDriveService();
		FileList result = service.files().list().setPageSize(10).setFields("nextPageToken, files(id, name)").execute();
		List<File> files = result.getFiles();
		if (files == null || files.isEmpty()) {
			System.out.println("No files found.");
		} else {
			System.out.println("Files:");
			for (File file : files) {
				System.out.printf("%s (%s)\n", file.getName(), file.getId());
			}
		}
	}
}