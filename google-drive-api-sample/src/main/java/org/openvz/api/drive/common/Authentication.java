package org.openvz.api.drive.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;

public class Authentication {

	/**
	 * Global instance of the scopes required by this quickstart. If modifying these
	 * scopes, delete your previously saved tokens/ folder.
	 */
	private static final String TOKENS_DIRECTORY_PATH = "tokens";
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
	private static final String CREDENTIALS_FILE_PATH = "credentials.json";

	protected static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

		// Load client secrets.
		java.io.File file = new java.io.File(CREDENTIALS_FILE_PATH);
		FileInputStream fis = new FileInputStream(file);

		InputStream in = fis;

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JsonFactoryHolder.JSON_FACTORY,
				new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
				JsonFactoryHolder.JSON_FACTORY, clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

}
