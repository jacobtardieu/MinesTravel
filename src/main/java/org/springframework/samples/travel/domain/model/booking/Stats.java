package org.springframework.samples.travel.domain.model.booking;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Stats implements Serializable {

    @Id
    private String id = "1";

    public int getFinishedBookings() {
        return finishedBookings;
    }

    public void setFinishedBookings(int finishedBookings) {
        this.finishedBookings = finishedBookings;
    }

    public int getCancelledBookings() {
        return cancelledBookings;
    }

    public void setCancelledBookings(int cancelledBookings) {
        this.cancelledBookings = cancelledBookings;
    }

    private int finishedBookings = 0;
    private int cancelledBookings = 0;

}
