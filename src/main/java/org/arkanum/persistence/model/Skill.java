package org.arkanum.persistence.model;



import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Skill {
	
	@Getter @Setter private String skill;
	@Getter private Integer value;
	private Map<String, Integer> bonus = new HashMap<String, Integer>();
	 
	public void setValue(Integer v) {
		if (v > 100)  throw new IllegalArgumentException(String.format("max value is 100. your value is: %s", v));
		this.value = v;
	}
	
	

}
