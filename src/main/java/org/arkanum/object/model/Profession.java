package org.arkanum.object.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Profession {
	
	@Getter @Setter private String profession;
	@Getter @Setter private Attributes minValues;
	@Getter @Setter private FighterType fighterType;

}
