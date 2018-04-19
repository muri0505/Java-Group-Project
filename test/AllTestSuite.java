
import hthurow.tomcatjndi.TomcatJNDI;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * a demo of JUnit 4 for running multiple set of test classes
 *
 * @author Shahriar (Shawn) Emami
 * @date December 29, 2017
 * @see <a href="https://www.youtube.com/watch?v=N8uZnPR5QVw">JUnit 4
 * tutorial(youtube)</a>
 * @see <a href="https://github.com/h-thurow/TomcatJNDI">TomcatJNDI for JUnit
 * 4</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    transferobjects.TitleTest.class, 
    business.TitlesLogicTest.class,
    transferobjects.EmployeeTest.class, 
    dataaccess.TitleDAOImplTest.class
    })
public class AllTestSuite {

    private static TomcatJNDI tomcatJNDI;

    @BeforeClass
    public static void setUpClass() {
        tomcatJNDI = new TomcatJNDI();
        tomcatJNDI.processContextXml(new File("web\\META-INF\\context.xml"));
        tomcatJNDI.processWebXml(new File("web\\WEB-INF\\web.xml"));
        tomcatJNDI.start();
    }

    @AfterClass
    public static void tearDownClass() {
        tomcatJNDI.tearDown();
    }
}
