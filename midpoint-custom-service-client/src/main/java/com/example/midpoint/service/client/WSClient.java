/**
 * Copyright (c) 2014 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.midpoint.service.client;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.evolveum.midpoint.infra.wsutil.AbstractWebServiceClient;
import com.example.midpoint.xml.ns.example_1.ExamplePortType;
import com.example.midpoint.xml.ns.example_1.ExampleService;
import com.example.midpoint.xml.ns.example_1.Fault;
import com.example.midpoint.xml.ns.example_1.SearchUserByEmailRequestType;
import com.example.midpoint.xml.ns.example_1.SearchUserByEmailResponseType;

/**
 * 
 * Execute with:
 * 
 * mvn exec:java -Dexec.mainClass="com.example.midpoint.service.client.Main" -Dexec.args="...."
 * 
 * @author semancik
 *
 */
public class WSClient extends AbstractWebServiceClient<ExamplePortType, ExampleService> {

	@Override
	protected ExampleService createService() throws Exception {
		return new ExampleService();
	}

	@Override
	protected Class<ExamplePortType> getPortClass() {
		return ExamplePortType.class;
	}

	@Override
	protected String getDefaultUsername() {
		return "administrator";
	}

	@Override
	protected String getDefaultPassword() {
		return "5ecr3t";
	}

	@Override
	protected String getDefaultEndpointUrl() {
		return "http://localhost:8080/midpoint/ws/example-1";
	}

	@Override
	protected int invoke(ExamplePortType port) {
				
		SearchUserByEmailRequestType request = new SearchUserByEmailRequestType();
		
		String email = "jack@caribbean.com";

		request.setEmail(email);
		SearchUserByEmailResponseType response;
		try {
			response = port.searchUserByEmail(request);
		} catch (Fault e) {
			System.err.println("service invocation failed: "+e.getFaultInfo().getDetail()+" ("+e.getFaultInfo().getCode()+")");
			e.printStackTrace();
			return -100;
		}
		System.out.println("User: "+response.getUser());
		
		return 0;
	}
	
}
