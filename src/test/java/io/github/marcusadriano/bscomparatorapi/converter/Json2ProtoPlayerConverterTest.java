package io.github.marcusadriano.bscomparatorapi.converter;

import io.github.marcusadriano.Brawler;
import io.github.marcusadriano.Player;
import io.github.marcusadriano.utils.DataMass;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Json2ProtoPlayerConverterTest {

    private static final String ACCESS_DENIED_INVALID_IP = "accessDenied.invalidIp";
    private static final String APPLICATION_JSON = "application/json";
    private static final String ZEC0MEIA = "ZEC0MEIA";
    private static final String ZEC0MEIA_TAG = "#9UV9UG9J";
    private static final String CLUB_TAG = "#YRYL9U8U";
    private static final String CLUB_NAME = "Clube maneiro";
    private static final String INVALID_JSON = "{...}";

    private ResponseBody response;
    private final Json2ProtoPlayerConverter converter = new Json2ProtoPlayerConverter();

    @Before
    public void setUp() throws Exception {
        response = ResponseBody.create(MediaType.parse(APPLICATION_JSON), DataMass.BS_API_RESPONSE);
    }

    @Test
    public void convertTest() throws IOException {
        Player player = converter.convert(response);
        assertNotNull(player);
        assertEquals(ZEC0MEIA, player.getName());
        assertEquals(ZEC0MEIA_TAG, player.getTag());
        assertTrue(player.getBrawlersCount() > 0);
        assertNotNull(player.getClub());
        assertEquals(player.getBestRoboRumbleTime(), 0, 0);
        assertEquals(player.getBestTimeAsBigBrawler(), 0, 0);
        assertEquals(player.getExpPoints(), 123284, 0);
        assertEquals(player.getTrophies(), 18731, 0);
        assertTrue(player.getSuccess());
    }


    @Test
    public void playerTest() throws IOException {
        Player player = converter.convert(response);
        assertNotNull(player);
        assertEquals(ZEC0MEIA, player.getName());
        assertEquals(ZEC0MEIA_TAG, player.getTag());
        assertTrue(player.getBrawlersCount() > 0);
        assertNotNull(player.getClub());
        assertEquals(player.getBestRoboRumbleTime(), 0, 0);
        assertEquals(player.getBestTimeAsBigBrawler(), 0, 0);
        assertEquals(player.getExpPoints(), 123284, 0);
        assertEquals(player.getTrophies(), 18731, 0);
        assertTrue(player.getSuccess());
    }

    @Test
    public void brawlersTest() throws IOException {
        JSONObject apiResponse = new JSONObject(DataMass.BS_API_RESPONSE);
        Iterable<Brawler> brawlers = converter.brawlers(apiResponse);
        assertNotNull(brawlers);
        assertTrue(brawlers.iterator().hasNext());
    }

    @Test
    public void clubTest() throws IOException {
        JSONObject jsonObject = new JSONObject(response.string());
        Player.Club club = converter.club(jsonObject);
        assertEquals(CLUB_TAG, club.getTag());
        assertEquals(CLUB_NAME, club.getName());
    }

    @Test
    public void genericErrorTest() {
        response = ResponseBody.create(MediaType.parse(APPLICATION_JSON), INVALID_JSON);
        Player player = converter.convert(response);
        assertFalse(player.getSuccess());
        assertEquals(Json2ProtoPlayerConverter.KEY_ERROR_JSON_PARSE_ERROR, player.getError().getReason());
    }

    @Test
    public void errorTest() {
        response = ResponseBody.create(MediaType.parse(APPLICATION_JSON), DataMass.BS_API_ERROR_RESPONSE);
        Player player = converter.convert(response);
        assertFalse(player.getSuccess());
        assertEquals(ACCESS_DENIED_INVALID_IP, player.getError().getReason());
    }

    @Test
    public void items() {
    }
}