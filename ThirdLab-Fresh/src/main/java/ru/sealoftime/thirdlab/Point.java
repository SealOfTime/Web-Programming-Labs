package ru.sealoftime.thirdlab;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name="Points", schema="s284708", catalog="orbis")
public class Point implements Serializable, Comparable<Point>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Double x;
    private Double y;
    private Double r;
    private boolean inside;
    public Point(Double x, Double y){
        this.x=x;
        this.y=y;
    }
    public Point(){}

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public boolean isInside() {
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y) &&
                Objects.equals(r, point.r) &&
                Objects.equals(inside, point.inside);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, inside);
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result=" + inside +
                '}';
    }

    @Override
    public int compareTo(Point point) {
        return this.getId() - point.getId();
    }
}
