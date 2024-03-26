package fr.morin.horloge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class HeureMinuteTest {
    private HeureMinute time;
    @BeforeEach
    void initialise() throws Exception {
        time = new HeureMinute((byte) 8,(byte) 14);
    }

    @Test
    void avancerMinute8_14_12() {
        time.avancerMinute(12);
        assertEquals(8,time.getHeure());
        assertEquals(26,time.getMinute());
    }

    @Test
    void avancerMinute8_14_51() {
        time.avancerMinute(51);
        assertEquals(9,time.getHeure());
        assertEquals(5,time.getMinute());
    }

    @Test
    void avancerMinute8_14_73() {
        time.avancerMinute(73);
        assertEquals(9,time.getHeure());
        assertEquals(27,time.getMinute());
    }

    @Test
    void avancerMinute8_14_125() {
        time.avancerMinute(125);
        assertEquals(10,time.getHeure());
        assertEquals(19,time.getMinute());
    }

    @Test
    void avancerMinute20_04_303() throws Exception {
        time.setHeureMinute(20,4);
        time.avancerMinute(303);
        assertEquals(1,time.getHeure());
        assertEquals(7,time.getMinute());
    }

    @Test
    void avancerMinute3_56_1441() throws Exception {
        time.setHeureMinute(3,56);
        time.avancerMinute(1441);
        assertEquals(3,time.getHeure());
        assertEquals(57,time.getMinute());
    }

    @Test
    void reculerMinute8_14_12() {
        time.avancerMinute(-12);
        assertEquals(8,time.getHeure());
        assertEquals(2,time.getMinute());
    }

    @Test
    void reculerMinute8_14_16() {
        time.avancerMinute(-16);
        assertEquals(7,time.getHeure());
        assertEquals(58,time.getMinute());
    }

    @Test
    void reculerMinute8_14_70() {
        time.avancerMinute(-70);
        assertEquals(7,time.getHeure());
        assertEquals(4,time.getMinute());
    }

    @Test
    void reculerMinute8_14_121() {
        time.avancerMinute(-121);
        assertEquals(6,time.getHeure());
        assertEquals(13,time.getMinute());
    }

    @Test
    void reculerMinute3_56_241() throws Exception {
        time.setHeureMinute(3,56);
        time.avancerMinute(-241);
        assertEquals(23,time.getHeure());
        assertEquals(55,time.getMinute());
    }

    @Test
    void reculerMinute3_56_1441() throws Exception {
        time.setHeureMinute(3,56);
        time.avancerMinute(-1441);
        assertEquals(3,time.getHeure());
        assertEquals(55,time.getMinute());
    }
}