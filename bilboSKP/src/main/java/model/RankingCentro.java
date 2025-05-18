package model;

import java.math.BigDecimal;

public class RankingCentro {

    private int id_ranking, id_centro, id_aula;
    private BigDecimal puntuacion_media;

    @Override
    public String toString() {
        return "RankingCentro [id_ranking=" + id_ranking + ", id_centro=" + id_centro + ", id_aula=" + id_aula
                + ", puntuacion_media=" + puntuacion_media + "]";
    }

    public RankingCentro(int id_ranking, int id_centro, int id_aula, BigDecimal puntuacion_media) {
        this.id_ranking = id_ranking;
        this.id_centro = id_centro;
        this.id_aula = id_aula;
        this.puntuacion_media = puntuacion_media;
    }

    public RankingCentro() {
    }

    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public BigDecimal getPuntuacion_media() {
        return puntuacion_media;
    }

    public void setPuntuacion_media(BigDecimal puntuacion_media) {
        this.puntuacion_media = puntuacion_media;
    }
}