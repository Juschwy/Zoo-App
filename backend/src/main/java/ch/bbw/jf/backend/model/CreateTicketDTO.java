package ch.bbw.jf.backend.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Class: CreateTicketDTO
 *
 * @author Schules
 * @version 12.03.2024
 */
public class CreateTicketDTO {
    private String customerFirstname;
    private String customerLastname;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private Map<TicketCategory, Integer> orderContent;
    private String idId;

    public CreateTicketDTO(String customerFirstname, String customerLastname, LocalDateTime validFrom, LocalDateTime validTo, Map<TicketCategory, Integer> orderContent, String idId) {
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.orderContent = orderContent;
        this.idId = idId;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
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
}
