package pl.seges.aoe2.domain.cost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cost {

    @JsonProperty("Wood")
    int wood;
    @JsonProperty("Food")
    int food;
    @JsonProperty("Stone")
    int stone;
    @JsonProperty("Gold")
    int gold;

}
