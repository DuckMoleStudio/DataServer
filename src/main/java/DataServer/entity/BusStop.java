package DataServer.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "bus_stops")
public class BusStop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "stop_id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BusStop busStop = (BusStop) o;
        return id != 0 && Objects.equals(id, busStop.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

