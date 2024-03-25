package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.TicketCategoryDTO;
import ch.bbw.jf.backend.model.TicketCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Class: TicketCategoryController
 *
 * @author Schules
 * @version 14.03.2024
 */

@RestController
@RequestMapping({"/ticket-categories/", "/ticket-categories"})
@CrossOrigin("http://localhost:5173")
public class TicketCategoryController {
    @GetMapping
    public ResponseEntity<List<TicketCategoryDTO>> getTicketCategories(){
        return new ResponseEntity<>(Arrays.stream(TicketCategory.values()).map(TicketCategoryDTO::new).toList(), HttpStatus.OK);
    }

    @GetMapping("{categoryString}")
    public ResponseEntity<TicketCategoryDTO> getTicketCategory(@PathVariable String categoryString){
        Optional<TicketCategory> category = Arrays.stream(TicketCategory.values()).filter(category1 -> category1.name().equals(categoryString)).findFirst();
        return category
                .map(ticketCategory -> new ResponseEntity<>(new TicketCategoryDTO(ticketCategory), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
