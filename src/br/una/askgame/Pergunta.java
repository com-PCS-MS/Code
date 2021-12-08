package br.una.askgame;

public class Pergunta {
    
    int id;
    String respostaCerta;
    String enunciado;
    Alternativa alternativaA;
    Alternativa alternativaB;
    Alternativa alternativaC;
    Alternativa alternativaD;
    
    public Pergunta(){}
    
    public Pergunta(int id, String respostaCerta, String enunciado, Alternativa a, Alternativa b, Alternativa c, Alternativa d){
        this.id = id;
        this.respostaCerta = respostaCerta;
        this.enunciado = enunciado;
        this.alternativaA = a;
        this.alternativaB = b;
        this.alternativaC = c;
        this.alternativaD = d;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Alternativa getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(Alternativa alternativaA) {
        this.alternativaA = alternativaA;
    }

    public Alternativa getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(Alternativa alternativaB) {
        this.alternativaB = alternativaB;
    }

    public Alternativa getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(Alternativa alternativaC) {
        this.alternativaC = alternativaC;
    }

    public Alternativa getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(Alternativa alternativaD) {
        this.alternativaD = alternativaD;
    }
}
