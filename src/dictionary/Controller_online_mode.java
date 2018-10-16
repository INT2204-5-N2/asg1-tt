package dictionary;


import javafx.scene.*;
import javafx.fxml.*;
import javafx.scene.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.web.*;

public class Controller_online_mode {

    public TextArea txt_Search;
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
    public void onEnter(ActionEvent ae) throws Exception {
        this.search(ae);
    }
    public void read_word(ActionEvent actionEvent) throws IOException{
        String fileName = "read.vbs";
        String key = txt_Search.getText();

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("CreateObject(\"SAPI.SpVoice\").Speak\""+key+"\"");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        Runtime.getRuntime().exec("wscript " + fileName);
//        VoiceManager voiceManager = VoiceManager.getInstance();
//        Voice voice = voiceManager.getVoice("mike");
//
//        voice.allocate();
//        try {
//            voice.speak("hello");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

    }
    //homework.uet@gmail.com



}
