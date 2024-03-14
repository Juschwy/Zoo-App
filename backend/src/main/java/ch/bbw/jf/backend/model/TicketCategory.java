package ch.bbw.jf.backend.model;

/**
 * Class: TicketCategory
 *
 * @author Schules
 * @version 12.03.2024
 */
public enum TicketCategory {
    CHILD(10),
    TEENAGER(15),
    ADULT(20),
    PENSIONER(15),
    IV(15);

    private final int prize;

    TicketCategory(int prize) {
        this.prize = prize;
    }

    public int getPrize(){
        return prize;
    }
}
