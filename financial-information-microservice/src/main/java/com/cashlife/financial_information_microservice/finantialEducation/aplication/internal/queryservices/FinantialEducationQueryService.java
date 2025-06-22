package com.cashlife.financial_information_microservice.finantialEducation.aplication.internal.queryservices;

import com.cashlife.financial_information_microservice.finantialEducation.domain.model.aggregates.FinantialEducation;
import com.cashlife.financial_information_microservice.finantialEducation.domain.model.entities.Preguntas;
import com.cashlife.financial_information_microservice.finantialEducation.domain.model.entities.Respuestas;
import com.cashlife.financial_information_microservice.finantialEducation.infrastructure.persistence.jpa.FinantialEducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinantialEducationQueryService {

    private final FinantialEducationRepository repository;
    private final PreguntasQueryService preguntasQueryService;
    private final RespuestasQueryService respuestasQueryService;

    public FinantialEducationQueryService(FinantialEducationRepository repository,
                                          PreguntasQueryService preguntasQueryService,
                                          RespuestasQueryService respuestasQueryService) {
        this.repository = repository;
        this.preguntasQueryService = preguntasQueryService;
        this.respuestasQueryService = respuestasQueryService;
    }

    public List<FinantialEducation> findAll() {
        return repository.findAll();
    }

    public Optional<FinantialEducation> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Preguntas> findPreguntaById(Long preguntaId) {
        return preguntasQueryService.findById(preguntaId);
    }

    public Optional<Respuestas> findRespuestaById(Long respuestaId) {
        return respuestasQueryService.findById(respuestaId);
    }
}
