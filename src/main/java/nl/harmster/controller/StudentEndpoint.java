package nl.harmster.controller;

import nl.harmster.dao.StudentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import nl.harmster.soap.GetStudentRequest;
import nl.harmster.soap.GetStudentResponse;
@Endpoint
public class StudentEndpoint {
	private static final String NAMESPACE_URI = "http://harmster.nl/soap";
	@Autowired
	private StudentUtility studentUtility;	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getCountry(@RequestPayload GetStudentRequest request) {
		GetStudentResponse response = new GetStudentResponse();
		response.setStudent(studentUtility.getStudent(request.getStudentId()));
		return response;
	}
} 
