package kds.at.restbackend.domain;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShipsInfo {
    private Integer id;
    private String name;
    private String description;
    private String level;
    private String buildYear;
    private String cabinLevel;
    private Integer passengerCnt;
}
