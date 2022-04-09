package pl.seges.aoe2.external.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.seges.aoe2.domain.unit.Unit;
import pl.seges.aoe2.domain.unit.UnitRepository;

@Repository
public interface JpaUnitRepository extends UnitRepository, JpaRepository<Unit, Integer> {
}
