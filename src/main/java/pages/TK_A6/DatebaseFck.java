package pages.TK_A6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class DatebaseFck {

    @FindBy(xpath = "//*[@class=\"database\"]/a")
    @Getter
    private SelenideElement dbAuto;

    @FindBy(xpath = "")
    @Getter
    private SelenideElement listTableDb;

    @FindBy(xpath = "//*[@class=\"tabactive\"]")
    @Getter
    private SelenideElement clickSql;

    @FindBy(xpath = "(//*[@class=\"CodeMirror-scroll\"])[2]")
    @Getter
    private SelenideElement openFormSql;

    @Step("Вводим SQL-запрос")
    public void SqlRequest(String sql) {
       // $(By.xpath("//*[@name=\"db\"]")).sendKeys(sql);
        $(By.xpath("//*[@name=\"SQLQuery-Edit\"]")).sendKeys(sql);
 //       $(By.xpath("//*[@name=\"NavigationLogoLink\"]")).sendKeys(sql);
//        $(By.xpath("//*[@name=\"NavigationTreeTableSeparator\"]")).sendKeys(sql);
 //       $(By.xpath("//*[@name=\"NavigationTreeDbSeparator\"]")).sendKeys(sql);
        //$("#sqlqueryform").sendKeys(sql);
    }






}
