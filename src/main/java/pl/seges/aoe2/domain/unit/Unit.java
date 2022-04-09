package pl.seges.aoe2.domain.unit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.seges.aoe2.domain.cost.Cost;

import java.util.List;

@Data
@EqualsAndHashCode(exclude = "id")
public class Unit {

    int id;
    String name;
    String description;
    String expansion;
    String age;
    String created_in;
    Cost cost;
    int build_time;
    int reload_time;
    int attack_delay;
    int movement_rate;
    int line_of_sight;
    int hit_points;
    String range;
    int attack;
    String armor;
    List<String> attack_bonus;
    List<String> armor_bonus;
    int search_radius;
    String accuracy;
    int blast_radius;

}
