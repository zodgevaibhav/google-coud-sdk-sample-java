package org.openvz.api.drive.common;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class JsonFactoryHolder {
	
    protected static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
}
