package DataServer.kpi;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class KPI {
    int reachableStops;
    int reachableMetroBus;
    int reachableMetroBusFoot;
    int reachableMetroCar;
    int totalPopulation;
}
