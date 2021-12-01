package day6.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Region {
//region_id
    @JsonProperty("region_id")   //instead of  region_id we can do regionId using annotation @JsonProperty
    private int regionId;

    private String region_name;
    private List<Link> links;
}

