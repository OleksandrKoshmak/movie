package movie.demo.dto;

import lombok.Value;

@Value
public class MovieResponseDto {
    private Integer id;
    private String title;
    private int rate;
}
