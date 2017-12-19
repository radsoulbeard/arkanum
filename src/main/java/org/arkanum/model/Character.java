package org.arkanum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Character {
	
	
	@Getter @Setter private String name;
	@Getter private Integer level;
	@Getter private Integer maxHits;
	@Getter @Setter private Integer experience;
	@Getter private Integer fame;          
	@Getter @Setter private Integer age;
	
	@Getter @Setter private Race race;
	@Getter @Setter private Profession profession = new Profession();
	private Attributes attributes = new Attributes();
	
	
	public Character() {}
	
	public void setFame(Integer f) {
		if (f > 100)  throw new IllegalArgumentException(String.format("max fame is 100. your fame is: %s", f));
		this.fame = f;
	}
	
	public void setLevel(Integer l) {
		level = l;
		calculateMaxHits();
	}
	
	public Integer getAttribute(String attribute) {
		return attributes.getAttributeValue(attribute);
	}
	
	public void setAttribute(String attribute, Integer value) {
		attributes.setAttributeValue(attribute, value);
		calculateMaxHits();
		
	}
	
	
	private void calculateMaxHits() {
		Integer ret = 0;
		Integer multi = level < 13 ? level : 12;
		ret = attributes.getAttributeValue(AttribValues.CON);
		ret = ret + multi*attributes.getAddHitBonus();
		switch(profession.getFighterType()) {
		case UNTRAINED:
			ret = ret + multi * 2;
			break;
		case TRAINED:
			ret = ret + multi * 4;
			break;
		case HIGHTRAINED:
			ret = ret + multi * 6;
		}
		if(level >= 13) {
			ret = ret + 1;
		}
		maxHits = ret;
	}
	

}
