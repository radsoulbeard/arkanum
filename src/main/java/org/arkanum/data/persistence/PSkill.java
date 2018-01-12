package org.arkanum.data.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class PSkill {
	
	@Id @Getter @Setter private String id;
	@Getter @Setter private String name;
	@Getter @Setter private List<PSkillEntry> entry = new ArrayList<PSkillEntry>();

}
