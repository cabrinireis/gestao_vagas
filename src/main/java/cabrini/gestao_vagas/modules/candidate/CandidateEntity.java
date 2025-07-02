package cabrini.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "The field [username] is required")
    private String username;

    @Email(message = "The field [email] is required")
    private String email;

    private String password;
    private String description;
    private String curriculum;

}
