import java.util.Objects;

public class Book {
    private Long id;
    private String name;
    private String category;
    private Integer score;
    private String intro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Book(Long id, String name, String category, Integer score, String intro) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.score = score;
        this.intro = intro;
    }

    public Book() {
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", intro='" + intro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(category, book.category) && Objects.equals(score, book.score) && Objects.equals(intro, book.intro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, score, intro);
    }
}
