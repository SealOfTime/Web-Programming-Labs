package ru.sealoftime.weblab4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.sealoftime.weblab4.model.dto.PointSubmitDTO;
import ru.sealoftime.weblab4.model.entity.Point;
import ru.sealoftime.weblab4.model.entity.UserData;
import ru.sealoftime.weblab4.model.repository.PointRepository;
import ru.sealoftime.weblab4.model.response.PointResponse;
import ru.sealoftime.weblab4.service.areaService.AreaService;
import ru.sealoftime.weblab4.service.entityServices.pointService.PointService;
import ru.sealoftime.weblab4.service.entityServices.userService.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/points")
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;
    private final AreaService areaService;
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<PointResponse>> getAllPoints(){
        pointService.getAllPoints().forEach(System.out::println);
        return ResponseEntity.of(
                Optional.of(
                        pointService.getAllPoints()
                                .stream()
                                .map((entity)->
                                        new PointResponse(entity.getX(),
                                                entity.getY(),
                                                entity.getR(),
                                                entity.isInside(),
                                                entity.getColor(),
                                                entity.getUser().getUsername())
                                ).collect(Collectors.toList())
                )
        );
    }

    @PostMapping
    public ResponseEntity<PointResponse> checkPoint(@RequestBody @Valid PointSubmitDTO dto,
                                            @AuthenticationPrincipal UserDetails user){
        var point = areaService.checkPoint(dto);
        point.setUser(userService.findByUsername(user.getUsername()));
        System.out.println(point);
        point = pointService.addNewPoint(point);
        return ResponseEntity.of(
                Optional.of(new PointResponse(point.getX(),
                                              point.getY(),
                                              point.getR(),
                                              point.isInside(),
                                              point.getColor(),
                                              point.getUser().getUsername())));
    }

}
