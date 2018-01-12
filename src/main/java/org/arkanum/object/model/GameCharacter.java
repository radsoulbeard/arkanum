package org.arkanum.object.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class GameCharacter {
	
	
	@Getter @Setter private String name;
	@Getter @Setter private Integer level;
	@Getter @Setter private Integer experience;
	@Getter private Integer fame;          
	@Getter @Setter private Integer age;
	
	@Getter @Setter private Race race;
	@Getter @Setter private Profession profession;
	@Getter @Setter private Attributes attributes;
	@Getter @Setter private Skills skills;
	
	
	private GameCharacter(@NonNull Attributes a, Skills s, @NonNull Race r, @NonNull Profession p) 
	{
		attributes = a;
		race = r;
		profession = p;
		
	}
	
	public static GameCharacter create(@NonNull Attributes a, @NonNull Skills s, @NonNull Race r, @NonNull Profession p){
	   return new GameCharacter(a,s,r,p);	
	}
	
	public void setFame(Integer f) {
		if (f > 100)  throw new IllegalArgumentException(String.format("max fame is 100. your fame is: %s", f));
		this.fame = f;
	}
	
	
	public Integer getMaxHits() {
		Integer ret = 0;
		Integer multi = getLevel() < 13 ? getLevel() : 12;
		ret = attributes.getAttributeValue(AttribValues.CON);
		ret = ret + multi*attributes.getAddHitBonus();
		switch(getProfession().getFighterType()) {
		case UNTRAINED:
			ret = ret + multi * 2;
			break;
		case TRAINED:
			ret = ret + multi * 4;
			break;
		case HIGHTRAINED:
			ret = ret + multi * 6;
		}
		if(getLevel() >= 13) {
			ret = ret + 1;
		}
		return ret;
	}
	
	
	
	

}
