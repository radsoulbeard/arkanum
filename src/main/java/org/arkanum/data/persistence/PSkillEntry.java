package org.arkanum.data.persistence;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Range;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public class PSkillEntry {
	
	@Getter @Setter private Range<Integer> range;
	@Getter @Setter private Map<String, Integer> boni = new HashMap<String, Integer>();

}
