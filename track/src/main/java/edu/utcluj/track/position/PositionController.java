package edu.utcluj.track.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@RestController
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    //value = "/{terminalId}"
    //@PathVariable("terminalId") String terminalId

    @RequestMapping( method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> read() {

        return positionService.readPosition();
    }

    @RequestMapping(value = "/{terminalId}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Position readPositionFromTerminal(@PathVariable("terminalId") String terminalId) {
        return positionService.readPositionFromTerminal(terminalId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Produces(MediaType.APPLICATION_JSON)
    public Position createPosition(@RequestBody Position p) {
        return positionService.createPositionService(p);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Produces(MediaType.APPLICATION_JSON)
    public void  updatePosition(@RequestBody Position p) {
        positionService.updatePositionService(p);
    }


    @RequestMapping(value = "/delete/{terminalId}",method = RequestMethod.DELETE)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@RequestBody String  terminalId) {
        positionService.deletePositionService(terminalId);
    }

}
