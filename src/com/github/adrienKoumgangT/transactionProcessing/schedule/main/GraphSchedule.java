package com.github.adrienKoumgangT.transactionProcessing.schedule.main;


import java.util.List;
import java.util.Map;

public class GraphSchedule {

    /**
     * task list with number symbol representation
     */
    public List<Long> taches;

    // tache --> sa durée
    public Map<Long, Long> tachesDuree;

    // tache --> sa liste de successeurs
    public Map<Long, List<Long>> predecesseurs;

    // tache --> sa liste de successeurs
    public Map<Long, List<Long>> successeurs;


}
