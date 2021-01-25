package decathlon;

import java.util.HashMap;

public final class Constants {

    public static final HashMap<String, Double> M_100 = new HashMap<String, Double>() {{
        put("A", 25.4347);
        put("B", 18.0);
        put("C", 1.81);
    }};

    public static final HashMap<String, Double> LONG_JUMP = new HashMap<String, Double>() {{
        put("A", 0.14354);
        put("B", 220.0);
        put("C", 1.4);
    }};

    public static final HashMap<String, Double> SHOT_PUT = new HashMap<String, Double>() {{
        put("A", 51.39);
        put("B", 1.5);
        put("C", 1.05);
    }};

    public static final HashMap<String, Double> HIGH_JUMP = new HashMap<String, Double>() {{
        put("A", 0.8465);
        put("B", 75.0);
        put("C", 1.42);
    }};

    public static final HashMap<String, Double> M_400 = new HashMap<String, Double>() {{
        put("A", 1.53775);
        put("B", 82.0);
        put("C", 1.81);
    }};

    public static final HashMap<String, Double> HURDLES_100M = new HashMap<String, Double>() {{
        put("A", 5.74352);
        put("B", 28.5);
        put("C", 1.92);
    }};

    public static final HashMap<String, Double> DISCUS_THROW = new HashMap<String, Double>() {{
        put("A", 12.91);
        put("B", 4.0);
        put("C", 1.1);
    }};

    public static final HashMap<String, Double> POLE_VAULT = new HashMap<String, Double>() {{
        put("A", 0.2797);
        put("B", 100.0);
        put("C", 1.35);
    }};

    public static final HashMap<String, Double> JAVELIN_THROW = new HashMap<String, Double>() {{
        put("A", 10.14);
        put("B", 7.0);
        put("C", 1.08);
    }};

    public static final HashMap<String, Double> M_1500 = new HashMap<String, Double>() {{
        put("A", 0.03768);
        put("B", 480.0);
        put("C", 1.85);
    }};

}
