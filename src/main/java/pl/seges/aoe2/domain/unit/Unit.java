package pl.seges.aoe2.domain.unit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.seges.aoe2.domain.cost.Cost;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = "id")
@Entity
@NoArgsConstructor
public class Unit {

    @Id
    int id;
    String name;
    String description;
    String expansion;
    String age;
    @JsonProperty("created_in")
    String createdIn;
    @Embedded
    Cost cost;
    @JsonProperty("build_time")
    int buildTime;
    @JsonProperty("reload_time")
    int reloadTime;
    @JsonProperty("attack_delay")
    int attackDelay;
    @JsonProperty("movement_rate")
    int movementRate;
    @JsonProperty("line_of_sight")
    int lineOfSight;
    @JsonProperty("hit_points")
    int hitPoints;
    String range;
    int attack;
    String armor;
    @JsonProperty("attack_bonus")
    @ElementCollection
    List<String> attackBonus;
    @JsonProperty("armor_bonus")
    @ElementCollection
    List<String> armorBonus;
    @JsonProperty("search_radius")
    int searchRadius;
    String accuracy;
    @JsonProperty("blast_radius")
    int blastRadius;

}
