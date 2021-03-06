package org.springframework.samples.travel.application.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.samples.travel.application.BookingService;
import org.springframework.samples.travel.domain.model.booking.*;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.samples.travel.domain.shared.SearchCriteria;
import org.springframework.stereotype.Service;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;
    private final StatsRepository statsRepository;

    @Inject
    public BookingServiceImpl(UserRepository userRepository, HotelRepository hotelRepository,
            BookingRepository bookingRepository, StatsRepository statsRepository) {
        super();
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
        this.statsRepository = statsRepository;
    }

    @Override
    public List<Hotel> findHotels(SearchCriteria searchCriteria) {
        return hotelRepository.findHotelsByCriteria(searchCriteria);
    }

    @Override
    public Hotel findHotel(String id) {
        return hotelRepository.findHotelById(id);
    }

    @Override
    public List<Booking> findBookings(String username) {
        User user = userRepository.findByUsername(username);
        return bookingRepository.findUserBookings(user);
    }

    @Override
    public Booking createBooking(String hotelId, String username) {
        Hotel hotel = findHotel(hotelId);
        User user = userRepository.findByUsername(username);
        return bookingRepository.save(hotel.createBooking(user));
    }

    @Override
    public void cancelBooking(String id) {
        statsRepository.incrementCancelledBookings();
        bookingRepository.delete(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        statsRepository.incrementFinishedBookings();
        return bookingRepository.save(booking);
    }
}
