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
    private int id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    @JsonProperty("created_in")
    private String createdIn;
    @Embedded
    private Cost cost;
    @JsonProperty("build_time")
    private int buildTime;
    @JsonProperty("reload_time")
    private int reloadTime;
    @JsonProperty("attack_delay")
    private int attackDelay;
    @JsonProperty("movement_rate")
    private int movementRate;
    @JsonProperty("line_of_sight")
    private int lineOfSight;
    @JsonProperty("hit_points")
    private int hitPoints;
    private String range;
    private int attack;
    private String armor;
    @JsonProperty("attack_bonus")
    @ElementCollection
    private List<String> attackBonus;
    @JsonProperty("armor_bonus")
    @ElementCollection
    private List<String> armorBonus;
    @JsonProperty("search_radius")
    private int searchRadius;
    private String accuracy;
    @JsonProperty("blast_radius")
    private  int blastRadius;

}
