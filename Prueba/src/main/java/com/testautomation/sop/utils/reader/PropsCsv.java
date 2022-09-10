package com.testautomation.sop.utils.reader;



import com.testautomation.sop.models.enums.ManagementCSV;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PropsCsv {

	private PropsCsv() {
	}

	public static List<Map<String, String>> getDataCsv(String nombreCSV, String filtro) throws IOException {
		TestDataSource testData = new CSVTestDataSource("src/test/resources/DataDriven/" + nombreCSV + ".csv", ',');
		return convertirDataCsvLista(testData, filtro);
	}

	public static List<Map<String, String>> convertirDataCsvLista(TestDataSource dataPrueba, String filtro) {
		List<Map<String, String>> dataCargada = dataPrueba.getData();
		if ("".equals(filtro)) {
			return dataCargada;
		}
		String[] arrayDatosParaFiltrar = filtro.split(",");
		return filtrarDataCSV(arrayDatosParaFiltrar, dataCargada);
	}

	public static List<Map<String, String>> filtrarDataCSV(String[] array, List<Map<String, String>> dataCargada) {
		return dataCargada.stream().filter(fila -> inArray(array, fila.get(ManagementCSV.FILTRO.getManagementTypeData()))).collect(Collectors.toList());
	}

	public static boolean inArray(String[] arr, String item) {
		if (arr.length > 0) {
			for (String n : arr) {
				if (item.equals(n)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static Map<String, String> getDataCsvMap(String nombreCSV, String filtro) throws IOException {
		return getDataCsv(nombreCSV, filtro).get(0);
	}
}