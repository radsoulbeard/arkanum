package org.arkanum.model;

import org.arkanum.object.model.AttribValues;
import org.arkanum.object.model.Attributes;
import org.arkanum.object.model.FighterType;
import org.arkanum.object.model.GameCharacter;
import org.arkanum.object.model.Profession;
import org.arkanum.object.model.Race;
import org.arkanum.object.model.Skills;
import org.junit.Test;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameCharacterTest {
	
	
	
	
	@Test
	public void  testGetMaxHits()
	{
		GameCharacter gc = GameCharacter.create(Attributes.create(),new Skills(), new Race(), new Profession());
		gc.getAttributes().setAttributeValue(AttribValues.CON, 12);
		gc.getProfession().setFighterType(FighterType.HIGHTRAINED);
		gc.setLevel(2);
		Integer maxHits = gc.getMaxHits();
	    System.out.println("MaxHits: " + maxHits);
	    Gson gson = new Gson();
	    String json = gson.toJson(gc);
	    System.out.println(json);
	    
	}

   

}


