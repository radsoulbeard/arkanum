package org.arkanum.object.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Skills {
	
	private List<Skill> skills = new ArrayList<Skill>();
	
	
	public Integer getSumBonusFor(String type)
	{
		LongAdder ret = new LongAdder();
		skills.stream().forEach(s->{
			if(s.getBonus().containsKey(type))
			{
				ret.add(s.getBonus().get(type));
			}
		});
		
		return ret.intValue();
	}
	
	

}
