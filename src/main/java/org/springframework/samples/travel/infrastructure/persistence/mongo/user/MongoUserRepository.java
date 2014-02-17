package org.springframework.samples.travel.infrastructure.persistence.mongo.user;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.samples.travel.infrastructure.persistence.mongo.shared.AbstractMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Mongo implementation of {@linkplain UserRepository}
 */
@Repository
public class MongoUserRepository extends AbstractMongoRepository<User> implements UserRepository {

    @Inject
    public MongoUserRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, User.class);
    }

    @Override
    public User findByUsername(String username) {
        return findOneByQuery(query(where("username").is(username)));
    }

	@Override
	public List<User> findAll() {
		return findAllUser();
	}
	
	@Override
	public void deleteByUsername(String username) {
        mongoTemplate.remove(query(where("username").is(username)), clazz);
    }
}
