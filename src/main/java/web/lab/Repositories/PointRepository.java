package web.lab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lab.Entities.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
}
