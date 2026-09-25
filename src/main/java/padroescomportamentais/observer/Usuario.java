package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    @Override
    public void update(Observable canal, Object arg1) {
        this.ultimaNotificacao = this.nome + ", novo vídeo publicado no " + canal.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
