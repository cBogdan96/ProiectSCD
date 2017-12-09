package edu.utcluj.track.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    @RequestMapping(  value = "/all", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> read() {

        return positionService.readPosition();
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> readPositionFromTerminal(@RequestParam("terminalId") String terminalId , @RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate) throws ParseException {
        LocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter("yyyy-MM-dd HH:mm:ss");

        LocalDateTime sdate = localDateTimeConverter.convert(startDate);
        LocalDateTime edate = localDateTimeConverter.convert(endDate);

        Date stDate = new Date(Timestamp.valueOf(sdate).getTime());
        Date enDate = new Date(Timestamp.valueOf(edate).getTime());

        return positionService.readPositionFromTerminal(terminalId,stDate,enDate);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Produces(MediaType.APPLICATION_JSON)
    public Position createPosition(@RequestBody Position p) {
        return positionService.save(p);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Produces(MediaType.APPLICATION_JSON)
    public void  updatePosition(@RequestBody Position p) {
        if(p.getId() == null)
            throw new IllegalArgumentException("The id is mandatory for UPDATE!");
        positionService.save(p);
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathVariable Long  id) {
        positionService.deletePositionService(id);
    }

}
