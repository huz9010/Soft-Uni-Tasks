package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.constants.enumeration.StarType;
import softuni.exam.models.entity.Star;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findFirstByName(String name);

    Optional<Star> findFirstById(Long Id);

    List<Star> findAllByStarTypeAndObserversEmptyOrderByLightYears(StarType starType);

}
