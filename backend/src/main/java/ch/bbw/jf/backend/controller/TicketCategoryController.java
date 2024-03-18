package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.GetTicketCategoryDTO;
import ch.bbw.jf.backend.model.TicketCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class: TicketCategoryController
 *
 * @author Schules
 * @version 14.03.2024
 */

@RestController
@RequestMapping("/ticket-categories")
@CrossOrigin("http://localhost:5173")
public class TicketCategoryController {
    @GetMapping
    public ResponseEntity<List<GetTicketCategoryDTO>> getTicketCategories(){
        return new ResponseEntity<>(Arrays.stream(TicketCategory.values()).map(GetTicketCategoryDTO::new).toList(), HttpStatus.OK);
    }

    @GetMapping("{categoryString}")
    public ResponseEntity<GetTicketCategoryDTO> getTicketCategory(@PathVariable String categoryString){
        Optional<TicketCategory> category = Arrays.stream(TicketCategory.values()).filter(category1 -> category1.name().equals(categoryString)).findFirst();
        if (category.isPresent()){
            return new ResponseEntity<>(new GetTicketCategoryDTO(category.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
