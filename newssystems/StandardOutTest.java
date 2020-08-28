package newss;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StandardOutTest extends Frame implements ActionListener {
  Label lb1;
  TextField field1;
  StandardStreamPanel outarea;
  Button btn1;

  public static void main(String[] args) {
    new StandardOutTest();
  }

  public StandardOutTest(){
    Panel p = new Panel();
    p.setLayout(new GridLayout(2,1));
    lb1 = new Label("");
    p.add(lb1);
    field1 = new TextField();
    p.add(field1);
    //this.add(p,BorderLayout.NORTH);

    outarea = new StandardStreamPanel();
    this.add(outarea,BorderLayout.CENTER);

    btn1 = new Button("最新のニュースを出力する");
    btn1.addActionListener(this);
    this.add(btn1,BorderLayout.SOUTH);
    this.setSize(570,400);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent ev){
        System.exit(0);
      }
    });
  }

  public void actionPerformed(ActionEvent ev){
	  final int NEWS2 = 1;
		 final int KEIZAI = 2;
		 final int ENTAME = 3;
		 final int SPORTS = 4;
		 final int IT_KAGAKU = 5;
		 Elements newsHeadlines;

		  String[] anss = new String[10];

			 Document doc = null;

			 ArrayList<String> list = new ArrayList<String>();
    try {
      String n = field1.getText();
      int num = new java.util.Random().nextInt(5);
		 num++;
		 switch(num) {
		 case	NEWS2 : doc = Jsoup.connect("https://news.yahoo.co.jp/").get(); break;
		 case   KEIZAI : doc = Jsoup.connect("https://news.yahoo.co.jp/categories/business").get(); break;
		 case   ENTAME : doc = Jsoup.connect("https://news.yahoo.co.jp/categories/entertainment").get(); break;
		 case	SPORTS : doc = Jsoup.connect("https://news.yahoo.co.jp/categories/sports").get(); break;
		 case	IT_KAGAKU : doc = Jsoup.connect("https://news.yahoo.co.jp/categories/it").get(); break;

		 }
		 newsHeadlines = doc.select(".topicsList li.topicsListItem a");
	  for (Element headline : newsHeadlines) {


		  System.out.println("最新: " + headline.ownText()+"\n");


      //lb1.setText("結果：" + headline.ownText());
	  }
	  System.out.println("");
	  Elements newsHeadlines3;
	  Elements newsHeadlines2;
	  doc = Jsoup.connect("https://weathernews.jp/onebox/31.914600/131.408939/q=%E5%AE%AE%E5%B4%8E%E7%9C%8C%E5%AE%AE%E5%B4%8E%E5%B8%82&v=1a67d1e8af06515ba009f68450e8f57d7165779fe41e0667b8173c1fea45f4e8&lang=ja&type=day").get();


	  newsHeadlines3 = doc.select(".weather-now__cont");
	  newsHeadlines2 = doc.select(".weather-2day__item");
	  for (Element headline : newsHeadlines3) {


	   System.out.println("現在時刻に近い天気: "+"\n"+ headline.text());




	  //lb1.setText("結果：" + headline.ownText());

	  }
	  System.out.println("");
	  System.out.println("今日・明日の天気: ");
	  for (Element headline2 : newsHeadlines2) {
	  	System.out.println(headline2.text()+"\n");
	  }
	  System.out.println("");
    }catch(Exception ex){
      ex.printStackTrace();

    }
  }



class StandardStreamPanel extends Panel {

  public StandardStreamPanel(){
    super();
    this.setLayout(new GridLayout(1,1));
    OutputTextArea out = new OutputTextArea();
    out.setToSystemOut();
    this.add(out);
    /*OutputTextArea out2 = new OutputTextArea();
   out2.setToSystemOut();
    this.add(out2);*/

  }
}
}
