import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StreamTest {

    public static void main(String[] args) throws Throwable {
        //test01();
        //test02();
        //test03();
        //test04();
        //test05();
        //test06();
        //test07();
        //test08();
        test09();

    }

    private static void test09() {
        List<Author> authorList = getAuthors();
        authorList.stream()
                .map(Author::getAge)
                .forEach(a -> System.out.println(a > 18));
        System.out.println("******************************");
        authorList.stream()
                .mapToInt(Author::getAge)
                .map(age->age+10)
                .filter(age->age>22)
                .forEach(System.out::println);
    }

    private static void test08() {
        List<Author> authorList = getAuthors();
        authorList.stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 18).and(author -> author.getName().length() > 1))
                .forEach(author -> System.out.println(author.getName()));
        System.out.println("******************************");
        authorList.stream()
                .filter(author -> author.getAge() > 17 || author.getName().length() > 2).forEach(author -> System.out.println(author.getName()));
    }

    private static void test07() {
        Author author = getAuthor();
        Optional<Author> authorOptional = Optional.ofNullable(author);
        authorOptional.filter(author1 -> author.getAge() > 11).ifPresent(author1 -> System.out.println(author.getName()));
        System.out.println("******************************");
        Optional<Author> optionalAuthor = getAuthorOptional();
        optionalAuthor.map(author1 -> author1.getBookList())
                .ifPresent(books -> System.out.println(books));
        System.out.println("******************************");
        Optional<List<Author>> optionalAuthorList = getAuthorsOp();
        optionalAuthorList.ifPresent(authors -> System.out.println(authors));
    }

    private static Optional<List<Author>> getAuthorsOp() {

        Author author1 = new Author(1L, "梦多", 33, "超辣数据的礼服卡索家里发生的", null);
        Author author2 = new Author(2L, "索拉卡", 15, "啊手动阀手动阀十分", null);
        Author author3 = new Author(3L, "易", 14, "克劳福德共i和复活节", null);
        Author author4 = new Author(4L, "易", 14, "克劳福德共i和复活节", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "共发生撒旦发生", "哲学，爱情", 88, "客户过咯与荣誉i为"));
        books1.add(new Book(2L, "阿道夫更合适的", "哲学，爱情个人", 54, "而且配置v"));

        books2.add(new Book(3L, "奇葩了这么", "哲学，爱情", 85, "客户过咯与荣誉i为11111"));
        books2.add(new Book(3L, "奇葩了这么", "爱情", 85, "客户过咯与荣誉i为11111"));
        books2.add(new Book(4L, "哦i江湖私服", "爱情", 18, "iu很快就发卡说的话阿斯蒂芬"));

        books3.add(new Book(5L, "阿萨的破其味如", "哲学，爱情", 80, "在每次徐璐请问"));
        books3.add(new Book(6L, "去我批准撤销", "文学", 33, "欧派去合肥南站"));
        books3.add(new Book(6L, "去我批准撤销", "文学", 33, "欧派去合肥南站"));

        author1.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books3);
        author4.setBookList(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return Optional.ofNullable(authorList);

    }


    private static Optional<Author> getAuthorOptional() {
        Author author = new Author(2L, "索拉卡", 15, "啊手动阀手动阀十分", null);
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(3L, "奇葩了这么", "哲学，爱情", 85, "客户过咯与荣誉i为11111"));
        books1.add(new Book(3L, "奇葩了这么", "爱情", 85, "客户过咯与荣誉i为11111"));
        books1.add(new Book(4L, "哦i江湖私服", "爱情", 18, "iu很快就发卡说的话阿斯蒂芬"));

        author.setBookList(books1);
        return Optional.ofNullable(author);
    }

    private static void test06() throws Throwable {
        Author author = getAuthor();
        Optional<Author> authorOptional = Optional.ofNullable(author);
        Author orElseGet = authorOptional.orElseGet(() -> new Author());
        System.out.println(orElseGet);
        System.out.println("******************************");
        authorOptional.ifPresentOrElse(author1 -> System.out.println(author1.getName()), () -> System.out.println("111"));
        System.out.println("******************************");
        Author orElse = authorOptional.orElse(new Author(1l, "1234", 3, "543", new ArrayList<>()));
        System.out.println(orElse);
        System.out.println("******************************");
        Author orElseThrow = authorOptional.orElseThrow(() -> new Throwable("异常"));
        System.out.println(orElseThrow);
    }

    private static Author getAuthor() {
        Author author = new Author(1L, "梦多", 33, "超辣数据的礼服卡索家里发生的", null);
        return author;
    }

    private static void test05() {
        Author author = getAuthor();
        Optional<Author> authorOptional = Optional.ofNullable(author);
        authorOptional.ifPresent(author1 -> System.out.println(author1.getAge()));
    }

    private static void test04() {
        List<Author> authorList = getAuthors();
        Integer reduce = authorList.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println(reduce);

        Optional<Integer> reduce1 = authorList.stream()
                .map(author -> author.getAge())
                .reduce((a, b) -> a > b ? a : b);
        System.out.println("reduce1 = " + reduce1);

    }

    private static void test03() {
        List<Author> authorList = getAuthors();
        Integer integer = authorList.stream()
                .map(Author::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println(integer);

    }

    private static void test02() {
        List<Author> authorList = getAuthors();
        Optional<Author> authorOptional = authorList.stream()
                .sorted((a, b) -> a.getAge() - b.getAge())
                .findFirst();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test01() {
        List<Author> authorList = getAuthors();
        Optional<Author> optionalAuthor = authorList.stream()
                .filter(author -> author.getAge() > 11)
                .findAny();

        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }


    private static List<Author> getAuthors() {

        Author author1 = new Author(1L, "梦多", 33, "超辣数据的礼服卡索家里发生的", null);
        Author author2 = new Author(2L, "索拉卡", 15, "啊手动阀手动阀十分", null);
        Author author3 = new Author(3L, "易", 14, "克劳福德共i和复活节", null);
        Author author4 = new Author(4L, "易", 14, "克劳福德共i和复活节", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "共发生撒旦发生", "哲学，爱情", 88, "客户过咯与荣誉i为"));
        books1.add(new Book(2L, "阿道夫更合适的", "哲学，爱情个人", 54, "而且配置v"));

        books2.add(new Book(3L, "奇葩了这么", "哲学，爱情", 85, "客户过咯与荣誉i为11111"));
        books2.add(new Book(3L, "奇葩了这么", "爱情", 85, "客户过咯与荣誉i为11111"));
        books2.add(new Book(4L, "哦i江湖私服", "爱情", 18, "iu很快就发卡说的话阿斯蒂芬"));

        books3.add(new Book(5L, "阿萨的破其味如", "哲学，爱情", 80, "在每次徐璐请问"));
        books3.add(new Book(6L, "去我批准撤销", "文学", 33, "欧派去合肥南站"));
        books3.add(new Book(6L, "去我批准撤销", "文学", 33, "欧派去合肥南站"));

        author1.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books3);
        author4.setBookList(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;

    }
}
