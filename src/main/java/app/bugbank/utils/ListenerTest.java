package app.bugbank.utils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        SeleniumUtils.takeScreenshot("SUCCESS_" + ScenarioSupport.getInstance().getTagsNames() + "_");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        SeleniumUtils.takeScreenshot("FAIL_" + ScenarioSupport.getInstance().getTagsNames() + "_");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){

    }

    @Override
    public void onStart(ITestContext iTestContext){}

    @Override
    public void onFinish(ITestContext iTestContext){

    }

}
