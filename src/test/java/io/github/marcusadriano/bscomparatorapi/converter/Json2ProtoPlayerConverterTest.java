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
import java.util.List;

import static org.junit.Assert.*;

public class Json2ProtoPlayerConverterTest {

    private ResponseBody response;
    private final Json2ProtoPlayerConverter converter = new Json2ProtoPlayerConverter();

    @Before
    public void setUp() throws Exception {
        response = ResponseBody.create(MediaType.parse("application/json"), DataMass.BS_API_RESPONSE);
    }

    @Test
    public void convertTest() throws IOException {
        Player player = converter.convert(response);
        assertNotNull(player);
        assertEquals("ZEC0MEIA", player.getName());
        assertEquals("#9UV9UG9J", player.getTag());
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
        assertEquals("ZEC0MEIA", player.getName());
        assertEquals("#9UV9UG9J", player.getTag());
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
        assertEquals("#YRYL9U8U", club.getTag());
        assertEquals("Clube maneiro", club.getName());
    }

    @Test
    public void genericErrorTest() {
        response = ResponseBody.create(MediaType.parse("application/json"), "{...}");
        Player player = converter.convert(response);
        assertFalse(player.getSuccess());
    }

    @Test
    public void errorTest() {

    }

    @Test
    public void items() {
    }
}