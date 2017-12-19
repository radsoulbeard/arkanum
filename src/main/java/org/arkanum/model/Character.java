package org.arkanum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Character {
	
	
	@Getter @Setter private String name;
	@Getter @Setter private Integer level;
	@Getter @Setter private Integer experience;
	@Getter private Integer fame;          
	@Getter @Setter private Integer age;
	
	@Getter @Setter private Race race;
	@Getter @Setter private Profession profession;
	
	
	public Character() {}
	
	public void setFame(Integer f) {
		if (f > 100)  throw new IllegalArgumentException(String.format("max fame is 100. your fame is: %s", f));
		this.fame = f;
	}
	

}
