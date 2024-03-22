package ch.bbw.jf.backend.model;

/**
 * Class: GetTicketCategoryDTO
 *
 * @author Schules
 * @version 14.03.2024
 */
public class TicketCategoryDTO {
    private String name;
    private int prize;

    public TicketCategoryDTO(TicketCategory category) {
        this.name = category.name();
        this.prize = category.getPrize();
    }

    public String getName() {
        return name;
    }

    public int getPrize() {
        return prize;
    }
}
