package ch.bbw.jf.backend.controller;

import ch.bbw.jf.backend.model.GetTicketCategoryDTO;
import ch.bbw.jf.backend.model.TicketCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class: TicketCategoryController
 *
 * @author Schules
 * @version 14.03.2024
 */

@RestController
@RequestMapping("/ticket-categories")
public class TicketCategoryController {
    @GetMapping
    public ResponseEntity<List<GetTicketCategoryDTO>> getTicketCategories(){
        return new ResponseEntity<>(Arrays.stream(TicketCategory.values()).map(GetTicketCategoryDTO::new).toList(), HttpStatus.OK);
    }

    @GetMapping("{category}")
    public ResponseEntity<GetTicketCategoryDTO> getTicketCategory(@PathVariable TicketCategory category){
        return new ResponseEntity<>(new GetTicketCategoryDTO(category), HttpStatus.OK);
    }
}
