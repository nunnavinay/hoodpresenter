package com.vinpoc.hoodpresenter.request;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request class for Hood Filler requirement.
 * 
 * @author vinay.n
 *
 */
@Data
@NoArgsConstructor
public class HoodFillerRequest {
	/**
	 * Hood Capacity
	 */
	@Min(1)
	@NotNull
	private Integer hoodCapacity;

	/**
	 * Available present Weights array
	 */
	@NotNull
	private List<Integer> presentWeights;

}
