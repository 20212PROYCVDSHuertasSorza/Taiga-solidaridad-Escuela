package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Answers;

import java.util.List;

public interface AnswersService {
    public abstract void pushAnswers(Answers Answers) throws SolidaridadException;

    public abstract List<Answers> searchAnswers() throws SolidaridadException;

    Answers searchAnswers(String name)throws SolidaridadException;
}