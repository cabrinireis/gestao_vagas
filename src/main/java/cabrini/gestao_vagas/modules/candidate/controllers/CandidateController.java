package cabrini.gestao_vagas.modules.candidate.controllers;

import cabrini.gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody @Valid CandidateEntity candidateEntity) {
        System.out.println(candidateEntity.getUsername());
        System.out.println(candidateEntity.getEmail());
        return ResponseEntity.ok().build();
    }
}
