package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator{
	   
    public WordCensor( SocialChannel x){
            this.delegate = x;
    }
   
    public WordCensor()
    {
           
    }
 
    @Override
    public void deliverMessage(String message) {
            if(message.contains("is")){
                    message = message.replaceAll("is", "***");
            }
            delegate.deliverMessage(message);
    }
 
}
