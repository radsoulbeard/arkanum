package org.arkanum.data.repositories;

import org.arkanum.data.persistence.PSkill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PSkillRepository extends MongoRepository<PSkill, String> {

}
