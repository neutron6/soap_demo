package com.soap.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soap.demo.loaneligibility.Acknowledgement;
import com.soap.demo.loaneligibility.CustomerRequest;

@Service
public class LoanEligibiltyServices {

	public Acknowledgement checkLoanEligibilty(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

		if (!(request.getAge() > 30 && request.getAge() <= 60)) {
			mismatchCriteriaList.add("person age should in between 30 to 60");
		}
		if (!(request.getYearlyIncome() > 200000)) {
			mismatchCriteriaList.add("minimum income should be 2 lakh");
		}
		if (!(request.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Low CIBIL score plz try after 6 months");
		}
		if (mismatchCriteriaList.size() > 0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		} else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		return acknowledgement;

	}

}
