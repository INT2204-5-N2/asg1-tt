package dictionary;


import javafx.scene.*;
import javafx.fxml.*;
import javafx.scene.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.web.*;

public class Controller_online_mode {

    public TextField txt_Search;
    public WebView ww_Detail;
    public Button btn_Search;
    public String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbya-m__Jf-nl4OTxGIZ1LEupE8uc4Hysy8Sk6lBgk8Q1COKTk7e/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    public void search(ActionEvent actionEvent ) throws  Exception{
        try {

            String html = this.translate("en","vi",txt_Search.getText());
            html = "<html><body>" + html +"</body></html>";
            WebEngine webEngine = ww_Detail.getEngine();
            webEngine.loadContent(html);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



}
