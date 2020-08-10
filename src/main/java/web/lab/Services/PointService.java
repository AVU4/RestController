package web.lab.Services;

import web.lab.Entities.Point;

import java.util.List;

public interface PointService {

    Point addPoint(Point point);
    List<Point> findAllByNickname(String nickname);
}
