package org.springframework.samples.travel.domain.model.booking;

public interface StatsRepository {

	int getFinishedBookings();

	int getCancelledBookings();

	void incrementFinishedBookings();

	void incrementCancelledBookings();

}
