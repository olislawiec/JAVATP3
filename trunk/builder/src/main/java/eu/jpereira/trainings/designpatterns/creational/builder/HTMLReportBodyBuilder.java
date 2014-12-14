package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.ReportBodyBuilder;

public class HTMLReportBodyBuilder implements ReportBodyBuilder {

        private HTMLReportBody reportBody;
        private boolean withItems = false;
        
        public HTMLReportBodyBuilder() {
                
                reportBody = new HTMLReportBody();
        }
        
        public ReportBodyBuilder setCustomerName(String customerName) {
                
                reportBody.putContent("<span class=\"customerName\">");
                reportBody.putContent(customerName);
                reportBody.putContent("</span>");
                return this;
        }

        public ReportBodyBuilder setCustomerPhone(String phoneNumber) {
                
                reportBody.putContent("<span class=\"customerPhone\">");
                reportBody.putContent(phoneNumber);
                reportBody.putContent("</span>");
                return this;
        }

        public ReportBodyBuilder withItems() {
                
                if (!withItems) {
                        reportBody.putContent("<items>");
                        withItems = true;
                }
                else {
                        reportBody.putContent("</items>");
                        withItems = false;
                }
                
                return this;
        }

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

        public ReportBodyBuilder endReport() {

                return this;
        }
        
        public ReportBody getReportBody() {
                
                return reportBody;
        }
}