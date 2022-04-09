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

        if (!name.isEmpty()){
           units = units.stream().filter(unit -> unit.getName().equals(name)).collect(Collectors.toList());
        }

        List<Unit> unitsFilteredByPossibleToProduct = units.stream()
                .filter(unit -> unit.getCost().getFood() <= food)
                .filter(unit -> unit.getCost().getWood() <= wood)
                .filter(unit -> unit.getCost().getGold() <= gold)
                .filter(unit -> unit.getCost().getStone() <= stone)
                .collect(Collectors.toList());


        return calcUnitsToProduction(food, wood, gold, stone, unitsFilteredByPossibleToProduct);
    }

    private Map<String, Integer> calcUnitsToProduction(int food, int wood, int gold, int stone, List<Unit> units) {

        Map<String, Integer> unitsProductionPlant = new HashMap<>();

        units.stream()
                .forEach(unit -> {
                    int quantityOfUnit = 0;

                    int foodQuantity = food;
                    int woodQuantity = wood;
                    int goldQuantity = gold;
                    int stoneQuantity = stone;

                    int foodCost = unit.getCost().getFood();
                    int woodCost = unit.getCost().getWood();
                    int goldCost = unit.getCost().getGold();
                    int stoneCost = unit.getCost().getStone();


                    while (foodQuantity >= foodCost && woodQuantity >= woodCost && goldQuantity >= goldCost && stoneQuantity >= stoneCost){
                          if (0 == foodCost && 0 >= woodCost && 0 >= goldCost && 0 >= stoneCost){
                              break;
                          }

                            quantityOfUnit++;
                            foodQuantity = foodQuantity - foodCost;
                            woodQuantity = woodQuantity - woodCost;
                            goldQuantity = goldQuantity - goldCost;
                            stoneQuantity = stoneQuantity - stoneCost;
                    }

                    unitsProductionPlant.put(unit.getName(), quantityOfUnit);
                });
        return unitsProductionPlant;
    }
}
