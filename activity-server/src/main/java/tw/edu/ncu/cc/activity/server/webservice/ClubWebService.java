package tw.edu.ncu.cc.activity.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v1.Club;
import tw.edu.ncu.cc.activity.server.service.ClubService;

import java.util.List;

@RestController
@RequestMapping( method = RequestMethod.GET )
public class ClubWebService {

    private ClubService clubService;

    @Autowired
    public void setClubService( ClubService clubService ) {
        this.clubService = clubService;
    }

    @RequestMapping( value = "v1/club" )
    public List<Club> getClubs() {
        return clubService.getAllClubs();
    }

}
