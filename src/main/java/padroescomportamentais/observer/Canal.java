package padroescomportamentais.observer;

import java.util.Observable;

public class Canal extends Observable {

    private String nome;

    public Canal(String nome){
        this.nome = nome;
    }

    public int getNumerodeInscritos(){
        return countObservers();
    }

    public void publicarVideo(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "Canal{nome='" + nome +"'}";
    }

}
