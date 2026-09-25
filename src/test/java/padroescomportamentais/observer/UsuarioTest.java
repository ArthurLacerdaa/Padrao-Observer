package padroescomportamentais.observer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarioTest {

    @Test
    void deveNotificarUmUsuario() {
        Canal canal = new Canal("Padrões de Projeto com Marcão");
        Usuario usuario = new Usuario("Arthur");
        canal.addObserver(usuario);
        canal.publicarVideo();

        Assertions.assertEquals( "Arthur, novo vídeo publicado no Canal{nome='Padrões de Projeto com Marcão'}", usuario.getUltimaNotificacao());

    }

    @Test
    void deveNotificarTodosUsuarios() {
        Canal canal = new Canal("Padrões de Projeto com Marcão");
        Usuario usuario1 = new Usuario("Arthur");
        Usuario usuario2 = new Usuario("Sarah");
        canal.addObserver(usuario1);
        canal.addObserver(usuario2);
        canal.publicarVideo();

        Assertions.assertEquals( "Arthur, novo vídeo publicado no Canal{nome='Padrões de Projeto com Marcão'}", usuario1.getUltimaNotificacao());

        Assertions.assertEquals( "Sarah, novo vídeo publicado no Canal{nome='Padrões de Projeto com Marcão'}", usuario2.getUltimaNotificacao());

    }

    @Test
    void naodeveNotificarUsuarioNaoInscrito() {
        Canal canal = new Canal("Padrões de Projeto com Marcão");
        Usuario usuario1 = new Usuario("Arthur");
        canal.publicarVideo();

        Assertions.assertEquals(null, usuario1.getUltimaNotificacao());

    }

    @Test
    void deveNotificarSOmenteUsuarioDoCanal() {
        Canal canal1 = new Canal("Padrões de Projeto com Marcão");
        Canal canal2 = new Canal("CazeTV");
        Usuario usuario1 = new Usuario("Arthur");
        Usuario usuario2 = new Usuario("Sarah");
        canal1.addObserver(usuario1);
        canal2.addObserver(usuario2);
        canal1.publicarVideo();

        Assertions.assertEquals( "Arthur, novo vídeo publicado no Canal{nome='Padrões de Projeto com Marcão'}", usuario1.getUltimaNotificacao());

        Assertions.assertEquals(null, usuario2.getUltimaNotificacao());
    }

    @Test
    void deveContarInscritos() {
        Canal canal = new Canal("Padrões de Projeto com Marcão");
        Usuario usuario1 = new Usuario("Arthur");
        Usuario usuario2 = new Usuario("Sarah");

        Assertions.assertEquals(0, canal.getNumerodeInscritos());

        canal.addObserver(usuario1);
        canal.addObserver(usuario2);

        Assertions.assertEquals(2, canal.getNumerodeInscritos());
    }

}

