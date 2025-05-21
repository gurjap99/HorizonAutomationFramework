package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Data {
    public static final String BASE_URL = "https://www.horizonservices.com/";
    public static final String ELECTRICAL_URL = BASE_URL + "electrical-services";
    public static final String PLUMBING_URL = BASE_URL + "plumbing-services";
    public static final String HEATING_COOLING_URL = BASE_URL + "heating-and-cooling-services";
    public static final String LEARN_URL = BASE_URL + "learning-hub";
    public static final String FINANCING_URL = BASE_URL + "ways-to-save/financing";
    public static final String MEMBERSHIP_URL = BASE_URL + "ways-to-save/membership-program";
    public static final String OFFERS_REBATES_URL = BASE_URL + "ways-to-save/offers-and-rebates";
    public static final String WHY_HORIZON_URL = BASE_URL + "about-us/why-horizon";
    public static final String REVIEWS_URL = BASE_URL + "about-us/reviews";
    public static final String WORK_WITH_US_URL = BASE_URL + "about-us/work-with-us";
    public static final String CONTACT_US_URL = BASE_URL + "about-us/contact-us";

    public static final String[] FOOTER_MENU_ITEMS = {"Services", "Heating & Cooling", "Plumbing", "Electrical",
            "Quick Links", "Learn", "Financing", "Membership", "Offers & Rebates", "About Us", "Why Horizon", "Reviews",
            "Work With Us", "Contact Us"};

    public static final String STATIC_PHONE_NUMBER = "1-800-642-4419";

    public static final ArrayList<String> CATEGORY_LIST = new ArrayList<>(Arrays.asList("Heating & Cooling", "Plumbing",
            "Electrical", "Ways To Save", "About Us"));


    public static Map<String, ArrayList<String>> categoryServiceMap = new HashMap<>();
    static {
        categoryServiceMap.put("Heating & Cooling", new ArrayList<>(Arrays.asList(
                "Heating Maintenance", "Heating Repair", "Heating Installation",
                "AC Maintenance", "AC Repair", "AC Installation",
                "Ductless Mini-Splits", "HVAC Accessories", "Indoor Air Quality"
        )));
        categoryServiceMap.put("Plumbing", new ArrayList<>(Arrays.asList(
                "Water Heaters", "Kitchen & Bathroom", "Water Lines",
                "Drains & Sewer Lines", "Gas Lines", "Sump Pumps", "Well Pumps",
                "Water Treatment"
        )));
        categoryServiceMap.put("Electrical", new ArrayList<>(Arrays.asList(
                "Lighting & Ceiling Fans", "Electrical Panels & Circuit Breakers", "Electrical Wiring",
                "Electrical Remodeling", "Electric Vehicle Chargers", "Whole-House Generators",
                "Whole-House Surge Protectors"
        )));
    }
}
