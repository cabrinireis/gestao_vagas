package cabrini.gestao_vagas.modules.company.controllers;

import cabrini.gestao_vagas.modules.company.entities.JobEntity;
import cabrini.gestao_vagas.modules.company.entities.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntity create(@RequestBody @Valid JobEntity jobEntity) {
        return this.createJobUseCase.execute(jobEntity);
    }
}
