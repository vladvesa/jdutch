package com.vladv.jdutch.gatentekst;

import java.util.List;

import org.wicketstuff.annotation.mount.MountPath;

import com.vladv.jdutch.JDutchApplication;
import com.vladv.jdutch.pages.templates.EditExamPage;

@MountPath("/editgatentekst")
public class EditGatenTekstTestPage extends EditExamPage<GatenTekstTest> {

	@Override
	protected String getTestHelpMessage() {
		return "Input text and set to bold all the words that you want to be hidden in the test.<br/>\r\n" + 
				"   If the text is copied form office/internet than the text style is already set so make sure you select all the text and then hit the rubber button.<br/>\r\n" + 
				"   Then proceed with making the desired words bold.";
	}

	@Override
	protected GatenTekstTest getNewObject() {
		return new GatenTekstTest();
	}

	@Override
	protected void saveTest(GatenTekstTest test) {
		JDutchApplication.getApp().getGatenTekstTestRepository().save(test);
	}

	@Override
	protected void deleteTest(String testname) {
		JDutchApplication.getApp().getGatenTekstTestRepository().deleteGaatenTestByTestname(testname);
	}

	@Override
	protected List<GatenTekstTest> getTests(String category) {
		return JDutchApplication.getAllGatenTeksts(category);
	}

	@Override
	protected Class<? extends EditExamPage<?>> getEditPageClass() {
		return EditGatenTekstTestPage.class;
	}

  @Override
  protected List<String> getTestCategories() {
    return JDutchApplication.getAllGatenTekstCategories();
  }

}