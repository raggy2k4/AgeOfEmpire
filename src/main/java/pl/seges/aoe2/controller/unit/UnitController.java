package pl.seges.aoe2.controller.unit;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.seges.aoe2.domain.unit.UnitService;

@RestController
@RequestMapping("/units")
@AllArgsConstructor
public class UnitController {

    private final UnitService unitService;

}
