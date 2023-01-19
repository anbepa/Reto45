package co.com.bancolombia.certification.saf.models.enums;

public enum ManagementCSV {

	FILTRO("iduser");
	private String managementTypeData;

	private ManagementCSV(String managementTypeData) {
		this.setManagementTypeData(managementTypeData);
	}

	public String getManagementTypeData() {
		return managementTypeData;
	}

	private void setManagementTypeData(String managementTypeData) {
		this.managementTypeData = managementTypeData;
	}
}
