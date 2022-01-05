package DataServer.kpi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class KPI_01 {
    int homeReachable;
    int workReachable;
    int homeTotal;
    int workTotal;
    double homeRatio;
    double workRatio;
}
