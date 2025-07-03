package Runner;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.files.FilesUploadRequest;
import com.slack.api.methods.response.files.FilesUploadResponse;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import utils.Config;
import utils.Listeners;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static Config config = new Config("dev");
        public static void main(String[] args) {
            //this is to test commit
            Listeners listeners = new Listeners();

            // Create object of TestNG Class
            TestNG runner = new TestNG();
            List<String> suitefiles = new ArrayList<>();

            // Add xml file which you have to execute
            suitefiles.add("testng.xml");
            runner.setTestSuites(suitefiles);
            runner.addListener(listeners);

            // finally execute the runner using run method
            runner.run();
//                slackNotifier(listeners.getPassed(), listeners.getFailed(), listeners.getSkipped());
        }

        public static void slackNotifier(int passed, int failed, int skipped){
    String message = "Test Result:\nPassed: " + passed + "\nFailed: "+failed+ "\nSkipped: "+ skipped;

        try {
        URL url = new URL(config.getProperty("slack_webhook_url"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        String payload = "{\"text\": \"" + message + "\"}";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(payload.getBytes());
            os.flush();
        }

        int responseCode = conn.getResponseCode();
        System.out.println("Slack response code: " + responseCode);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public static void uploadExtentReport(String filePath, String slackChannel, String slackToken) {
        Slack slack = Slack.getInstance();

        try {
            FilesUploadRequest request = FilesUploadRequest.builder()
                    .channels(List.of(slackChannel))  // e.g., "#test-results"
                    .initialComment("🧪 Automation Test Report")
                    .file(new File(filePath))         // e.g., "/reports/extent.html"
                    .filename("extent.html")
                    .title("Extent Report")
                    .build();

            FilesUploadResponse response = slack.methods(slackToken).filesUpload(request);

            if (response.isOk()) {
                System.out.println("✅ Report uploaded to Slack successfully.");
            } else {
                System.err.println("❌ Failed to upload report: " + response.getError());
            }
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
        }
    }
    }
