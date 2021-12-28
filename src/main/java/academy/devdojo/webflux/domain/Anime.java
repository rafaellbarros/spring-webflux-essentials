package academy.devdojo.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 28/12/2021
 */
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Table("tb_anime")
public class Anime {

    @Id
    private Integer id;

    @NotNull
    @NotEmpty(message = "The name of this anime cannot be empty")
    private String name;
}
