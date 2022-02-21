package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SqlRuParse implements Parse {

    private static final Pattern PATTERN = Pattern.compile("java", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        List<Post> listJobs = new SqlRuParse().list("https://www.sql.ru/forum/job-offers/");
        for (var el : listJobs) {
            System.out.println(el);
        }
    }

    @Override
    public List<Post> list(String link) {
        List<Post> rsl = new ArrayList<>();
        try {
            for (int i = 1; i < 6; i++) {
                Document doc = Jsoup.connect(link + i).get();
                Elements row = doc.select(".postslisttopic");
                for (int j = 0; j < row.size(); j++) {
                    Element href = row.get(j).child(0);
                    if (PATTERN.matcher(href.text()).find()) {
                        rsl.add(new SqlRuParse().detail(href.attr("href")));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public Post detail(String link) {
        Post rsl = null;
        try {
            Document doc = Jsoup.connect(link).get();
            Elements rowHeader = doc.select(".messageHeader");
            String head = rowHeader.get(0).text();
            Elements rowBody = doc.select(".msgBody");
            String body = rowBody.get(1).text();
            Elements rowFooter = doc.select(".msgFooter");
            String date = rowFooter.get(0).text().substring(0, rowFooter.get(0).text().indexOf("[") - 1);
            rsl = new Post(
                    head,
                    link,
                    body,
                    new SqlRuDateTimeParser().parse(date)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}

