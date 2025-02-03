package com.exercici0305;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Torneig {

    private ArrayList<Participant> participants;

    public Torneig() {
        this.participants = new ArrayList<>();
    }

    public void afegirParticipant(Participant p) {
        participants.add(p);
    }

    public void competir() {
        for (Participant participant : participants) {
            if (participant instanceof Competidor){
                ((Competidor)participant).competir();
            }
        }
    }

    public void entrenar() {
        for (Participant participant : participants) {
            if (participant instanceof Esportista){
                ((Esportista)participant).entrenar();
            }
        }
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void printParticipants() {
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }
}
