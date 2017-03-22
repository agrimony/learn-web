package novel.util;

import novel.model.Book;
import novel.model.BookInfo;
import novel.model.CrawelArticle;
import novel.model.CrawelBook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hou on 12/20/16.
 */
public class Crawel {
    private String baseUrl;

    public Crawel(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Crawel crawel = new Crawel("http://www.qu.la/");
//        crawel.getBookLinks("http://www.qu.la/wangyouxiaoshuo/");
//        crawel.getBookInfo("http://www.qu.la/book/1518/");
        crawel.getBookArticleLinks("http://www.qu.la/book/1518/",1);
//        crawel.getArticleInfo("http://www.qu.la/book/1518/881810.html", 1);
    }

    public List<CrawelBook> getBookLinks(String categoryUrl) {
        try {
            Document doc = Jsoup.connect(categoryUrl).timeout(10000).referrer(baseUrl).get();
//            Elements bookLinks=doc.select("span.s2 > a");
            Elements bookLinks = doc.select("div.l >ul >li");
            List<CrawelBook> books=new ArrayList<CrawelBook>();
            for (Element link : bookLinks) {
                Elements es = link.select("span.s2 > a");
                Elements es2 = link.select("span.s3 > a");
                CrawelBook crawelBook = new CrawelBook();
                crawelBook.setId(0);
                crawelBook.setBookLink(baseUrl + es.attr("href"));
                crawelBook.setBookName(es.text());
                crawelBook.setStatus(ChangeType.intToByte(0));
                crawelBook.setInsertTime(new Date());
                crawelBook.setLastArticleLink(baseUrl + es2.attr("href"));
                books.add(crawelBook);
//                System.out.println("book title:"+es.text()+",link:"+es.attr("href")+",newArticle:"+es2.text()+",newArticleLink:"+es2.attr("href"));
            }
            return books;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
//        getBookInfo();
    }

    public List<CrawelArticle> getBookArticleLinks(String bookURL,int bookId) {
        List<CrawelArticle> articles=new ArrayList<CrawelArticle>();
        try {
            Document doc = Jsoup.connect(bookURL).timeout(10000).referrer(baseUrl).get();
            Elements articleLinks = doc.select("dd > a");
            articleLinks.forEach(link->{
                CrawelArticle artcile=new CrawelArticle();
                artcile.setBookid(bookId);
                artcile.setInserttime(new Date());
                artcile.setStatus(ChangeType.intToByte(0));
                artcile.setArticletitle(link.text());
                artcile.setArticlelink(bookURL+link.attr("href"));
                articles.add(artcile);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articles;
//        getBookInfo();
    }

    public Book getBookInfo(String bookURL, int categoryId) throws IOException, InterruptedException {
        Document doc = Jsoup.connect(bookURL).timeout(10000).referrer(baseUrl).get();
        //get author e.g.
        String title = doc.select("div[id=\"info\"] >h1").text();
        String autor = doc.select("div[id=\"info\"] >p").get(0).text().replaceAll("[作|' '|者：]", "");//
        String summary = doc.select("div[id=\"intro\"] >p").text();
        String imgUrl = doc.select("div[id=\"fmimg\"] >img").attr("src");
//        String lastArticleLink=doc.select("div[id=\"info\"] >p >a").get(3).attr("href");
        Book book = new Book();
        book.setImg(imgUrl);
        book.setName(title);
        book.setAuthor(autor);
        book.setCategoryId(ChangeType.intToByte(categoryId));
        book.setCreatetime(new Date());
        book.setDesc(summary);
        book.setStatus(ChangeType.intToByte(0));
        return book;
//        book.setLastpagetitle("");
//        System.out.println("title:["+title+"],author:["+autor+"]");
//        System.out.println("summary = [" + summary + "]");
//        System.out.println("imgUrl = [" + imgUrl + "]");
//        System.out.println("lastArticleLink = [" + lastArticleLink + "]");
        //get articles link
//        Elements articleLinks=doc.select("dd > a");
//        for (Element el :articleLinks) {
//            System.out.println(el.text()+":"+el.attr("href"));
//            int id=Integer.parseInt(el.attr("href").replace(".html",""));
//            System.out.println(id);
////            if(id>=6895118){
//                StringBuilder sb=new StringBuilder();
//                sb.append(el.text());
//                sb.append("\r\n");
//                getArticleInfo(doc.baseUri()+el.attr("href"),sb);
////            }
//
//        }
    }

    public BookInfo getArticleInfo(String articleURL, int bookId)  {
        Document doc = null;
        BookInfo bookInfo = new BookInfo();
        try {
            doc = Jsoup.connect(articleURL).timeout(10000).get();
            //        String title= doc.select("div[id=\"info\"] >h1").text();
//        String autor=doc.select("div[id=\"info\"] >p").text()
            String con = doc.select("div[id=\"content\"]").html().replace("<script>readx();</script>", "").replaceAll("[<br>]", "");//.replace("&nbsp;&nbsp;&nbsp;&nbsp;","");

            bookInfo.setBookid(bookId);
            bookInfo.setContent(con);
//        System.out.println("articleURL = [" + articleURL + "], con = [" + con + "]");
            return bookInfo;
        } catch (IOException e) {
            return null;
//            bookInfo.setBookid(bookId);
//            return bookInfo;
//            e.printStackTrace();
        }


    }
}
