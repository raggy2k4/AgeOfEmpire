package pl.seges.aoe2.domain.unit;

import lombok.Value;

import java.util.Map;

@Value
public class UnitResponse {

    Map<String, Integer> unitsProductionPlant;

}
