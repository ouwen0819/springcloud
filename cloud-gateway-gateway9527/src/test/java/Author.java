import java.util.List;
import java.util.Objects;

public class Author {
    private Long id;
    private String name;
    private Integer age;
    private String intro;
    private List<Book> bookList;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Author(Long id, String name, Integer age, String intro, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.intro = intro;
        this.bookList = bookList;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", intro='" + intro + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(age, author.age) && Objects.equals(intro, author.intro) && Objects.equals(bookList, author.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, intro, bookList);
    }
}
