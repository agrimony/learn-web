package novel.controller;

import novel.model.Book;
import novel.model.BookInfo;
import novel.model.CrawelArticle;
import novel.model.CrawelBook;
import novel.service.BookInfoService;
import novel.service.BookService;
import novel.service.CrawelArticleService;
import novel.service.CrawelBookService;
import novel.util.ChangeType;
import novel.util.Crawel;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by hou on 12/20/16.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CrawelBookService crawelBookService;
    @Autowired
    private CrawelArticleService crawelArticleService;
    @Autowired
    private BookInfoService bookInfoService;
@RequestMapping(value="/add")
public void showBook(){

}
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public void addBook(int bookid, int categoryId) {
        CrawelBook cbook = crawelBookService.selectByPrimaryKey(bookid);
        Crawel crawel = new Crawel("http://www.qu.la");
        if (cbook != null && cbook.getId() > 0) {
            try {
                Book book = crawel.getBookInfo(cbook.getBookLink(), categoryId);
                int insertBookId = bookService.insert(book);
                if (insertBookId > 0) {

                    List<CrawelArticle> cArticles = crawelArticleService.selectCrawelArticlesByBookId(cbook.getId());
                    cArticles.forEach(artLink -> {
                        BookInfo info = crawel.getArticleInfo(artLink.getArticlelink(), insertBookId);
                        if(info!=null){
                        info.setTitle(artLink.getArticletitle());
                        int id = bookInfoService.insert(info);
                        if (id > 0&&info.getContent().length()>0) {
                            CrawelArticle ca = new CrawelArticle();
                            ca.setId(artLink.getId());
                            ca.setStatus(ChangeType.intToByte(1));
                            crawelArticleService.updateCrawelArticleStatus(ca);
                        } else {
                            CrawelArticle ca = new CrawelArticle();
                            ca.setId(artLink.getId());
                            ca.setStatus(ChangeType.intToByte(2));
                            crawelArticleService.updateCrawelArticleStatus(ca);
                        }}else{
                            BookInfo info1=new BookInfo();
                            info1.setTitle(artLink.getArticletitle());
                            info1.setBookid(insertBookId);
                            CrawelArticle ca = new CrawelArticle();
                            ca.setId(artLink.getId());
                            ca.setStatus(ChangeType.intToByte(2));
                            crawelArticleService.updateCrawelArticleStatus(ca);
                        }


                    });
//
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
