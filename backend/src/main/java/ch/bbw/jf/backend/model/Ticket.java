package ch.bbw.jf.backend.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Class: Ticket
 *
 * @author Schules
 * @version 12.03.2024
 */
public class Ticket {
    private UUID id;
    private String customerFirstname;
    private String customerLastname;
    private LocalDateTime orderTime;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private Map<TicketCategory, Integer> orderContent;
    private String idId;
    private int prize;

    public Ticket(String customerFirstname, String customerLastname, LocalDateTime validFrom, LocalDateTime validTo, Map<TicketCategory, Integer> orderContent, String idId) {
        id = UUID.randomUUID();
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        orderTime = LocalDateTime.now();
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.orderContent = orderContent;
        this.idId = idId;
        prize = orderContent.entrySet().stream().reduce(0, (sum, entry) -> sum + (entry.getKey().getPrize() * entry.getValue()), Integer::sum);
    }

    public Ticket(String customerFirstname, String customerLastname, LocalDateTime validFrom, LocalDateTime validTo, Map<TicketCategory, Integer> orderContent) {
        this(customerFirstname, customerLastname, validFrom, validTo, orderContent, null);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public Map<TicketCategory, Integer> getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(Map<TicketCategory, Integer> orderContent) {
        this.orderContent = orderContent;
    }

    public String getIdId() {
        return idId;
    }

    public int getPrize() {
        return prize;
    }
}
