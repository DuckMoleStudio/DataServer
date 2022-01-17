package DataServer.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "routes")
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "track_id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @Column(name = "short_name")
    private String shortName;
    @Column(name = "long_name")
    private String longName;

    @Transient
    private String regNum = "--";
    @Transient
    private String routeType = "--";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Route route = (Route) o;
        return id != 0 && Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
