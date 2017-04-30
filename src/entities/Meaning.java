package entities;

/**
 * Created by aliubivyi on 17.04.17.
 */
public class Meaning {
    private  int idMeaning;
    private String word;
    private String meaning;

    public Meaning(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meaning meaning = (Meaning) o;

        if (idMeaning != meaning.idMeaning) return false;
        if (!word.equals(meaning.word)) return false;
        return this.meaning.equals(meaning.meaning);
    }

    @Override
    public int hashCode() {
        int result = idMeaning;
        result = 31 * result + word.hashCode();
        result = 31 * result + meaning.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Meaning{" +
                "idMeaning=" + idMeaning +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }

    public int getIdMeaning() {
        return idMeaning;
    }

    public void setIdMeaning(int idMeaning) {
        this.idMeaning = idMeaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Meaning() {
    }

    public Meaning(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Meaning(int idMeaning, String word, String meaning) {

        this.idMeaning = idMeaning;
        this.word = word;
        this.meaning = meaning;
    }
}
