package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        SqlRuDateTimeParser editDate = new SqlRuDateTimeParser();
        for (int i = 0; i < 5; i++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + i).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element href = td.child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
                Element date = td.parent().child(5);
                System.out.println(editDate.parse(date.text()));
            }
        }
    }

    private static Post detail(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        Elements rowHeader = doc.select(".messageHeader");
        String head = rowHeader.get(0).text();
        Elements rowBody = doc.select(".msgBody");
        String body = rowBody.get(1).text();
        Elements rowFooter = doc.select(".msgFooter");
        String date = rowFooter.get(0).text().substring(0, rowFooter.get(0).text().indexOf("[") - 1);
        return new Post(
                head,
                link,
                body,
                new SqlRuDateTimeParser().parse(date)
        );
    }
}

