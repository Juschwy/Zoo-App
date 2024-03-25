package ch.bbw.jf.backend.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Class: Ticket
 *
 * @author Schules
 * @version 12.03.2024
 */
public class Ticket {
    private final UUID id;
    private final LocalDateTime orderTime;
    private final LocalDateTime validFrom;
    private final LocalDateTime validTo;
    private final Map<TicketCategory, Integer> orderContent;
    private final String idId;
    private final int prize;

    public Ticket(LocalDateTime validFrom, LocalDateTime validTo, Map<TicketCategory, Integer> orderContent, String idId) {
        id = UUID.randomUUID();
        orderTime = LocalDateTime.now();
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.orderContent = orderContent;
        if (idId.isBlank()) idId = null;
        this.idId = idId;
        prize = orderContent.entrySet().stream().reduce(0, (sum, entry) -> sum + (entry.getKey().getPrize() * entry.getValue()), Integer::sum);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public Map<TicketCategory, Integer> getOrderContent() {
        return orderContent;
    }

    public String getIdId() {
        return idId;
    }

    public int getPrize() {
        return prize;
    }
}
