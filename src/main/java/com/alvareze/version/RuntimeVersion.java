package com.alvareze.version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Backport of Java Runtime version information found in JDK version 10 and later.
 * This code with with Java versions 5 and later.
 */
public final class RuntimeVersion {

    /**
     * A representation of the current
     * Java&nbsp;SE Platform version.
     */
    private static Version version;

    /** Don't let anyone else instantiate this class */
    private RuntimeVersion() {}

    /**
     * Returns the version of the Java Runtime Environment as a {@link Version}.
     *
     * @return  the {@link Version} of the Java Runtime Environment
     */
    public static Version version() {
        if (version == null) {
            version = Version.getRuntimeVersion();
        }
        return version;
    }

    /**
     * A representation of version information of the
     * Java&nbsp;SE Platform.  Version information consists of feature,
     * interim and update numbers.
     *
     * <blockquote><pre>
     * $FEATURE.$INTERIM.$UPDATE
     * </pre></blockquote>
     *
     * <ul>
     *
     * <li><p> <a id="FEATURE">{@code $FEATURE}</a> &#x2014; The
     * feature release number, incremented for every major feature release.</p></li>
     *
     * <li><p> <a id="INTERIM">{@code $INTERIM}</a> &#x2014; The
     * interim release number, incremented for non-feature releases that
     * contain compatible bug fixes and enhancements but no incompatible
     * changes, no feature removals, and no changes to standard APIs.
     * </p></li>
     *
     * <li><p> <a id="UPDATE">{@code $UPDATE}</a> &#x2014; The update version
     * number, incremented for compatible update releases that fix security
     * issues, regressions, and bugs in newer features. </p></li>
     *
     * </ul>
     */
    public static final class Version {
        private final List<Integer> version;

        /*
         * List of version number components passed to this constructor MUST
         * be at least unmodifiable (ideally immutable). In the case of an
         * unmodifiable list, the caller MUST hand the list over to this
         * constructor and never change the underlying list.
         */
        private Version(List<Integer> unmodifiableListOfVersions) {
            this.version = unmodifiableListOfVersions;
        }


        /**
         * Returns the version of the Java Runtime Environment as a {@link Version}.
         *
         * @return  the {@link Version} of the Java Runtime Environment
         */
        private static Version getRuntimeVersion() {
            Version ver = null;
            int featureVersion = getFeatureVersion();
            if (featureVersion > 8) {
                ver = getVersionListJava9AndNewer(featureVersion);
            } else { // else Java versions 1.8, 1.7, 1.6 and 1.5.
                ver = getVersionListJava8AndOlder(featureVersion);
            }
            return ver;
        }

        /**
         * Get version information on Java runtime version 9 or newer.
         * @param def the default feature version value
         * @return  the {@link Version} of the Java Runtime Environment
         */
        @SuppressWarnings("unchecked")
        private static RuntimeVersion.Version getVersionListJava9AndNewer(Integer def) {
            List<Integer> versions = new ArrayList<Integer>();
            try {
                java.lang.reflect.Method runtimeVersionMethod = java.lang.Runtime.class.getMethod("version");
                Object versionObject = runtimeVersionMethod.invoke(java.lang.Runtime.class);
                java.lang.reflect.Method versionMethod = versionObject.getClass().getMethod("version");
                versions.addAll((List<Integer>) versionMethod.invoke(versionObject));
            } catch(java.lang.Exception ex) {
                // error accessing. should never happen.
                ex.printStackTrace();
            }
            if (versions.isEmpty()) {
                versions.add(def);
            }
            return new Version(versions);
        }

        /**
         * Get version information on Java runtime version 8 or older.
         * @param def the default feature version value
         * @return  the {@link Version} of the Java Runtime Environment
         */
        private static RuntimeVersion.Version getVersionListJava8AndOlder(Integer def) {
            return parse(System.getProperty("java.version", def.toString()));
        }

        /**
         *
         * @return the current feature version
         */
        private static int getFeatureVersion() {
            return Integer.parseInt(
                    System.getProperty("java.class.version", "0.0").split("\\.")[0])-44;
        }

        /**
         * Parses the given string as a valid
         * <a href="#verStr">version string</a> containing a
         * <a href="#verNum">version number</a> followed by pre-release and
         * build information.
         *
         * @param  s
         *         A string to interpret as a version
         *
         * @throws  IllegalArgumentException
         *          If the given string cannot be interpreted as a valid
         *          version
         *
         * @throws  NullPointerException
         *          If the given string is {@code null}
         *
         * @throws  NumberFormatException
         *          If an element of the version number or the build number
         *          cannot be represented as an {@link Integer}
         *
         * @return  The Version of the given string
         */
        public static RuntimeVersion.Version parse(String s) {
            if (s == null) {
                throw new NullPointerException();
            }
            List<Integer> versionList = new ArrayList<Integer>();
            if (s.startsWith("1.")) {
                s = s.substring(2);
            }
            for (String ver : s.split("[^\\d]")) {
                versionList.add(Integer.parseInt(ver, 10));
            }
            return new RuntimeVersion.Version(versionList);
        }

        /**
         * Returns the value of the <a href="#FEATURE">feature</a> element of
         * the version number.
         *
         * @return The value of the feature element
         */
        public int feature() {
            return version.get(0);
        }

        /**
         * Returns the value of the <a href="#INTERIM">interim</a> element of
         * the version number, or zero if not present.
         *
         * @return The value of the interim element, or zero
         */
        public int interim() {
            return (version.size() > 1 ? version.get(1) : 0);
        }

        /**
         * Returns the value of the <a href="#UPDATE">update</a> element of the
         * version number, or zero if not present.
         *
         * @return The value of the update element, or zero
         */
        public int update() {
            return (version.size() > 2 ? version.get(2) : 0);
        }

        /**
         * Returns an unmodifiable {@link java.util.List List} of the integers
         * represented in the <a href="#verNum">version number</a>.
         * The {@code List} always contains at least one element corresponding to
         * the <a href="#FEATURE">feature version number</a>.
         *
         * @return  An unmodifiable list of the integers
         *          represented in the version number
         */
        public List<Integer> version() {
            return Collections.unmodifiableList(version);
        }
    }

}
