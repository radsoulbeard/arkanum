package org.arkanum.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@Slf4j
public class Attributes {
	
	private Map<String, Integer> values = new HashMap<String, Integer>();
	
	
    public 	Attributes() {
    	initialize();
    }
	
	
	public Integer getAttributeValue(String attribute) {
		return values.get(attribute);
	}
	
	public void setAttributeValue(String attribute, Integer value) {
		values.put(attribute, value);
	}
	
	public Integer getBonus(String attribute) {
		Integer ret = 0;
		Integer value = getAttributeValue(attribute);
		if(value == 15) ret = 1;
		if(value > 15) ret = value - 15;
		if(value < 10 ) ret = value - 10;
		return ret;
	}
	
	public Integer getAddDamage() {
		Integer ret = 0;
		Integer value = getAttributeValue(AttribValues.STR);
		if (value > 14 && value < 25) ret = value - 14;
		if (value >= 25 ) ret = 12;
		return ret;
	}
	
	private void initialize() {
		Class<?> c  = AttribValues.class;
		for(Field f : c.getDeclaredFields()) {
			try {
				setAttributeValue((String) f.get(f), 0);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage());
			} catch (IllegalAccessException e) {
				log.error(e.getMessage());
			}
		}
		
	}
	

}
