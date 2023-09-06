package com.soap.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.demo.loaneligibility.Acknowledgement;
import com.soap.demo.loaneligibility.CustomerRequest;
import com.soap.demo.service.LoanEligibiltyServices;

@Endpoint
public class LoanEligibiltyIndicatorEndpoint {

	private static final String NAMESPACE = "http://www.soap.com/demo/loaneligibility";

	@Autowired
	private LoanEligibiltyServices services;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	private Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return services.checkLoanEligibilty(request);
	}

}
