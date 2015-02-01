package tw.edu.ncu.cc.activity.server.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v1.Club;
import tw.edu.ncu.cc.activity.server.controller.api.ApplicationController;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.service.ClubService;

@RestController
@RequestMapping( method = RequestMethod.GET )
public class ClubController extends ApplicationController {

    private ClubService clubService;

    @Autowired
    public void setClubService( ClubService clubService ) {
        this.clubService = clubService;
    }

    @RequestMapping( value = "v1/club" )
    public Club[] getClubs() {
        return convert(
                clubService.getAllClubs(), ClubEntity.class, Club.class
        );
    }

}
