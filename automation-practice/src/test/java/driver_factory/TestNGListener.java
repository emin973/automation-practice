package driver_factory;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.Reporter;

public class TestNGListener implements ITestListener{
	
	private Logger logger = Logger.getLogger(TestNGListener.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.createTest(result.getMethod().getMethodName());
		logger.info("onTestStart");
		
		try {
			//error
			throw new RuntimeException("error is thrown");
		} catch ( Exception e ) {
			logger.error(e.getMessage());
//			e.getStackTrace();
		}
		logger.error("error");
		logger.debug("debug");
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.step.pass("Test passed");
		logger.info("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.step.fail("Test failed: \n"+ result.getThrowable());
		logger.info("onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("onFinish");
	}
}