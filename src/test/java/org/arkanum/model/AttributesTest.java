package org.arkanum.model;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.arkanum.persistence.model.AttribValues;
import org.arkanum.persistence.model.Attributes;
import org.junit.Test;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AttributesTest {

	@Test
	public void testGetBonus() {
		Attributes attrib = new Attributes();
		
		attrib.setAttributeValue(AttribValues.CHA, 15);
		assertTrue(attrib.getBonus(AttribValues.CHA) == 1);
		
		
		attrib.setAttributeValue(AttribValues.STR, 6);
		assertTrue(attrib.getBonus(AttribValues.STR) == -4);
		
		attrib.setAttributeValue(AttribValues.WIL, 10);
		assertTrue(attrib.getBonus(AttribValues.WIL) == 0);
		
	}

	@Test
	public void testGetAddDamage() {
		Attributes attrib = new Attributes();
		
		for(int i = 14; i < 25; i++) {
			attrib.setAttributeValue(AttribValues.STR, i);
			assertTrue((i - 14) == attrib.getAddDamage());
		}
		attrib.setAttributeValue(AttribValues.STR, 25);
		assertTrue(12 == attrib.getAddDamage());
		attrib.setAttributeValue(AttribValues.STR, 10);
		assertTrue(0 == attrib.getAddDamage());
	}
	
	@Test
	public void testObjectToJson() {
		Attributes attrib = new Attributes();
		Class<?> c  = AttribValues.class;
		for(Field f : c.getDeclaredFields()) {
			try {
				attrib.setAttributeValue((String) f.get(f), 10);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage());
			} catch (IllegalAccessException e) {
				log.error(e.getMessage());
			}
		}
		Gson gson = new Gson();
		String json = gson.toJson(attrib);
		assertTrue(json.contains("values"));
		assertTrue(json.contains("\"willpower\":10"));
	}

}
