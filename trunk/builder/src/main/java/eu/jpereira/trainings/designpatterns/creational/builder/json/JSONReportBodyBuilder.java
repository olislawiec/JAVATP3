package eu.jpereira.trainings.designpatterns.creational.builder.json;

import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class JSONReportBodyBuilder implements ReportBodyBuilder {
	 
    JSONReportBody reportBody;
    boolean czyWywolanoNewItem;
    public JSONReportBodyBuilder(){
            reportBody = new JSONReportBody();
            czyWywolanoNewItem = false;
    }
    @Override
    public ReportBodyBuilder setCustomerName(String customerName) {
            reportBody.addContent("sale:{customer:{");
            reportBody.addContent("name:\"");
            reportBody.addContent(customerName);
            return this;
    }
 
    @Override
    public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
            reportBody.addContent("\",phone:\"");
            reportBody.addContent(phoneNumber);
            reportBody.addContent("\"}");
            return this;
    }
 
    @Override
    public ReportBodyBuilder withItems() {
            reportBody.addContent(",items:[");
            return this;
    }
 
    @Override
    public ReportBodyBuilder newItem(String name, int quantity, double price) {
            if(czyWywolanoNewItem){
                    reportBody.addContent(",");
            }
            else{
                    czyWywolanoNewItem = true;
            }
            reportBody.addContent("{name:\"");
            reportBody.addContent(name);
            reportBody.addContent("\",quantity:");
            reportBody.addContent(String.valueOf(quantity));
            reportBody.addContent(",price:");
            reportBody.addContent(String.valueOf(price));
            reportBody.addContent("}");
           
            return this;
    }
 
    @Override
    public ReportBody getReportBody() {
            // TODO Auto-generated method stub
            reportBody.addContent("]}");
            return reportBody;
    }
 
 
}