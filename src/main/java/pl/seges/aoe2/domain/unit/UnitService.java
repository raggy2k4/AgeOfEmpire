package pl.seges.aoe2.domain.unit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnitService {

    private final UnitRepository repository;

    public Map<String, Integer> getData(int food, int wood, int gold, int stone, String name) {

        List<Unit> units = repository.findAll();

        List<Unit> unitsFilteredByPossibleToProduct = units.stream()
                .filter(unit -> unit.getCost().getFood() <= food)
                .filter(unit -> unit.getCost().getWood() <= wood)
                .filter(unit -> unit.getCost().getGold() <= gold)
                .filter(unit -> unit.getCost().getStone() <= stone)
                .collect(Collectors.toList());

        return calcUnitsToProducion(food, wood, gold, stone, unitsFilteredByPossibleToProduct);
    }

    private Map<String, Integer> calcUnitsToProducion(int food, int wood, int gold, int stone, List<Unit> units) {

        Map<String, Integer> unitsProductionPlant = new HashMap<>();

        units.stream()
                .forEach(unit -> {
                    int licznik = 0;

                    int foodL = food;
                    int woodL = wood;
                    int goldL = gold;
                    int stoneL = stone;

                    int foodCost = unit.getCost().getFood();
                    int woodCost = unit.getCost().getWood();
                    int goldCost = unit.getCost().getGold();
                    int stoneCost = unit.getCost().getStone();

                    while (true){
                        if (foodL >= foodCost && woodL >= woodCost && goldL >= goldCost && stoneL >= stoneCost){
                            licznik++;
                            foodL = foodL - foodCost;
                            woodL = woodL - woodCost;
                            goldL = goldL - goldCost;
                            stoneL = stoneL - stoneCost;
                        } else {
                            unitsProductionPlant.put(unit.getName(), licznik);
                            break;
                        }
                    }
                });

        return unitsProductionPlant;
    }
}
