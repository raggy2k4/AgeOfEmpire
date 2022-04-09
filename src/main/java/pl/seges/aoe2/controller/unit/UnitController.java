package pl.seges.aoe2.controller.unit;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.seges.aoe2.domain.unit.UnitService;

import java.util.Map;

@RestController
@RequestMapping("/units")
@AllArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getResponse(
        @RequestParam(name = "food", required = false, defaultValue = "0") Integer food,
        @RequestParam(name = "wood", required = false, defaultValue = "0") Integer wood,
        @RequestParam(name = "gold", required = false, defaultValue = "0") Integer gold,
        @RequestParam(name = "stone", required = false, defaultValue = "0") Integer stone,
        @RequestParam(name = "name", required = false, defaultValue = "") String name
    )
    {
        return ResponseEntity.ok(unitService.getData(food, wood, gold, stone, name));
    }
}
