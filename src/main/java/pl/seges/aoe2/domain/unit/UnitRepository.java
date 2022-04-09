package pl.seges.aoe2.domain.unit;

import java.util.List;

public interface UnitRepository {

    Unit save(Unit unit);
    List<Unit> findAll();

}
