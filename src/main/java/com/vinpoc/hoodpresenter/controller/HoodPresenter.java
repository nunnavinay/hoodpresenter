package com.vinpoc.hoodpresenter.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinpoc.hoodpresenter.request.HoodFillerRequest;
import com.vinpoc.hoodpresenter.response.HoodFillerResponse;
import com.vinpoc.hoodpresenter.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller for Hood presents.
 * 
 * @author vinay.n
 *
 */
@RestController
@RequestMapping("/hoodfiller")
@Slf4j
public class HoodPresenter {

	/**
	 * API to get the presents matching the capacity with weights.
	 * 
	 * @param request Hood Filler Request Object with Capacity & PresentWeights
	 * 
	 * @return Eligible Presents that can be filled
	 */
	@PostMapping(value = "/presents", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HoodFillerResponse fillHood(@RequestBody HoodFillerRequest request) {
		log.debug("Request received for presents :{}", request);
		HoodFillerResponse response = new HoodFillerResponse();
		int hoodCapacity = request.getHoodCapacity();
		List<Integer> presentWeights = request.getPresentWeights();
		// Get possible combinations.
		List<List<Integer>> results = CommonUtil.getPresentsCombinations(presentWeights, hoodCapacity);
		// Prepare the hood with minimizing the number of items.
		response.setPresentCombinations(CommonUtil.getMinimizedList(results));
		log.debug("Response for the presents :{}", results);
		return response;

	}

}
