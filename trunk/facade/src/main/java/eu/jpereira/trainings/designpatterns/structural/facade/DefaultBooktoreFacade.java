package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBooktoreFacade implements BookstoreFacade{
	CustomerDBService customerService;
	BookDBService bookService;
	OrderingService orderingService;
	CustomerNotificationService customerNotificationService;
	WharehouseService warehouseService;
	public DefaultBooktoreFacade(
			CustomerDBService customerService,
			BookDBService bookService,
			OrderingService orderingService,
			CustomerNotificationService customerNotificationService,
			WharehouseService warehouseService)	{
		
		this.customerService = customerService;
		this.bookService = bookService;
        this.orderingService = orderingService;
        this.customerNotificationService = customerNotificationService;
        this.warehouseService = warehouseService;
	}


	@Override
	public void placeOrder(String customerId, String isbn) {
		Book X = bookService.findBookByISBN(isbn);
		Customer Y = customerService.findCustomerById(customerId);
        Order Z = orderingService.createOrder(Y, X);
        DispatchReceipt W = warehouseService.dispatch(Z);
        customerNotificationService.notifyClient(W);
                
	}	

}
