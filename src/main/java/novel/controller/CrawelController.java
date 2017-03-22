package novel.controller;

import novel.logic.model.CrawelListCondition;
import novel.model.CrawelArticle;
import novel.model.CrawelBook;
import novel.service.CrawelArticleService;
import novel.service.CrawelBookService;
import novel.util.Crawel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("crawel")
public ModelAndView crawel(){
    return new ModelAndView();
}
    @RequestMapping(value = "addCrawel",method = RequestMethod.POST)
    public ModelAndView addcrawelRule(@RequestParam(required = true) CrawelListCondition crawel){

        return new ModelAndView();
    }
    @RequestMapping(value="/booklist",method= RequestMethod.GET)
    public ModelAndView crawelBookList(@RequestParam(required = false, defaultValue = "0") int page,
                                       @RequestParam(required = false, defaultValue = "30") int rows){
        int startIndex=page*rows;
        int endIndex=(page+1)*rows;
        List<CrawelBook> pageBooks= crawelBookService.list(startIndex,endIndex);
        int crawelBookCount=crawelBookService.getCrawelBookCount();
//        Map<String,Object> model=new HashMap<String,Object>();
//        model.put("list",pageBooks);
//        model.put("count",crawelBookCount);
        ModelAndView model=new ModelAndView();
        model.addObject("list",pageBooks);
        model.addObject("count",crawelBookCount);

        return model;
    }
    @RequestMapping("/addcrawelBooks")
    public void addCrawelBooks(){
        String siteUrl="http://www.qu.la";
        String categoryUrl="http://www.qu.la/wangyouxiaoshuo/";
        Crawel crawel =new Crawel(siteUrl);
        List<CrawelBook> bookLinks= crawel.getBookLinks(categoryUrl);
        crawelBookService.addCrawelBookBatch(bookLinks);

    }
    @RequestMapping("/crawelArticles")
    public void addCrawelArticles(String bookUrl,String bookName){
        Crawel crawel =new Crawel("http://www.qu.la");
        List<CrawelBook> books= crawelBookService.selectCrawelBooksByName(bookName);
        if(books.size()>0){
          List<CrawelArticle> articles= crawel.getBookArticleLinks(bookUrl,books.get(0).getId());
            articles.forEach(article->{
                crawelArticleService.insertCrawelArticle(article);
            });
        }else{
            System.out.println("bookUrl = [" + bookUrl + "], bookName = [" + bookName + "],not in crawelbook table,please add");
        }
    }

}
