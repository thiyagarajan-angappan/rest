package com.rest.apm;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/v1")
public class APMDemoApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		
		/*Map<String, String> apmConfig = new HashMap<String, String>();
		apmConfig.put("service_name", "apmdemoapp");
		apmConfig.put("server_urls", "http://127.0.0.1:8200");
		apmConfig.put("application_packages", "com.rest.apm");
		System.out.println("---> attaching apm");
		ElasticApmAttacher.attach(apmConfig);
		System.out.println("---> attached apm");*/
		
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(APMDemoRS.class);
		
		return resources;
	}
}