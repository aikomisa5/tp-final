package com.TpFinal.Integracion.views.testBench.PersonaTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.TpFinal.Integracion.views.pageobjects.TBBusquedaInteresadoView;
import com.TpFinal.Integracion.views.pageobjects.TBLoginView;
import com.TpFinal.Integracion.views.pageobjects.TBMainView;
import com.TpFinal.Integracion.views.pageobjects.TBPersonaView;
import com.TpFinal.Integracion.views.testBench.TBUtils;
import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;

public class AddCriterioDeBusquedaIT extends TestBenchTestCase{

	private TBLoginView loginView;
	private TBMainView mainView;
	private TBPersonaView personaView;
	private TBBusquedaInteresadoView busquedaInteresadoView;

	@Rule
	public ScreenshotOnFailureRule screenshotOnFailureRule =
	new ScreenshotOnFailureRule(this, true);

	@Before
	public void setUp() throws Exception {
		Parameters.setScreenshotErrorDirectory(
				"Files/errors");
		Parameters.setMaxScreenshotRetries(2);
		Parameters.setScreenshotComparisonTolerance(1.0);
		Parameters.setScreenshotRetryDelay(10);
		Parameters.setScreenshotComparisonCursorDetection(true);
		setDriver(TBUtils.initializeDriver());

		loginView = TBUtils.loginView(this.getDriver());
		mainView=loginView.login();

		personaView = mainView.getPersonaView();


	}

	@Test
	public void agregarCriteriosDeBusqueda() {
		getDriver().get(TBUtils.getUrl("personas"));

		TBUtils.sleep(3000);
		Assert.assertTrue(personaView.isDisplayed());

		personaView.getCriterioButton("Accion 2").click();

		busquedaInteresadoView = new TBBusquedaInteresadoView(driver);

		busquedaInteresadoView.getTipoRadioButtonGroup().first().selectByText("Vivienda");

		busquedaInteresadoView.getEstadoRadioButtonGroup().first().selectByText("En Alquiler");

		List<String> provinciasList = busquedaInteresadoView.getProvinciaComboBox().first().getPopupSuggestions();
		String selectedProvincia = provinciasList.get(2);
		busquedaInteresadoView.getProvinciaComboBox().first().selectByText(selectedProvincia);
		
		List<String> localidadList = busquedaInteresadoView.getLocalidadComboBox().first().getPopupSuggestions();
		String selectedLocalidad = localidadList.get(2);
		busquedaInteresadoView.getLocalidadComboBox().first().selectByText(selectedLocalidad);
		
		busquedaInteresadoView.getPrecioMinimoTextField().setValue("224");
		
		busquedaInteresadoView.getPrecioMaximoTextField().setValue("772778");
		
		busquedaInteresadoView.getTipoMonedaRadioButtonGroup().first().selectByText("Dolares");
		
		busquedaInteresadoView.getGuardarButton().first().click();

	}



}
