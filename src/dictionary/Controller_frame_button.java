package dictionary;

import javafx.fxml.FXML;
import java.io.IOException;

public class Controller_frame_button extends Main{
    private Main main;
    @FXML
    private void goOfflineMode() throws IOException{
        main.showOfflineMode();
    }
    @FXML
    private void goOnlineMode() throws IOException{
        main.showOnlineMode();
    }
    @FXML
    private void goCredit() throws IOException{
        main.showCredit();
    }
    @FXML
    private void goFrameAdd() throws IOException{
        main.showFrameAdd();
    }
}
