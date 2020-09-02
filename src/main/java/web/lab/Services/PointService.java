package web.lab.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import web.lab.Entities.Point;


import java.util.List;

public interface PointService {

    Point addPoint(Point point);
    Page<Point> findAllByNickname(String nickname, Pageable pageable);
}
