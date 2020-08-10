package web.lab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lab.Entities.Point;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findAllByNickname(String nickname);
}
