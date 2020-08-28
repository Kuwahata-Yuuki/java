package newss;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Weather{


public static void main(String[] args) {

	final int NEWS2 = 1;
	final int KEIZAI = 2;
	final int ENTAME = 3;
	final int SPORTS = 4;
	final int IT_KAGAKU = 5;


Elements newsHeadlines3;
Elements newsHeadlines2;

 String[] anss = new String[10];

	 Document doc = null;

	 ArrayList<String> list = new ArrayList<String>();
try {




 doc = Jsoup.connect("https://weathernews.jp/onebox/31.914600/131.408939/q=%E5%AE%AE%E5%B4%8E%E7%9C%8C%E5%AE%AE%E5%B4%8E%E5%B8%82&v=1a67d1e8af06515ba009f68450e8f57d7165779fe41e0667b8173c1fea45f4e8&lang=ja&type=day").get(); 


newsHeadlines3 = doc.select(".weather-now__cont");
newsHeadlines2 = doc.select(".weather-2day__item");
for (Element headline : newsHeadlines3) {


 System.out.println("現在時刻の天気: " + headline.text());
 
 


//lb1.setText("結果：" + headline.ownText());

}
for (Element headline2 : newsHeadlines2) {
	System.out.println("これから二日間の天気: "+"\n"+ headline2.text());
}
}catch(Exception ex){
	ex.printStackTrace();
}
}
}
