package extention;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	Logger logger = Logger.getLogger(this.getClass().getName());
	private static final String START_TIME = "start time";

	@Override
	public void beforeTestExecution(ExtensionContext context) {
		getStore(context).put(START_TIME, System.currentTimeMillis());
	}

	@Override
	public void afterTestExecution(ExtensionContext context) {
		Method testMethod = context.getRequiredTestMethod();
		long startTime = getStore(context).remove(START_TIME, long.class);
		long duration = System.currentTimeMillis() - startTime;
		logger.info(() ->
		              String.format("# Timing # The Time to call Method [%s] to  %s ms.. Done", testMethod.getName(), duration));
	}

	private ExtensionContext.Store getStore(ExtensionContext context) {
		return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
	}

}
