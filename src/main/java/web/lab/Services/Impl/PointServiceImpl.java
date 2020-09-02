package web.lab.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.lab.Entities.Point;
import web.lab.Repositories.PointRepository;
import web.lab.Services.PointService;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Point addPoint(Point point) {
        return pointRepository.saveAndFlush(point);
    }

    @Override
    public Page<Point> findAllByNickname(String nickname, Pageable pageable) {
        return pointRepository.findAllByNickname(nickname, pageable);
    }
}
