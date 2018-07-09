package biz.meziant.service;

import com.pi4j.io.gpio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ronan on 17/12/16.
 */
@Service
public class SesamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SesamService.class);

    @Value("${application.profile.test}")
    private boolean isTest;

    public void openTheGates() throws InterruptedException {

        if (isTest) {
            LOGGER.info("Open the gates!");
        } else {

            final GpioController gpio = GpioFactory.getInstance();

            GpioPinDigitalOutput pin;

            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "MyLED", PinState.HIGH);

            // set shutdown state for this pin
            pin.setShutdownOptions(true, PinState.LOW);

            System.out.println("--> GPIO state should be: ON");

            Thread.sleep(1000);

            // turn off gpio pin #01
            pin.low();
            System.out.println("--> GPIO state should be: OFF");

            // stop all GPIO activity/threads by shutting down the GPIO controller
            // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
            gpio.shutdown();

            // Unprovision the pin
            gpio.unprovisionPin(pin);

        }
    }
}
