package org.example;

import org.example.models.tickets.Currency;
import org.example.models.tickets.StadiumSector;
import org.example.models.tickets.Ticket;
import org.example.models.tickets.TicketPrice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class TicketStorage {

    private final ArrayList<Ticket> storage;

    TicketStorage() {
        this.storage = new ArrayList<Ticket>();
        this.storage.add(Ticket.createEmpty());
        this.storage.add(Ticket.createEmpty());
        this.storage.add(Ticket.createEmpty());
        this.storage.add(Ticket.createEmpty());
        this.storage.add(Ticket.createLimited(new TicketPrice(BigDecimal.valueOf(100), Currency.USD), "Harpa Hall", 111, 1749265004L));
        this.storage.add(Ticket.createLimited(new TicketPrice(BigDecimal.valueOf(200), Currency.USD), "Rudolfinum", 222, 1780801004L));
        this.storage.add(Ticket.createLimited(new TicketPrice(BigDecimal.valueOf(300), Currency.USD), "La Scala", 333, 1812337004L));
        this.storage.add(Ticket.createLimited(new TicketPrice(BigDecimal.valueOf(400), Currency.USD), "SoundBox", 444, 1843959404L));
        this.storage.add(Ticket.create(new TicketPrice(BigDecimal.valueOf(500), Currency.USD), "TuneHub", 555, 1875495404L, false, StadiumSector.B, 10.5));
        this.storage.add(Ticket.create(new TicketPrice(BigDecimal.valueOf(600), Currency.USD), "AriaHall", 666, 1907031404L, true, StadiumSector.C, 5.0));
    }

    public Optional<Ticket> getTicketById(String id) {
        for (Ticket ticket : this.storage) {
            if (Objects.equals(ticket.getId(), id)) {
                return Optional.of(ticket);
            }
        }

        return Optional.empty();
    }
}
