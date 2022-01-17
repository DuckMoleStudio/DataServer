package DataServer.kpi;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class KPI {
    int busStopsFootHome;
    int busStopsFootWork;
    int toMetroBusHome;
    int toMetroBusWork;
    int toMetroBusFootHome;
    int toMetroBusFootWork;
    int toMetroCarHome;
    int toMetroCarWork;
    int homeTotal;
    int workTotal;
}
