package cabrini.gestao_vagas.modules.candidate.controllers;

import cabrini.gestao_vagas.modules.candidate.CandidateEntity;
import cabrini.gestao_vagas.modules.candidate.useCase.CreateCandidateUseCase;
import cabrini.gestao_vagas.modules.candidate.useCase.ProfileCandidateUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody @Valid CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var idCandidade = request.getAttribute("candidade_id");

        try {
            var profile = this.profileCandidateUseCase.execute(UUID.fromString(idCandidade.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
