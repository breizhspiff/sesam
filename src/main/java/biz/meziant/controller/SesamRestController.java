package biz.meziant.controller;

import biz.meziant.controller.model.SesamOpenRequest;
import biz.meziant.controller.model.SesamResponse;
import biz.meziant.model.Event;
import biz.meziant.repository.EventRepository;
import biz.meziant.service.SesamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronan on 17/12/16.
 */
@RestController
@RequestMapping("/sesams")
public class SesamRestController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SesamService sesamService;

    @RequestMapping(method = RequestMethod.POST)
    public void open(@RequestBody SesamOpenRequest request) throws InterruptedException {
        Event openEvent = new Event();
        openEvent.setSource(request.getFrom());

        // Open the gates!
        sesamService.openTheGates();

        eventRepository.save(openEvent);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SesamResponse> list() {

        List<SesamResponse> response = new ArrayList<>();

        eventRepository.findAll().forEach(event -> {
            SesamResponse sesamResponse = new SesamResponse();
            sesamResponse.setDateTime(new SimpleDateFormat("\"yyyy-MM-dd HH:mm:ss\"").format(event.getCreatedDate()));
            sesamResponse.setFrom(event.getSource());

            response.add(sesamResponse);
        });
        return response;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");

        String str = "Hello World!";
        mav.addObject("message", str);

        return mav;
    }
}
