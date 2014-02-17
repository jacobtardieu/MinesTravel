package org.springframework.samples.travel.infrastructure.persistence.mongo.booking;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.samples.travel.domain.model.booking.Stats;
import org.springframework.samples.travel.domain.model.booking.StatsRepository;
import org.springframework.samples.travel.infrastructure.persistence.mongo.shared.AbstractMongoRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class MongoStatsRepository extends AbstractMongoRepository<Stats> implements StatsRepository {

    @Inject
    public MongoStatsRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Stats.class);
    }

    @Override
    public int getFinishedBookings() {
        return findOneById("1").getFinishedBookings();
    }

    @Override
    public int getCancelledBookings() {
        return findOneById("1").getCancelledBookings();
    }

    @Override
    public void incrementFinishedBookings() {
        Stats oldStats = findOneById("1");
        if (oldStats == null) oldStats = new Stats();
        oldStats.setFinishedBookings(oldStats.getFinishedBookings() + 1);
        save(oldStats);
    }

    @Override
    public void incrementCancelledBookings() {
        Stats oldStats = findOneById("1");
        if (oldStats == null) oldStats = new Stats();
        oldStats.setFinishedBookings(oldStats.getCancelledBookings() + 1);
        save(oldStats);
    }
}
