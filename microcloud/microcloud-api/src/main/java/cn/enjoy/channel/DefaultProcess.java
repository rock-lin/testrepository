package cn.enjoy.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DefaultProcess {

	public static final String OUTPUT = "enjoy_output";
	public static final String INPUT = "enjoy_input";
	
	@Input(DefaultProcess.INPUT)
	public SubscribableChannel input();
	@Output(DefaultProcess.OUTPUT)
	public MessageChannel output();
}
