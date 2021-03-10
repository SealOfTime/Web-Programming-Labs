package ru.sealoftime.weblab4.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sealoftime.weblab4.model.entity.Point;

@Repository
public interface PointRepository extends PagingAndSortingRepository<Point, Integer> {
    Iterable<Point> findAllByUser_Username(String username);
}
