
//นายดิศรณ์  ฐิติกรโกวิท  5810400990
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"classpath:features/manage_account.feature"}
)
public class UATAdd {

}
