package se.ecutb.library_app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    @NotEmpty(message = "Title can't be empty")
    @JsonProperty("Title")
    private String title;
    @NotEmpty(message = "ISBN can't be empty")
    @Indexed(unique = true)
    private String isbn;
    @NotEmpty(message = "Author can't be empty")
    @JsonProperty("Author")
    private String author;
    @NotEmpty(message = "Available can't be empty")
    @JsonProperty("Available")
    private boolean isAvailable;
}
