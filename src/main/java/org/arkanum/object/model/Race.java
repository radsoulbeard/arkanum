package org.arkanum.object.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Race {
	
	@Getter @Setter private String race;
	@Getter @Setter private Attributes maxValues;

}
