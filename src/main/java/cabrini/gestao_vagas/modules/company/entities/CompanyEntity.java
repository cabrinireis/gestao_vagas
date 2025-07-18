package cabrini.gestao_vagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The field [username] is required")
    private String username;

    @Email(message = "The field [email] is required")
    private String email;

    @Length(min = 10, max = 100, message = "The text must be between 10 and 100 characters long.")
    private String password;

    private String website;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
