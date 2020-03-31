package jdev.novid.model.radar.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jdev.novid.common.value.MacAddress;
import jdev.novid.model.domain.User;

public interface RadarService {

    public Location addLocation(User user, BigDecimal lat, BigDecimal lng, MacAddress mac, LocalDateTime collectedAt);

    public BluetoothDevice addDevice(User user, MacAddress self, MacAddress nearBy, String deviceName, BigDecimal lat,
            BigDecimal lng, LocalDateTime collectedAt);

}
