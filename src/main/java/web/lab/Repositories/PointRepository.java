package web.lab.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import web.lab.Entities.Point;


import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {

    Page<Point> findAllByNickname(String nickname, Pageable pageable);
}
