import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.htmlhifive.pitalium.core.PtlTestBase;

public class SampleTest extends PtlTestBase {

    @Test
    public void test() throws Exception {
        // 1. hifiveサイトのトップページを開きます
        driver.get("http://www.htmlhifive.com/conts/web/view/Main/?language=ja");

        // 2. hifiveサイトのトップページのスクリーンショットを撮影します
        assertionView.assertView("OpenhifiveTopPage");

        // 3. "#about" に表示されているタイトルが正しいことをチェックします
        WebElement about = driver.findElementById("about");
        WebElement title = about.findElement(By.tagName("h2"));
        assertThat(title.getText(), is("hifiveとは"));
    }
    
    @Test
    public void testClickAndCapture() throws Exception {
        // 1. hifiveサイトのトップページを開きます
        driver.get("http://www.htmlhifive.com/conts/web/view/Main/?language=ja");

        // 2. hifiveサイトのトップページのスクリーンショットを撮影します。
        assertionView.assertView("OpenhifiveTopPage");

        // 3. "過去のお知らせ一覧" ボタン要素を取得してクリックします。
        WebElement infoHistoryButton = driver.findElementByCssSelector("#news a.btn");
        infoHistoryButton.click();

        // 4. ページ遷移後のスクリーンショットを撮影します。
        assertionView.assertView("OpenNewsListPage");
    }
}