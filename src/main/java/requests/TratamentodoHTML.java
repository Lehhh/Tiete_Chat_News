package requests;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

public class TratamentodoHTML {

    ArrayList<String> urlNewsBegin = new ArrayList<String>();
    ArrayList<String> urlNewsEnd = new ArrayList<String>();
    ArrayList<String> urlNewsEndAux = new ArrayList<String>();
    ArrayList<String> urlNewsComplete = new ArrayList<String>();
    ArrayList<String> urlNewsCompleteAux = new ArrayList<String>();
    Requests rq = new Requests();
    String response = "", html = "", urlnews = "";
    int inicio = 0, fim = 0, i;

    public String getHTML(String url, String iniciohtml, String fimhtml) throws IOException {
        response = rq.executeGet(url);

        inicio = response.indexOf(iniciohtml);
        response = response.substring(inicio);
        fim = response.indexOf(fimhtml);
        html = response.substring(0, fim);
        html = Strings.INICIO_HTML + html + Strings.FIM_HTML;

        return html;
    }

    //criar laço for 3 , array com urls das noticias
    //metodo de teste News()
//    public String getNews() throws IOException{
//        response = rq.executeGet("http://www.daee.sp.gov.br/index.php?option=com_content&view=category&layout=blog&id=48&Itemid=53");        
//        inicio = response.indexOf("<a href=\"/index.php?view=arti");
//        response = response.substring(inicio).replace("<a href=", "");
//        fim = response.indexOf(" title=\"Impr");
//        urlnews1 = response.substring(0, fim);
//        System.out.println(urlnews1);
//        return urlnews1;
//}
    public ArrayList<String> getArrayBeginUrlNews() throws IOException {
        response = rq.executeGet(Strings.URL_NEWS);

        for (i = 0; i < 3; i++) {

            inicio = response.indexOf("<a href=\"/index.php?view=arti");
            response = response.substring(inicio + 9).replaceFirst("<a href\"", "");
            urlNewsBegin.add(response);
        }

        return urlNewsBegin;
    }

    public ArrayList<String> getArrayEndUrlNews() throws IOException {
        urlNewsEndAux = getArrayBeginUrlNews();
        for (i = 0; i < urlNewsEndAux.size(); i++) {
//            System.out.println(urlNews.get(i));
            fim = urlNewsEndAux.get(i).indexOf("\" title=\"Impr");
            urlnews = urlNewsEndAux.get(i).substring(0, fim);
            urlNewsEnd.add(urlnews);
        }
        return urlNewsEnd;
    }
    
    public ArrayList<String> getArrayCompleteUrlNews() throws IOException{
        urlNewsCompleteAux = getArrayEndUrlNews();
        for(i = 0; i< urlNewsCompleteAux.size(); i++){
            html = Strings.URL_DAEE +  urlNewsCompleteAux.get(i);
            urlNewsComplete.add(html);
//            System.out.println(html);
        }
        
        return urlNewsComplete;
    }
}
