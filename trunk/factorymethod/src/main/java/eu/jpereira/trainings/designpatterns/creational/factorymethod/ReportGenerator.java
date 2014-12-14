package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public  abstract class ReportGenerator {
       
 
        public Report generateReport(ReportData data, String type) {
 
                Report generatedReport = intantiateReport();
 
                generatedReport.generateReport(data);
 
                return generatedReport;
 
                }
 
                protected abstract Report intantiateReport();
}