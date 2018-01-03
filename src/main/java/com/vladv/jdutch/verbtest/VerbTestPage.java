package com.vladv.jdutch.verbtest;

import java.util.List;
import java.util.Set;

import org.apache.wicket.request.IRequestParameters;
import org.wicketstuff.annotation.mount.MountPath;

import com.vladv.jdutch.JDutchApplication;
import com.vladv.jdutch.pages.templates.TestPage;

@MountPath("/verbs")
public class VerbTestPage extends TestPage<VerbTest> {

	@Override
	protected List<VerbTest> getTests() {
		return JDutchApplication.getAllVerbs();
	}

	@Override
	protected String appendJavascriptOnTestClick() {
		return "callSomeJs();";
	}

	@Override
	protected String takeTest(String obj, IRequestParameters requestParameters) throws Exception {
		Set<String> parameterNames = requestParameters.getParameterNames();

		return "TODO " + parameterNames.size();
	}

}