package com.alvareze.version;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for RuntimeVersion class.
 */
public class RuntimeVersionTest {

    /**
     * Unit test Java version 1.5.0_11 from Sun Microsystems Inc.
     */
    @Test
    public void testJavaVersion_Sun_1_5_0_11() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.5.0_11");
        assertEquals(5, version.feature());
        assertEquals(0, version.interim());
        assertEquals(11, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 1.5.0_22 from Sun Microsystems Inc.
     */
    @Test
    public void testJavaVersion_Sun_1_5_0_22() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.5.0_22");
        assertEquals(5, version.feature());
        assertEquals(0, version.interim());
        assertEquals(22, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 1.6.0_33 from Sun Microsystems Inc.
     */
    @Test
    public void testJavaVersion_Sun_1_6_0_33() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.6.0_33");
        assertEquals(6, version.feature());
        assertEquals(0, version.interim());
        assertEquals(33, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 1.7.0_71 from Oracle Corporation.
     */
    @Test
    public void testJavaVersion_Oracle_1_7_0_71() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.7.0_71");
        assertEquals(7, version.feature());
        assertEquals(0, version.interim());
        assertEquals(71, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 1.8.0_371 from IBM Corporation.
     */
    @Test
    public void testJavaVersion_IBM_1_8_0_371() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.8.0_371");
        assertEquals(8, version.feature());
        assertEquals(0, version.interim());
        assertEquals(371, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 1.8.0_402 from Temurin.
     */
    @Test
    public void testJavaVersion_Temurin_1_8_0_402() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.8.0_402");
        assertEquals(8, version.feature());
        assertEquals(0, version.interim());
        assertEquals(402, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 1.8.0_422 from Amazon.com Inc.
     */
    @Test
    public void testJavaVersion_Amazon_1_8_0_422() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("1.8.0_422");
        assertEquals(8, version.feature());
        assertEquals(0, version.interim());
        assertEquals(422, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 9.0.4 from Oracle Corporation.
     */
    @Test
    public void testJavaVersion_Oracle_9_0_4() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("9.0.4");
        assertEquals(9, version.feature());
        assertEquals(0, version.interim());
        assertEquals(4, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 9 from Oracle Corporation.
     */
    @Test
    public void testJavaVersion_Oracle_9() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("9");
        assertEquals(9, version.feature());
        assertEquals(0, version.interim());
        assertEquals(0, version.update());
        assertEquals(1, version.version().size());
    }

    /**
     * Unit test Java version 10.0.2 from Oracle Corporation.
     */
    @Test
    public void testJavaVersion_Oracle_10_0_2() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("10.0.2");
        assertEquals(10, version.feature());
        assertEquals(0, version.interim());
        assertEquals(2, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 11.0.8 from AdoptOpenJDK.
     */
    @Test
    public void testJavaVersion_AdoptOpenJDK_11_0_8() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("11.0.8");
        assertEquals(11, version.feature());
        assertEquals(0, version.interim());
        assertEquals(8, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 11.0.22 from Eclipse Adoptium.
     */
    @Test
    public void testJavaVersion_EclipseAdoptium_11_0_22() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("11.0.22");
        assertEquals(11, version.feature());
        assertEquals(0, version.interim());
        assertEquals(22, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 11.0.24 from Microsoft.
     */
    @Test
    public void testJavaVersion_Microsoft_11_0_24() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("11.0.24");
        assertEquals(11, version.feature());
        assertEquals(0, version.interim());
        assertEquals(24, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 17.0.10 from Eclipse Adoptium.
     */
    @Test
    public void testJavaVersion_EclipseAdoptium_17_0_10() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("17.0.10");
        assertEquals(17, version.feature());
        assertEquals(0, version.interim());
        assertEquals(10, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 21.0.2 from Eclipse Adoptium.
     */
    @Test
    public void testJavaVersion_EclipseAdoptium_21_0_2() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("21.0.2");
        assertEquals(21, version.feature());
        assertEquals(0, version.interim());
        assertEquals(2, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version 21.0.4 from Eclipse Adoptium.
     */
    @Test
    public void testJavaVersion_EclipseAdoptium_21_0_4() {
        RuntimeVersion.Version version = RuntimeVersion.Version.parse("21.0.4");
        assertEquals(21, version.feature());
        assertEquals(0, version.interim());
        assertEquals(4, version.update());
        assertEquals(3, version.version().size());
    }

    /**
     * Unit test Java version with running JRE.
     */
    @Test
    public void testJavaVersion_Current() {
        RuntimeVersion.Version version = RuntimeVersion.version();
        int featureVersion = Integer.parseInt(
                System.getProperty("java.class.version", "0.0").split("\\.")[0])-44;
        assertEquals(featureVersion, version.feature());
        if (version.update() > 0) {
            assertTrue(version.version().size() >= 3);
        }
    }

    /**
     * Unit test Java version with running JRE.
     */
    @Test
    public void testJavaVersion_NotNull() {
        RuntimeVersion.Version version = RuntimeVersion.version();
        assertTrue(version.feature() >= 0);
        assertTrue(version.interim() >= 0);
        assertTrue(version.update() >= 0);
        assertNotNull(version.version());
        assertTrue(!version.version().isEmpty());
    }

    /**
     * Unit test parse method with null parameter.
     */
    @Test
    public void testJavaVersion_ParseNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> RuntimeVersion.Version.parse(null),
                "Expected null pointer exception.");
    }

    /**
     * Unit test parse method with empty string parameter.
     */
    @Test
    public void testJavaVersion_ParseEmptyNumberFormatException() {
        assertThrows(NumberFormatException.class,
                () -> RuntimeVersion.Version.parse(""),
                "Expected Number Format exception.");

    }

    /**
     * Unit test parse method with an invalid version string parameter.
     */
    @Test
    public void testJavaVersion_ParseInvalidNumberFormatExceptio() {
        assertThrows(NumberFormatException.class,
                () -> RuntimeVersion.Version.parse("1."),
                "Expected Number Format exception.");

    }

}
