package org.arkanum.object.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@Slf4j
public class Attributes {
	
	private Map<String, Integer> values = new HashMap<String, Integer>();
	
	
    private  Attributes() {
    	initialize();
    }
    
    public static Attributes create() {
    	return new Attributes();
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
	
	/**
	 * 
	 * @return value has to be multiplied with level
	 */
	public Integer getAddHitBonus() {
		Integer ret = 0;
		Integer value = getAttributeValue(AttribValues.CON);
		if(value == 15) ret = 1;
		if(value > 15) ret = value - 15;
		return ret;	
	}
	
	public Integer getAttackBonus() {
		Integer ret = 0;
		Integer value = getAttributeValue(AttribValues.DEX);
		switch (value) {
		
		case 15:
			ret = 1;
			break;
		case 16:
			ret = 1;
			break;
		case 17:
			ret = 2;
			break;
		case 18:
			ret = 3;
			break;
		case 19:
			ret = 4;
			break;
		case 20:
			ret = 4;
			break;
		case 21:
			ret = 5;
			break;
		case 22:
			ret = 5;
			break;
		case 23:
			ret = 6;
			break;
		case 24:
			ret = 6;
			break;
		case 25:
			ret = 7;
			break;
		default:
		    if(value > 25) ret = 7;
		    else ret = 0;
		}
		
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
