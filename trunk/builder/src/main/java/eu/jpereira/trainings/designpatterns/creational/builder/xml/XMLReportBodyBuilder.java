package eu.jpereira.trainings.designpatterns.creational.builder.xml;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class XMLReportBodyBuilder implements ReportBodyBuilder{
 
    XMLReportBody reportBody;
   
    public XMLReportBodyBuilder(){
            reportBody = new XMLReportBody();
    }
    @Override
    public ReportBodyBuilder setCustomerName(String customerName) {
            reportBody.putContent("<sale><customer><name>");
            reportBody.putContent(customerName);
           
            return this;
    }
 
    @Override
    public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
            reportBody.putContent("</name><phone>");
            reportBody.putContent(phoneNumber);
            reportBody.putContent("</phone></customer>");
            return this;
    }
 
    @Override
    public ReportBodyBuilder withItems() {
            reportBody.putContent("<items>");
            return this;
    }
 
    @Override
    public ReportBodyBuilder newItem(String name, int quantity, double price) {
            reportBody.putContent("<item><name>");
            reportBody.putContent(name);
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(quantity);
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(price);
            reportBody.putContent("</price></item>");
            return this;
    }
 
    @Override
    public ReportBody getReportBody() {
            reportBody.putContent("</items></sale>");
            return reportBody;
    }
 
}