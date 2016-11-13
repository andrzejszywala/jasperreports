package pl.aszywala.dynamic;

import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;

import com.jaspersoft.jasperserver.api.metadata.common.service.RepositoryService;
import com.jaspersoft.jasperserver.api.metadata.jasperreports.service.ReportDataSourceService;

public class DynamicDataSourceService implements ReportDataSourceService {

	JRDataSource ds;
	private RepositoryService repository;
	private Map propertyMap;
	
	public Map getPropertyMap() {
		return propertyMap;
	}

	public void setPropertyMap(Map propertyMap) {
		this.propertyMap = propertyMap;
	}

	public DynamicDataSourceService() {
		this.ds = new DynamicDataSource();
	}
	
	public DynamicDataSourceService(JRDataSource ds) {
		this.ds = ds;
	}
	
	public void closeConnection() {
		// Do nothing
	}

	public void setReportParameterValues(Map parameterValues) {
		parameterValues.put(JRParameter.REPORT_DATA_SOURCE, ds);
	}

	public RepositoryService getRepository() {
		return repository;
	}

	public void setRepository(RepositoryService repository) {
		this.repository = repository;
	}

}
