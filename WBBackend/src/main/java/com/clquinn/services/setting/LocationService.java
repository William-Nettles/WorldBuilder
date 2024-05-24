package com.clquinn.services.setting;

import com.clquinn.daos.setting.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationDAO locationDAO;

    @Autowired
    public LocationService(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

}
