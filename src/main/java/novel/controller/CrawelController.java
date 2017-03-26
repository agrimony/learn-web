package novel.controller;

import novel.logic.model.CrawelListCondition;
import novel.model.CrawelArticle;
import novel.model.CrawelBook;
import novel.service.CrawelArticleService;
import novel.service.CrawelBookService;
import novel.util.Crawel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hou on 12/24/16.
 */
@Controller
@RequestMapping("/crawel")
public class CrawelController {
    @Autowired
    private CrawelBookService crawelBookService;
    @Autowired
    private CrawelArticleService crawelArticleService;

    /**
     * 抓取书籍列表
     * @return
     */
    @RequestMapping("crawelBooks")
    public ModelAndView crawelBook() {
        return new ModelAndView();
    }

    /**
     * 保存书籍列表
     * @return
     */
    @RequestMapping(value = "crawelBooks", method = RequestMethod.POST)
    public ModelAndView postCrawelBook() {
        //保持采集书记列表信息
        return null;
    }

    /**
     * 抓取书籍信息
     * @return
     */
    @RequestMapping(value="crawelBookInfo")
    public ModelAndView crawelBookInfo(){
        return new ModelAndView();
    }
    @RequestMapping(value="crawelBookInfo", method = RequestMethod.POST)
    public Object postCrawelBookInfo(){
        return null;
    }

    /**
     * 抓取文章
     * @return
     */
    @RequestMapping(value="crawelArticle")
    public ModelAndView crawelArticle(){
        return new ModelAndView();
    }
    @RequestMapping("crawel")
    public ModelAndView crawel() {
        return new ModelAndView();
    }

    @RequestMapping(value = "addCrawel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object addcrawelRule(@RequestBody CrawelListCondition crawel) {

        return new ModelAndView();
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public ModelAndView crawelBookList(@RequestParam(required = false, defaultValue = "0") int page,
                                       @RequestParam(required = false, defaultValue = "30") int rows) {
        int startIndex = page * rows;
        int endIndex = (page + 1) * rows;
        List<CrawelBook> pageBooks = crawelBookService.list(startIndex, endIndex);
        int crawelBookCount = crawelBookService.getCrawelBookCount();
//        Map<String,Object> model=new HashMap<String,Object>();
//        model.put("list",pageBooks);
//        model.put("count",crawelBookCount);
        ModelAndView model = new ModelAndView();
        model.addObject("list", pageBooks);
        model.addObject("count", crawelBookCount);

        return model;
    }

    @RequestMapping("/addcrawelBooks")
    public void addCrawelBooks() {
        String siteUrl = "http://www.qu.la";
        String categoryUrl = "http://www.qu.la/wangyouxiaoshuo/";
        Crawel crawel = new Crawel(siteUrl);
        List<CrawelBook> bookLinks = crawel.getBookLinks(categoryUrl);
        crawelBookService.addCrawelBookBatch(bookLinks);

    }

    @RequestMapping("/crawelArticles")
    public void addCrawelArticles(String bookUrl, String bookName) {
        Crawel crawel = new Crawel("http://www.qu.la");
        List<CrawelBook> books = crawelBookService.selectCrawelBooksByName(bookName);
        if (books.size() > 0) {
            List<CrawelArticle> articles = crawel.getBookArticleLinks(bookUrl, books.get(0).getId());
            articles.forEach(article -> {
                crawelArticleService.insertCrawelArticle(article);
            });
        } else {
            System.out.println("bookUrl = [" + bookUrl + "], bookName = [" + bookName + "],not in crawelbook table,please add");
        }
    }

}
