package basic_tests;

import tests.BaseTest;
import org.testng.annotations.Test;

public class YoutubeTest extends BaseTest {

    @Test
    public void openYoutubeTest() {
        getDriver().navigate().to("https://www.youtube.com/");
        getDriver().navigate().refresh();

        System.out.println(getDriver().getTitle());
        getDriver().quit();
    }
}
